"use strict"


let skaicius = Number(prompt("Įveskite skaičių su keliais skaičiais po kablelio (pvz., 4.7):"));

// 2. Atliekame apvalinimus ir išvedame rezultatus į konsolę
console.log(`Pradinis skaičius: ${skaicius}`);
console.log(`Suapvalintas (iki artimiausio): ${Math.round(skaicius)}`);
console.log(`Suapvalintas žemyn (floor): ${Math.floor(skaicius)}`);
console.log(`Suapvalintas aukštyn (ceil): ${Math.ceil(skaicius)}`);