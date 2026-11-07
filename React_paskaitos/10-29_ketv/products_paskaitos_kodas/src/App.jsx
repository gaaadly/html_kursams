import "./App.css";

import { Routes, Route } from "react-router";
import Home from "./pages/Home";
import Products from "./pages/Products";
import { useState, useEffect } from "react";
import axios from "axios";
import Navigation from "./components/Navigation";
import Categories from "./components/Categories";
import ProductDetails from "./components/ProductDetails";

function App() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      const { data } = await axios.get("https://fakestoreapi.com/products");
      setProducts(data);
    };

    fetchProducts();
  }, []);

  return (
    <>
      <Navigation />
      <Routes>
        <Route index element={<Home />} />
        <Route path="products" element={<Products productsList={products} />}>
          <Route path="categories" element={<Categories />} />
        </Route>
        <Route path="details/:id" element={<ProductDetails />} />
      </Routes>
    </>
  );
}

export default App;
