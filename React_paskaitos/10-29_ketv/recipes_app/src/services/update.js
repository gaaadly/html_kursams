import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL;

// UPDATE: PATCH http://localhost:3000/recipes/r1
// PATCH changes only the fields we send (PUT would replace the whole object).
const updateData = async (id, data) => {
  const response = await axios.patch(`${API_URL}/${id}`, data);
  return response.data;
};

export default updateData;
