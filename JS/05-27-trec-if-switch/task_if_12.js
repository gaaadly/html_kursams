"use strict"

let preke = prompt("Įveskite prekės pavadinimą (MacBook Air, MacBook Pro, Mac Pro arba Apple Sticker):");
let pinigai = Number(prompt("Kiek turite pinigų?"));

let pakankaPinigu = false;

if (preke === "MacBook Air" && pinigai >= 999) {
    pakankaPinigu = true;
} else if (preke === "MacBook Pro" && pinigai >= 1299) {
    pakankaPinigu = true;
} else if (preke === "Mac Pro" && pinigai >= 2499) {
    pakankaPinigu = true;
} else if (preke === "Apple Sticker" && pinigai >= 1) {
    pakankaPinigu = true;
}


alert(pakankaPinigu);