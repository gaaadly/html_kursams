// #### 1. **Button Click Counter**

// * **Goal**: Create a button that increases a counter displayed on the screen every time it is clicked.
// * **Event**: `click`

/*
"use strict";

const btn = document.getElementById("btn");
const counter = document.getElementById("counter");
let count = 0;

btn.addEventListener("click", () => {
    count++;
    counter.innerHTML = count;
});
*/

// #### 2. **Input Live Preview**

// * **Goal**: Display the text entered in an `<input>` field in real-time below the field.
// * **Event**: `input`

/*
"use strict";

const inputas = document.getElementById("text-input");
const previewas = document.getElementById("preview");

inputas.addEventListener("input", () => {
    previewas.innerHTML = inputas.value;
});
*/

// #### 3. **Change Background on Hover**

// * **Goal**: Change the background color of a div when the mouse hovers over it and revert when it leaves.
// * **Events**: `mouseenter`, `mouseleave`

"use strict";

const box = document.getElementById("hover-box");

box.addEventListener("mouseenter", () => {
    box.style.backgroundColor = "lightblue";
});

box.addEventListener("mouseleave", () => {
    box.style.backgroundColor = "";
});