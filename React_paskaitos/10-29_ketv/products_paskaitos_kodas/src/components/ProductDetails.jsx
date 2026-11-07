import { useParams } from "react-router";
import { useEffect, useState } from "react";
import { getOne } from "../services/get";

function ProductDetails() {
  const [product, setProduct] = useState(null);
  const { id } = useParams();

  useEffect(() => {
    const getProductByID = async () => {
      const product = await getOne(id);
      setProduct(product);
    };
    getProductByID();
  }, []);

  return (
    <>
      <h1>{product?.description}</h1>
    </>
  );
}

export default ProductDetails;
