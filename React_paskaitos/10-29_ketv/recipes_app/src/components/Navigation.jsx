import { NavLink } from "react-router";

// Top bar shown on every page.
// NavLink works like <a> but doesn't reload the page, and adds the "active" class
// to the link that matches the current URL.
function Navigation() {
  return (
    <nav className="nav flex items-center justify-between bg-black p-3 text-white">
      <NavLink to="/" className="text-xl font-bold">
        All Recipes
      </NavLink>
      <NavLink to="/add" className="bg-red-500 px-3 py-1">
        Add recipe
      </NavLink>
    </nav>
  );
}

export default Navigation;
