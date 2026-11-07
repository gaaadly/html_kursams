import { useState } from "react";
import RecipeCard from "../components/RecipeCard";
import CategoryFilter from "../components/CategoryFilter";

function Home({ recipes }) {
  // Controlled input: the text in the search box is stored in React state
  const [search, setSearch] = useState("");
  // "" means "all categories"
  const [category, setCategory] = useState("");

  // Search + category filtering. This is not stored in state, it is simply
  // recalculated on every render from the recipes list and the two state values.
  const filteredRecipes = recipes.filter((recipe) => {
    const matchesSearch = recipe.title
      .toLowerCase()
      .includes(search.trim().toLowerCase());
    const matchesCategory = category === "" || recipe.category === category;

    return matchesSearch && matchesCategory;
  });

  // Second section of the mockup: only vegetarian recipes
  const veggieRecipes = filteredRecipes.filter((recipe) => recipe.vegetarian);

  return (
    <>
      <input
        type="text"
        placeholder="Search recipes..."
        className="w-full border p-2"
        value={search}
        onChange={(event) => setSearch(event.target.value)}
      />

      <CategoryFilter selected={category} onSelect={setCategory} />

      {filteredRecipes.length === 0 && <p>No recipes found.</p>}

      {filteredRecipes.length > 0 && (
        <>
          <h2 className="mb-2 text-xl font-bold">Popular</h2>
          <div className="flex flex-wrap gap-4">
            {filteredRecipes.map((recipe) => (
              // "key" must be unique for each item in a rendered list
              <RecipeCard key={recipe.id} recipe={recipe} />
            ))}
          </div>
        </>
      )}

      {veggieRecipes.length > 0 && (
        <>
          <h2 className="mt-6 mb-2 text-xl font-bold">Veggie Picks</h2>
          <div className="flex flex-wrap gap-4">
            {veggieRecipes.map((recipe) => (
              <RecipeCard key={recipe.id} recipe={recipe} />
            ))}
          </div>
        </>
      )}
    </>
  );
}

export default Home;
