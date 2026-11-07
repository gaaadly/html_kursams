# Recipes app

A small React app for managing recipes: add, edit, delete, search, filter by category and view the full description.

**Stack:** React 19, Vite, Tailwind CSS, React Router, React Hook Form + Zod, Axios, json-server.

---

## 1. Quick start

Open a terminal in the project folder and run:

```bash
npm install        # downloads all libraries listed in package.json into node_modules
npm run server     # terminal 1: starts the fake API on http://localhost:3000
npm run dev        # terminal 2: starts the React app (usually http://localhost:5173)
```

Both `server` and `dev` must be running at the same time, so use two terminals.

| Command | What it does |
|---|---|
| `npm install` | Installs dependencies. Needed once, and again whenever `package.json` changes |
| `npm run server` | Runs json-server, which turns `data/db.json` into a REST API |
| `npm run dev` | Runs the Vite dev server (the React app, with hot reload) |
| `npm run build` | Creates the production build in `dist/` |
| `npm run lint` | Checks the code with ESLint |

Quick check that the backend works: open `http://localhost:3000/recipes` in the browser. You should see the recipes as JSON.

---

## 2. How the app fits together

Data flows in one direction:

```
data/db.json -> json-server -> services (axios) -> App.jsx (state) -> pages / components -> screen
```

- **`data/db.json`** is the fake database.
- **json-server** serves it as an API. Every top-level key becomes an address, so the key `"recipes"` becomes `http://localhost:3000/recipes`.
- **services/** are small functions that send requests to that API.
- **`App.jsx`** loads the recipes and keeps them in state.
- **pages and components** get the data as props and display it.

### Folder structure

```
recipes_app/
├── .env                       address of the API (VITE_API_URL)
├── data/db.json               the database (collection "recipes")
├── index.html                 the only HTML page, contains <div id="root">
├── vite.config.js             tells Vite to use the React and Tailwind plugins
├── eslint.config.js           code-quality rules
└── src/
    ├── main.jsx               starts React, enables routing
    ├── App.jsx                loads data, keeps it in state, defines routes
    ├── index.css              Tailwind import + 2 small rules
    ├── constants.js           the list of categories (used in several places)
    ├── services/              server requests only (get, post, update, delete)
    ├── pages/
    │   ├── Home.jsx           search, category filter, recipe lists
    │   └── RecipeDetails.jsx  full recipe, edit and delete buttons
    └── components/
        ├── Navigation.jsx     top bar
        ├── RecipeCard.jsx     one recipe tile
        ├── CategoryFilter.jsx category buttons
        ├── RecipeForm.jsx     form used for both add and edit
        └── recipe_validation_schema.js   Zod validation rules
```

---

## 3. Build order (how to start a project like this from nothing)

Always build in this order and check the browser after every step. If something breaks, you know it was the last thing you added.

### Step 1: Get an empty project running

Files needed: `package.json`, `index.html`, `vite.config.js`, `src/main.jsx`, `src/App.jsx`, `src/index.css`.

`index.html` has one empty `<div id="root">` and loads `/src/main.jsx`. React fills that div:

```jsx
// src/main.jsx
createRoot(document.getElementById("root")).render(
  <StrictMode>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </StrictMode>,
);
```

- `createRoot(...).render(...)` tells React to draw `<App />` inside `#root`.
- `StrictMode` runs extra development checks. It does not change how the app looks.
- `BrowserRouter` turns on routing for everything inside it. Without it, `Routes`, `Link`, `useParams` and `useNavigate` do not work.

`src/index.css` contains `@import "tailwindcss";`, which enables Tailwind classes such as `border`, `p-2` and `flex`.

**Check:** `npm run dev` shows a page without errors.

### Step 2: Create the data and the API address

**`data/db.json`**: the database. The key `"recipes"` is the collection:

```json
{
  "recipes": [
    { "id": "r1", "title": "Margherita Pizza", "category": "Italian", "vegetarian": true }
  ]
}
```

**`.env`**: the API address, so it is written in only one place:

```
VITE_API_URL = http://localhost:3000/recipes
```

- The `VITE_` prefix is required, otherwise Vite hides the variable from browser code.
- The address ends with `/recipes` because json-server makes one address per collection: `/recipes` is the list, `/recipes/r1` is one recipe.
- After changing `.env`, restart `npm run dev`.

**Check:** run `npm run server` and open `http://localhost:3000/recipes`. You should see JSON.

### Step 3: Write the services (`src/services/`)

Four tiny files, each doing exactly one kind of request. They contain no React code.

```js
// get.js
const API_URL = import.meta.env.VITE_API_URL;      // reads the address from .env

export const getAllData = async () => {
  const response = await axios.get(API_URL);       // GET /recipes
  return response.data;                            // axios puts the useful part in .data
};

export const getOne = async (id) => {
  const response = await axios.get(`${API_URL}/${id}`);   // GET /recipes/r1
  return response.data;
};
```

| File | HTTP method | Address | Purpose |
|---|---|---|---|
| `get.js` | GET | `/recipes` and `/recipes/:id` | Read |
| `post.js` | POST | `/recipes` | Create (json-server generates a random `id`) |
| `update.js` | PATCH | `/recipes/:id` | Update only the sent fields |
| `delete.js` | DELETE | `/recipes/:id` | Delete (asks `window.confirm` first) |

Why `async/await`: a request takes time, and `await` waits for the answer without freezing the page. Every service returns a **promise**.

Why separate files: components stay short and readable, and the address lives in one place. These four files are almost identical in any project with the same structure. Only the `.env` address changes.

### Step 4: Add routing (`App.jsx`)

Routing means "show a different page for a different URL" without reloading the browser.

```jsx
<Routes>
  <Route index element={<Home recipes={recipes} />} />                    {/* / */}
  <Route path="recipes/:id" element={<RecipeDetails onChange={fetchRecipes} />} />
  <Route path="add" element={<RecipeForm key="add" onSaved={fetchRecipes} />} />
  <Route path="edit/:id" element={<RecipeForm key="edit" onSaved={fetchRecipes} />} />
