import { NavLink } from "react-router";

function Navigation() {
    return (
        <nav className="navigation">
            <p>
                <NavLink to="/">Home</NavLink>
            </p>
            <p>
                <NavLink to="/products">Products</NavLink>
            </p>
        </nav>
    )
};

export default Navigation;