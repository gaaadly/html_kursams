// ### **1. Days Until Weekend**

// **Task:**
// Write a function `daysUntilWeekend(day)` that takes a weekday name and returns how many days are left until Saturday.
// Use a `switch` to convert the day name to a number.


/* "use strict";

const daysUntilWeekend = (day) => {
    let dayNumber;

    // Convert the day name into a standard week number (0-6)
    switch (day.toLowerCase()) {
        case "sunday":
            dayNumber = 0;
            break;
        case "monday":
            dayNumber = 1;
            break;
        case "tuesday":
            dayNumber = 2;
            break;
        case "wednesday":
            dayNumber = 3;
            break;
        case "thursday":
            dayNumber = 4;
            break;
        case "friday":
            dayNumber = 5;
            break;
        case "saturday":
            dayNumber = 6;
            break;
        default:
            return "Invalid day entered!";
    }

    // Calculate days left until Saturday (6)
    return 6 - dayNumber;
};

let diena = prompt('What week day is today?');

const resultElement = document.getElementById("result");
resultElement.textContent = daysUntilWeekend(diena);  */


// ### **2. Basic Calculator (with validation)**

// **Task:**
// Create a function `calculate(a, b, operator)` where `operator` is `"+"`, `"-"`, `"*"`, or `"/"`.
// Use a `switch` to perform the calculation.
// If an invalid operator is provided, return an error message.

/* "use strict";

const calculate = (a, b, operator) => {
    switch (operator) {
        case "+":
            return a + b;
        case "-":
            return a - b;
        case "*":
            return a * b;
        case "/":
            // Safety check to prevent dividing by zero
            if (b === 0) {
                return "Error: Division by zero is not allowed.";
            }
            return a / b;
        default:
            return "Error: Invalid operator provided.";
    }
};

console.log(calculate(5,6, '+'));  */

// ### **8. Season By Temperature Range**

// **Task:**
// Input: an integer temperature.
// Use a `switch(true)` pattern to determine:

// * temp < 0 → "Freezing"
// * 0–10 → "Cold"
// * 11–20 → "Mild"
// * 21–30 → "Warm"
// * > 30 → "Hot"

"use strict";

const getSeasonByTemp = (temp) => {
    switch (true) {
        case (temp < 0):
            return "Freezing";
        case (temp >= 0 && temp <= 10):
            return "Cold";
        case (temp >= 11 && temp <= 20):
            return "Mild";
        case (temp >= 21 && temp <= 30):
            return "Warm";
        case (temp > 30):
            return "Hot";
        default:
            return "Invalid temperature input";
    }
};

let tempe = +prompt('Kiek šiandien laipsnių?');

const resultElement = document.getElementById("result");
resultElement.textContent = getSeasonByTemp(tempe);