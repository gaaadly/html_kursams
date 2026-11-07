import { CATEGORIES } from "../constants";

// Row of category buttons. It does not keep its own state: the parent (Home)
// owns "selected" and gives us a function to change it ("lifting state up").
function CategoryFilter({ selected, onSelect }) {
  return (
    <div className="my-4 flex flex-wrap gap-2">
      {CATEGORIES.map((category) => (
        <button
          key={category}
          type="button"
          // Clicking the active category again clears the filter
          onClick={() => onSelect(selected === category ? "" : category)}
          className={`border px-3 py-1 ${
            selected === category ? "bg-black text-white" : ""
          }`}
        >
          {category}
        </button>
      ))}
    </div>
  );
}

export default CategoryFilter;
