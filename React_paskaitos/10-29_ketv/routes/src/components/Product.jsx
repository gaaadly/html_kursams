import { Link } from "react-router";

function Product({ productObject }) {
  const { id, title, price, image } = productObject;

  return (
    <div className="border w-50">
      <p>{title}</p>
      <p>
        <img src={image} alt={title} className="w-40" />
      </p>
      <p>{price}</p>
      <Link to={`/details/${id}`}>
        <button>Details</button>
      </Link>
    </div>
  );
}

export default Product;
