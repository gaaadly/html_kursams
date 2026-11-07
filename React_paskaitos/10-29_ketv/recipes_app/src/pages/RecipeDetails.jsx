import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router";
import { ClipLoader } from "react-spinners";
import { getOne } from "../services/get";
import deleteData from "../services/delete";

// Full recipe page. Opens at /recipes/:id
function RecipeDetails({ onChange }) {
  const [recipe, setRecipe] = useState(null);
  const [errormsg, setErrorMsg] = useState("");

  // useParams reads ":id" from the URL, e.g. /recipes/r1 -> id = "r1"
  const { id } = useParams();
  // useNavigate gives a function for changing the page from code
  const navigate = useNavigate();

  // Load this one recipe from the server when the page opens (or when the id changes)
  useEffect(() => {
    const getRecipeById = async () => {
      try {
        const data = await getOne(id);
        setRecipe(data);
      } catch (error) {
        setErrorMsg(error.message);
      }
    };
    getRecipeById();
  }, [id]);

  const deleteHandle = async () => {
    try {
      const deleted = await deleteData(id, recipe.title);
      // deleteData returns undefined when the user cancelled the confirmation
      if (!deleted) return;

      await onChange(); // reload the recipe list in App
      navigate("/"); // go back to the home page
    } catch (error) {
      setErrorMsg(error.message);
    }
  };

  if (errormsg) return <p className="error">{errormsg}</p>;
  // While the recipe is still loading, show a spinner
  if (!recipe) return <ClipLoader color="#36d7b7" />;

  // Ingredients are stored as one text, one ingredient per line -> turn into an array
  const ingredients = recipe.ingredients
    .split("\n")
    .filter((line) => line.trim() !== "");

  return (
    <>
      <h1 className="mb-4 text-2xl font-bold">{recipe.title}</h1>

      <div className="flex flex-wrap gap-4">
        <img src={recipe.image} alt={recipe.title} className="w-full max-w-md" />

        <div>
          <p className="mb-2 flex gap-2 text-sm">
            <span className="border px-2">{recipe.category}</span>
            <span className="border px-2">{recipe.readyInMinutes} minutes</span>
            {recipe.vegetarian && <span className="border px-2">Vegetarian</span>}
          </p>

          <h2 className="mt-4 text-xl font-bold">Summary</h2>
          <p>{recipe.summary}</p>

          <h2 className="mt-4 text-xl font-bold">Ingredients</h2>
          <ul className="list-disc pl-6">
            {ingredients.map((ingredient, index) => (
              <li key={index}>{ingredient}</li>
            ))}
          </ul>
        </div>
      </div>

      <h2 className="mt-4 text-xl font-bold">Instructions</h2>
      <p>{recipe.instructions}</p>

      <div className="mt-6 flex gap-2">
        <Link to={`/edit/${id}`} className="border px-3 py-1">
          Edit
        </Link>
        <button onClick={deleteHandle} className="border px-3 py-1">
          Delete
        </button>
        <Link to="/" className="border px-3 py-1">
          Back to Home
        </Link>
      </div>
    </>
  );
}

export default RecipeDetails;
