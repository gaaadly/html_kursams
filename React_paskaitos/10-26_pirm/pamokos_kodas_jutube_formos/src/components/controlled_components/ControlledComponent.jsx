// formos duomenys saugomi React state

import { useState } from "react";

function ControlledComponent() {

    const [inputValue, setInputValue] = useState("");

    const handleChange = (event) => {
        setInputValue(event.target.value);
    }

    return (
        <>
        <input
            className="border" 
            type="text" 
            placeholder="Įveskite tekstą" 
            value={inputValue}
            onChange={handleChange}
        />
        <p>Input value: {inputValue}</p>
        </>
    )
}

export default ControlledComponent;