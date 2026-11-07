import axios from "axios";
import { getOne } from "./get";
const API_URL = import.meta.env.VITE_API_URL;

const deleteData = async (id) => {
    const {username, email} = await getOne(id);
    const confirmed = window.confirm(`Ar tikrai norite ištinriti vartotoją ${username}`);
// jei confirmed false turime stabdyti trynimą

    if (!confirmed) return;

    const response = await axios.delete(`${API_URL}/${id}`);

    return response.data;
};

export default deleteData;