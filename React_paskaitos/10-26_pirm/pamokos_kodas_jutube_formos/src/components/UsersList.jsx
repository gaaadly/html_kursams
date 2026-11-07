import updateData from "../services/update";
import { getOne } from "../services/get";
import { useState } from "react";
import deleteData from "../services/delete";

function UsersList({ users }) {
    const [errormsg, setErrorMsg] = useState("");

    const likesHandle = async (id) => {
        try {
            const user = await getOne(id);
            const { likes } = user;
            await updateData(id, { likes: likes + 1 })
        } catch (error) {
            setErrorMsg(error.message);
        }

    };

    const deleteHandle = async (id) => {
        await deleteData(id);
    }

    return (
        <>
            {users.length !== 0 && <h1>User List</h1>}
            {errormsg && <p>{errormsg}</p>}
            {users.map((user) => (
                <div key={user.id} className="border">
                    <p>{user.username}</p>
                    <p>{user.email}</p>
                    <p>{user.likes}</p>
                    <button className="border" onClick={() => likesHandle(user.id)}>
                        Like
                    </button>
                    <button className="border" onClick={() => deleteHandle(user.id)}>
                        Delete
                    </button>
                </div>
            ))}
        </>
    );
}

export default UsersList;