</Routes>
```

- `Routes` renders only the one `Route` whose `path` matches the current URL.
- `index` means "the home page, `/`".
- `:id` is a placeholder. For `/recipes/r1`, the id is `r1`.
- `key="add"` and `key="edit"` make React create a fresh form when switching between add and edit, so old values do not stay in the fields.
- `Navigation` is placed outside `Routes`, so it appears on every page.

Tip: start with empty pages such as `<h1>Home</h1>` and check that the URLs switch between them.

**Navigation links:**
- `<Link to="/add">` and `<NavLink>` change the URL without reloading the page. Use them instead of `<a href>`.
- `NavLink` also adds the class `active` to the link matching the current URL.

### Step 5: Load the data and show the list

In `App.jsx`:

```jsx
const [recipes, setRecipes] = useState([]);   // memory for the list; starts empty

const fetchRecipes = useCallback(async () => {
  try {
    const data = await getAllData();           // ask the server
    setRecipes(data);                          // store the answer -> React re-renders
  } catch (error) {
    setErrorMsg(error.message);                // show the error instead of crashing
  } finally {
    setIsLoading(false);                       // runs on success AND on error
  }
}, []);

useEffect(() => {
  const load = async () => { await fetchRecipes(); };
  load();
}, [fetchRecipes]);                            // runs once, when the app opens
```

- **`useState`** is memory that triggers a redraw when it changes.
- **`useEffect`** runs code after rendering, which is where requests belong. Putting a request directly in the component body would send it on every render.
- **`useCallback`** keeps the same function between renders, so `useEffect` does not re-run endlessly.
- **`try / catch / finally`** handles errors. `finally` always runs, so the spinner is hidden either way.
- **`ClipLoader`** (react-spinners) shows a spinner while `isLoading` is true.
- The recipes live in `App` (the parent) and are passed down as props. This is called **lifting state up**: any page can use them, and when `App` updates them, everything redraws.

In `Home.jsx` and `RecipeCard.jsx`:

```jsx
{recipes.map((recipe) => (
  <RecipeCard key={recipe.id} recipe={recipe} />   // one card per recipe
))}
```

- `map` turns an array of data into an array of components.
- `key` must be unique per item. React uses it to track items when the list changes.
- `RecipeCard` receives the object as a prop and destructures it: `const { id, title, image } = recipe;`.
- The card is wrapped in `<Link to={`/recipes/${id}`}>`, so clicking it opens the details page.

### Step 6: Search and category filter (`Home.jsx`)

```jsx
const [search, setSearch] = useState("");      // text in the search box
const [category, setCategory] = useState("");  // "" means "all categories"

