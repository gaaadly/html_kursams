// ### 1. Change Heading Text

// **HTML:**

// ```html
// <h1 id="main-title">Old title</h1>
// <button id="change-title-btn">Change title</button>
// ```

// **Task:**

// * Select the `<h1>` element by its **id**.
// * When the button is clicked, change the heading text to:
//   `New amazing title`.

"use strict";

const title = document.getElementById("main-title");
const btn = document.getElementById("change-title-btn");

btn.addEventListener("click", () => {
    title.innerHTML = "New amazing title";
});
