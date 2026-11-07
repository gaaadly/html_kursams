import { useParams } from "react-router";
import { useEffect } from "react";
import {getOne} from

function ProductDetails () {
    const {id} = useParams();

    useEffect(() => {
        const getProductByID = async () => {
            const product = await getOne(id)
        }
        getProductByID();
    };

)

    return (
        <>
        <h1>Product details</h1>
        </>
    );
};

export default ProductDetails;