const filteredRecipes = recipes.filter((recipe) => {
  const matchesSearch = recipe.title.toLowerCase().includes(search.trim().toLowerCase());
  const matchesCategory = category === "" || recipe.category === category;
  return matchesSearch && matchesCategory;
});
```

- The search box is a **controlled input**: `value={search}` shows the state, and `onChange={(e) => setSearch(e.target.value)}` updates it on each keystroke.
- `filteredRecipes` is **not** stored in state. It is recalculated on every render from `recipes`, `search` and `category`. Storing it would create a second copy that could go out of sync.
- `toLowerCase()` makes the search case-insensitive.
- `CategoryFilter` has no state of its own. The parent passes `selected` and `onSelect`, so `Home` owns the value. Clicking the active category again sets it back to `""`.
- `constants.js` holds the category list. The filter buttons, the form dropdown and the Zod schema all use it, so they cannot disagree.

### Step 7: Details page (`RecipeDetails.jsx`)

```jsx
const { id } = useParams();        // reads ":id" from the URL: /recipes/r1 -> "r1"
const navigate = useNavigate();    // function for changing the page from code

useEffect(() => {
  const getRecipeById = async () => {
    const data = await getOne(id);   // GET /recipes/r1
    setRecipe(data);
  };
  getRecipeById();
}, [id]);                            // reload if the id in the URL changes
```

- The recipe starts as `null`, so the page first shows a spinner: `if (!recipe) return <ClipLoader />`.
- The ingredients are saved as one text with one ingredient per line. `.split("\n")` turns it into an array for `<li>` items.
- Buttons: Edit (a link to `/edit/:id`), Delete, Back to Home.

### Step 8: Add form with validation (`RecipeForm.jsx`)

Build this in three layers and test each one:

1. **Plain form.** `useForm` + `register`, and just `console.log(formData)` on submit.
2. **Validation.** Add the Zod schema and the resolver.
3. **Saving.** Call `postData`, reload the list, navigate home.

```jsx
const { register, handleSubmit, reset, formState: { errors, isSubmitting } } = useForm({
  mode: "onBlur",              // validate a field when the user leaves it
  reValidateMode: "onChange",  // after an error, re-check on every keystroke
  defaultValues: { title: "", image: "", category: "", /* ... */ },
  resolver: zodResolver(recipeSchema),   // plugs the Zod rules into the form
});
```

| Part | What it does |
|---|---|
| `register("title")` | Connects an input to the form. Spread it: `<input {...register("title")} />`. No `value` or `onChange` needed |
| `handleSubmit(fn)` | Validates first. Calls `fn` with the data object only if everything is valid |
| `errors.title?.message` | The error text for that field, shown under the input |
| `reset()` | Restores `defaultValues`. `reset(object)` fills the form with that object |
| `isSubmitting` | `true` while the request is running. Used to disable the button and prevent double submits |
| `noValidate` on `<form>` | Turns off the browser's own validation so only Zod's messages appear |
| `valueAsNumber` | Makes a number input return a number instead of a string |

The validation rules are in `recipe_validation_schema.js`:

```js
export const recipeSchema = z.object({
  title: z.string().trim().min(3, "Title must be at least 3 characters"),
  image: z.string().trim().pipe(z.url("Enter a valid image URL")),
  category: z.enum(CATEGORIES, { message: "Please select a category" }),
  readyInMinutes: z.number({ message: "Enter the preparation time in minutes" }).int().min(1),
  vegetarian: z.boolean(),
  // ...
});
```

- `.trim()` removes spaces around the text, so "   " counts as empty.
- `.min(n, "message")` sets a minimum length, and the message is what the user sees.
- `z.enum([...])` allows only values from the list.
- A form field can only be as strict as the schema says, so this file is where all the rules live.

On submit:

```jsx
const formSubmitHandler = async (formData) => {
  if (isEdit) await updateData(id, formData);   // PATCH
  else await postData(formData);                // POST
  await onSaved();                              // reload the list in App
  navigate(isEdit ? `/recipes/${id}` : "/");    // go to the recipe or home
};
```

Where the new id comes from: the form never sends an id. json-server creates a random one when it saves the recipe, exactly like in class.

### Step 9: Edit

Edit reuses the same form. The only difference is that the URL has an id:

```jsx
const { id } = useParams();
const isEdit = Boolean(id);          // /add -> false, /edit/r1 -> true

