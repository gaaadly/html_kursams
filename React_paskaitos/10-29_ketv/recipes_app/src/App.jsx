import { useState, useEffect, useCallback } from "react";
import { Routes, Route } from "react-router";
import { ClipLoader } from "react-spinners";
import { getAllData } from "./services/get";
import Navigation from "./components/Navigation";
import Home from "./pages/Home";
import RecipeDetails from "./pages/RecipeDetails";
import RecipeForm from "./components/RecipeForm";

function App() {
  // The list of recipes lives here (in the parent) and is passed down to pages as props
  const [recipes, setRecipes] = useState([]);
  const [errormsg, setErrorMsg] = useState("");
  const [isLoading, setIsLoading] = useState(true);

  // Loads all recipes from the server (json-server).
  // Also passed down to child components, so they can refresh the list
  // after adding / editing / deleting a recipe.
  const fetchRecipes = useCallback(async () => {
    try {
      setErrorMsg("");
      const data = await getAllData();
      setRecipes(data);
    } catch (error) {
      setErrorMsg(error.message);
    } finally {
      // runs both on success and on error -> hide the spinner
      setIsLoading(false);
    }
  }, []);

  // Empty dependency array = run once, when the app first renders
  useEffect(() => {
    const load = async () => {
      await fetchRecipes();
    };
    load();
  }, [fetchRecipes]);

  return (
    <>
      <Navigation />
      <main className="mx-auto max-w-5xl p-4">
        {errormsg && <p className="error">{errormsg}</p>}
        {isLoading && <ClipLoader color="#36d7b7" />}

        {/* Routes shows the one <Route> whose path matches the current URL */}
        <Routes>
          <Route index element={<Home recipes={recipes} />} />
          {/* ":id" is a URL parameter, read with useParams() in the page */}
          <Route
            path="recipes/:id"
            element={<RecipeDetails onChange={fetchRecipes} />}
          />
          {/* The same form component is used for adding and editing.
              "key" makes React create a fresh form when switching between the two. */}
          <Route
            path="add"
            element={<RecipeForm key="add" onSaved={fetchRecipes} />}
          />
          <Route
            path="edit/:id"
            element={<RecipeForm key="edit" onSaved={fetchRecipes} />}
          />
        </Routes>
      </main>
    </>
  );
}

export default App;
