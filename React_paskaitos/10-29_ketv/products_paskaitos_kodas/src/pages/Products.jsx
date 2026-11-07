import Product from "../components/Product";
import { Link } from "react-router";
import { Outlet } from "react-router";

function Products({ productsList }) {
  return (
    <>
      <Outlet />
      <h1>This is product page</h1>
      <div className="product-list flex flex-wrap">
        {productsList.map((product) => (
          <Product productObject={product} key={product.id} />
        ))}
      </div>
      {/* <nav>
        <div>Categories</div>
        <div>Materials</div>
      </nav> */}

      <footer>
        <Link to="/">Back to Home</Link>
      </footer>
    </>
  );
}

export default Products;
