import { Link } from "react-router";

function Product({ productObject }) {
  const { id, title, price, image } = productObject;

  return (
    <div className="bg-gray-400 p-2 m-2 w-50">
      <h1>{title}</h1>
      <p>
        <img src={image} alt={title} className="w-40" />
      </p>
      <p>{price}</p>
      <Link to={`/details/${id}`}>
        <button className="bg-amber-400 p-1">Show Details</button>
      </Link>
    </div>
  );
}

export default Product;
