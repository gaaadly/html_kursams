"use strict"

let num1 = Number(prompt("Įveskite pirmąjį skaičių:"));
let num2 = Number(prompt("Įveskite antrąjį skaičių:"));
let num3 = Number(prompt("Įveskite trečiąjį skaičių:"));

console.log(`didziausias ${Math.max(num1, num2, num3)}, maziausias ${Math.min(num1, num2, num3)}`)