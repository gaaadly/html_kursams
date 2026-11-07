import axios from "axios";

// Base URL comes from the .env file (VITE_ prefix makes it available in the browser):
// http://localhost:3000/recipes
const API_URL = import.meta.env.VITE_API_URL;

// READ (all): GET http://localhost:3000/recipes -> array of recipes
export const getAllData = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// READ (one): GET http://localhost:3000/recipes/r1 -> single recipe object
export const getOne = async (id) => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};
