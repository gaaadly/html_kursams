import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL;

// DELETE: DELETE http://localhost:3000/recipes/r1
// Asks the user to confirm first. Returns the deleted recipe,
// or undefined when the user pressed "Cancel".
const deleteData = async (id, title) => {
  const confirmed = window.confirm(
    `Are you sure you want to delete "${title}"?`,
  );

  // confirmed is false -> stop, nothing is deleted
  if (!confirmed) return;

  const response = await axios.delete(`${API_URL}/${id}`);
  return response.data;
};

export default deleteData;
