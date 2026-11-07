import axios from "axios";
// import { getOne } from "../services/get";
const API_URL = import.meta.env.VITE_API_URL;

const deleteData = async (id, username) => {
  // const { username, email } = await getOne(id);

  const confirmed = window.confirm(
    `Ar tikrai norite ištrinti vartotoją ${username}`,
  );
  //confrimed yra false tai turime stabdyti trynimą
  if (!confirmed) return;
  const response = await axios.delete(`${API_URL}/${id}`);
  return response.data;
};

export default deleteData;



// https://40aprons.com/wp-content/uploads/2017/07/greek-healthy-meal-prep.jpg
