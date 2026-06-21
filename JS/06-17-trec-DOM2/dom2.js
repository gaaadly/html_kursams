"use strict";

const saskaita = document.getElementById("bill");
const arbata = document.getElementById("tip");
const tipamount = document.getElementById("tip-amount")
let tarpine = 0;

saskaita.addEventListener("input", () => {
   tarpine = +saskaita.value;
});

arbata.addEventListener("input", () => {
    tipamount.innerHTML = (arbata.value/100) * tarpine;
});

const btn = document.getElementById("calculate-btn");
const totalas = document.getElementById("total");
let suma = 0;

btn.addEventListener("click", () => {
    suma = tarpine + (tarpine * arbata.value / 100);
    totalas.innerHTML = suma;
});