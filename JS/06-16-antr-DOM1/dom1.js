"use strict";

const colorBox = document.getElementById("color-box");
const parent = document.querySelector("div");
let activeBtn = null;

parent.addEventListener("click", function(e) {
    if (e.target.classList.contains("color-btn")) {
        colorBox.style.backgroundColor = e.target.dataset.color;

        // reset previously selected button
        if (activeBtn) {
            activeBtn.style.outline = "none";
            activeBtn.style.fontWeight = "normal";
        }

        // highlight clicked button
        e.target.style.outline = "3px solid black";
        e.target.style.fontWeight = "bold";

        // remember clicked button
        activeBtn = e.target;
    }
});