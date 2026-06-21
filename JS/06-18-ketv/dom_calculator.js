"use strict";

const bill = document.getElementById("bill");
const tip = document.getElementById("tip");
const tipPercent = document.getElementById("tip-percent");
const tipAmount = document.getElementById("tip-amount");
const total = document.getElementById("total");

function calculate() {
    const billValue = +bill.value;
    const tipValue = +tip.value;

    const tipResult = (billValue * tipValue / 100).toFixed(2);
    const totalResult = (billValue + +tipResult).toFixed(2);

    tipPercent.innerHTML = tipValue + "%";
    tipAmount.innerHTML = tipResult;
    total.innerHTML = totalResult;
}

bill.addEventListener("input", calculate);
tip.addEventListener("input", calculate);