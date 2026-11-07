
// formos duomenys saugomi React state

import { useState } from "react";

function ControlledComponentAllFormData() {

    const [formData, setFormData] = useState({
        name: "",
        email: "",
        message: "",
    });

    const handleChange = (event) => {
        const {name, value} = event.target;
        setFormData((formData) => ({...formData, [name]: value}))
    }

    const handleSubmit = (event) => {
        event.preventDefault(); // formos perkrovimo stabdymas
        console.log(formData);
        localStorage.setItem("user", JSON.stringify(formData))
    }

    return (

        <form onSubmit={handleSubmit}>
            <label htmlFor="name">Name:</label>
            <input
                type="text"
                id="name"
                name="name"
                value={formData.name}
                onChange={handleChange}
            />

            <label htmlFor="email">Email:</label>
            <input
                type="email"
                id="email"
                name="email"
                value={formData.email}
                onChange={handleChange}
            />

            <label htmlFor="message">Message:</label>
            <textarea
                id="message"
                name="message"
                value={formData.message}
                onChange={handleChange}
            />

            <button className="bg border" type="submit">Submit</button>
        </form>
    )
}

export default ControlledComponentAllFormData;