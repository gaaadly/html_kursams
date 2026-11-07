import "./App.css";
import ControlledComponent from "./components/controlled_components/ControlledComponent";
import ControlledComponentAllFormData from "./components/controlled_components/ControlledComponentAllFormData";
import UnocontrolledComponents from "./components/uncontrolledComponents/uncontrolledComponents";
import YoutubeForm from "./components/react_hook_form/YoutubeForm";
import { useEffect, useState } from "react";
import { getAllData } from "./services/get";
import { ClipLoader } from "react-spinners";
import UsersList from "./components/UsersList";

function App() {
  const [users, setUsers] = useState([]);
  const [errormsg, setErrorMsg] = useState("");
  const [isLoading, setIsLoading] = useState(true);

  const fetchData = async () => {
try {
  const data = await getAllData();
  setUsers(data);

} catch (error) {
  setErrorMsg(error.message);
} finally {
  setIsLoading(false);
}
}; 

  useEffect(() => {
    const load = async () => {
      await fetchData();
    }
    load();
  }, [])

  return (
    <>
    {errormsg && <p>{errormsg}</p>}
    {/* <ControlledComponent /> */}
    {/* <ControlledComponentAllFormData /> */}
    {/* <UnocontrolledComponents /> */}
    <YoutubeForm />
    <UsersList users={users}/>
    {isLoading && <ClipLoader color="#36d7b7" />}
    </>
  );
}

export default App;
