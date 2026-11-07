import { useRef } from "react";

function UnocontrolledComponents() {
    const myRef = useRef(null);

    const handleClick = () => {
        console.log(myRef.current.value);
    }

    return (
        <>
            <input
                className="bg border"
                type="text"
                name="myinput"
                ref={myRef}
            />
            <button
                className="bg border"
                onClick={handleClick}>Siųsti</button>
        </>
    )
}

export default UnocontrolledComponents;