useEffect(() => {
  if (!id) return;                   // add mode: nothing to load
  const loadRecipe = async () => {
    const recipe = await getOne(id);
    reset(recipe);                   // put the saved values into the form fields
  };
  loadRecipe();
}, [id, reset]);
```

On submit, `isEdit` selects `updateData` (PATCH) instead of `postData` (POST).

### Step 10: Delete

In `RecipeDetails.jsx`:

```jsx
const deleteHandle = async () => {
  const deleted = await deleteData(id, recipe.title);  // asks "Are you sure?" first
  if (!deleted) return;     // user pressed Cancel -> deleteData returned undefined
  await onChange();         // reload the list in App
  navigate("/");            // the recipe no longer exists, so leave its page
};
```

---

## 4. Requirements checklist

| # | Requirement | Where |
|---|---|---|
| 1 | Add a recipe + validation | `RecipeForm.jsx`, `recipe_validation_schema.js`, route `/add` |
| 2 | Show recipes | `Home.jsx`, `RecipeCard.jsx` |
| 3 | Edit a recipe | `RecipeForm.jsx`, route `/edit/:id` |
| 4 | Delete a recipe | `RecipeDetails.jsx`, `services/delete.js` |
| 5 | Search | Controlled input in `Home.jsx` |
| 6 | Filter by category | `CategoryFilter.jsx`, filtering in `Home.jsx` |
| 7 | Full description on click | `RecipeDetails.jsx`, route `/recipes/:id` |

---

## 5. Key concepts cheat sheet

- **Component:** a function that returns JSX. The name starts with a capital letter.
- **Props:** inputs passed from parent to child: `<RecipeCard recipe={recipe} />`.
- **State (`useState`):** data that can change. Changing it redraws the component. Never change state variables directly, always use the setter.
- **Effect (`useEffect`):** code that runs after rendering, such as loading data. The array at the end controls when it runs: `[]` once, `[id]` whenever `id` changes.
- **Controlled input:** an input whose text lives in React state (`value` + `onChange`).
- **Lifting state up:** keeping shared data in the parent and passing it down.
- **Promise / async / await:** how code waits for slow things like network requests.
- **REST methods:** GET reads, POST creates, PATCH updates, DELETE deletes.

---

## 6. Troubleshooting

| Symptom | What to check |
|---|---|
| Blank page | Open the browser console (F12) and read the red error |
| Recipes list is empty / network error | Is `npm run server` running? Does `http://localhost:3000/recipes` show JSON? |
| `.env` change has no effect | Restart `npm run dev` |
| `Cannot read properties of undefined` | The data has not loaded yet. Use `recipe?.title` or check `if (!recipe)` first |
| Typing in an input does nothing | Controlled input missing `onChange`, or a typo such as `onCHange` (event names are case-sensitive) |
| Form does not submit | Check the errors under the fields. Zod blocks submit until all are valid |
| New recipe not shown on Home | After saving, `onSaved()` (which is `fetchRecipes`) must be called |
| Images do not load | Check the `image` URL in `db.json` |

Debugging habit: add features one at a time, test each in the browser, and use `console.log(...)` to see what a variable holds.
