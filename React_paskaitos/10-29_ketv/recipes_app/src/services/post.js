import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL;

// CREATE: POST http://localhost:3000/recipes
// json-server generates the new "id" automatically and returns the saved recipe.
const postData = async (data) => {
  const response = await axios.post(API_URL, data);
  return response.data;
};

export default postData;
