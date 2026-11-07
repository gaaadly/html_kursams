import { Link } from "react-router";

// One recipe tile in the list. The whole card is a link to the details page.
// The recipe object comes from the parent as a prop and is destructured.
function RecipeCard({ recipe }) {
  const { id, title, image, category } = recipe;

  return (
    <Link to={`/recipes/${id}`} className="block w-56 border">
      <img src={image} alt={title} className="h-36 w-full object-cover" />
      <div className="p-2">
        <h3 className="font-bold">{title}</h3>
        <p className="text-sm text-gray-600">{category}</p>
      </div>
    </Link>
  );
}

export default RecipeCard;
