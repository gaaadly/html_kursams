"use strict"

let num1 = Number(prompt("Įveskite pirmąjį skaičių:"));
let num2 = Number(prompt("Įveskite antrąjį skaičių:"));
let num3 = Number(prompt("Įveskite trečiąjį skaičių:"));

// Kintamieji, kuriuose saugosime surikiuotus skaičius
let max, mid, min;

// 2. Naudojame if / else if sąlygas rikiavimui
if (num1 >= num2 && num1 >= num3) {
    // Jei num1 yra didžiausias
    max = num1;
    if (num2 >= num3) {
        mid = num2;
        min = num3;
    } else {
        mid = num3;
        min = num2;
    }
} else if (num2 >= num1 && num2 >= num3) {
    // Jei num2 yra didžiausias
    max = num2;
    if (num1 >= num3) {
        mid = num1;
        min = num3;
    } else {
        mid = num3;
        min = num1;
    }
} else {
    // Jei num3 yra didžiausias
    max = num3;
    if (num1 >= num2) {
        mid = num1;
        min = num2;
    } else {
        mid = num2;
        min = num1;
    }
}

alert("Skaičiai nuo didžiausio iki mažiausio: " + max + ", " + mid + ", " + min);