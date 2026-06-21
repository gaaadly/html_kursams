// Pirma užduotis

/* "use strict"

let cepelinai = +prompt('Kiek suvalgysite cepelinų?')

function cepelinuAnalize(cepelinuKiekis) {
    let bendroskalorijos = 3 * cepelinuKiekis;
    let bamba = (bendroskalorijos > 1000) ? "Siaubingai daug kalorijų." : "Nieko ypatingo, tęskite valgymą.";
    return {kalorijos: bendroskalorijos, zinute: bamba};
}

const resultElement = document.getElementById("result");
resultElement.textContent = cepelinuAnalize(cepelinai);  */

//Antra užduotis

/* "use strict"

let nuotaika = +prompt('Kokia nuotaika (1-10)?');
let energ = +prompt('Kiek turite energijos(1-10)?');

let blynMotyvacija = (nuotaika, energija) => {
    let kepimoIndex = nuotaika * energija;
    switch (true) {
        case (kepimoIndex < 20):
    
        return "Palik blynus rytojui...";
        case (kepimoIndex >= 20 && kepimoIndex <= 40):
    
        return "Kepk kelis blynus."
        case (kepimoIndex > 40):
    
        return "Kepk daug blynų!"
    default: "Nieko nesigavo..."
    }
}

const resultElement = document.getElementById("result");
resultElement.textContent = blynMotyvacija(nuotaika, energ);  */

// Ketvirta užduotis

/* "use strict"

let zolele1 = +prompt('zolele1:');
let zolele2 = +prompt('Zolele2:');
let zolele3 = +prompt('Zolele3:');
let zolele4 = +prompt('Zolele4:');

let joniniuEkspertas = (z1, z2, z3, z4) => {
    let zoleliusuma = ((z1 + z2 + z3 + z4) > 20) ? "Joninės garantuotos!" : "Dar reikia žolelių...";
    return {suma: (z1 + z2 + z3 + z4), isvada: zoleliusuma};
}

const resultElement = document.getElementById("result");
resultElement.textContent = joniniuEkspertas(zolele1, zolele2, zolele3, zolele4); */

// Septinta užduotis

/* "use strict"

let vardas = prompt('Koks tavo vardas');
let sleep = +prompt('Ar gerai miegojai? (0, 1)');

let celebrateNameDay = (vardas, arGeraiMiegojo) => {
    let sveikinimas = arGeraiMiegojo ? `Sveikiname su vardadieniu, ${vardas}!` : `Sveikiname su vardadieniu, ${vardas}! (bet pirmiau išgerk kavos)`;
    return sveikinimas;
}

const resultElement = document.getElementById("result");
resultElement.textContent = celebrateNameDay(vardas, sleep);  */

// Dešimta užduotis

/* "use strict"

let potatoBattle = () => {
    let bulviuPatiekalai = ["Bulviniai blynai", "Vedarai", "Šaltibarščiai su bulvėmis", "Bulvinė košė", "Bulviu plokštainis"];
    const randomIndex1 = Math.floor(Math.random() * 5);
    const randomIndex2 = Math.floor(Math.random() * 5);
    if (bulviuPatiekalai[randomIndex1] === bulviuPatiekalai[randomIndex2]) {
        return `Lemtingas sutapimas! Valgysi dvigubą ${bulviuPatiekalai[randomIndex1]} porciją!`;
    } else { 
        return `Šiandien rinkis tarp ${bulviuPatiekalai[randomIndex1]} ir ${bulviuPatiekalai[randomIndex2]}!`;
    }
}

console.log(potatoBattle()); */

// Penkiolikta užduotis

/*  "use strict";

let cakePerPerson = (skersmuo, zmones) => {
    let zmoniuKiekis = 0;
    for (const zmogus of zmones) {
        zmoniuKiekis = zmoniuKiekis + zmogus;
    }
    let tortasZmogui = (Math.PI * (skersmuo / 2)^2) / zmoniuKiekis;
    let ivert = (tortasZmogui < 5) ? "Mažoka" : "Pakankamai";
    return {perZmogui: tortasZmogui, ivertinimas: ivert}; 
}

let skersm = 20;
let zmogai = [1, 1, 1];

console.log(cakePerPerson(skersm, zmogai));   */

// Dvidešimta užduotis 

"use strict";

let randomHoliday = () => {
    const technologine = ["Programuotoju diena", "Klaviatūros pagerbimo diena"];
    const maisto = ["Cepelinų diena", "Šaltibarščių diena"];
    const poilsio = ["Nieko neveikimo diena", "Vėlyvų pusryčių diena"];

    let indexkategorija = Math.floor(Math.random() * 3);
    let indexsvente = Math.floor(Math.random() * 2);

    switch (true) {
        case (indexkategorija === 0):
        return `technologine: ${technologine[indexsvente]}`;

        case (indexkategorija === 1):    
        return `maisto: ${maisto[indexsvente]}`;

        case (indexkategorija === 2):    
        return `poilsio: ${poilsio[indexsvente]}`;
    }
}

console.log(randomHoliday());