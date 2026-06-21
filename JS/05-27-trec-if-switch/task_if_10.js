"use strict"

const jonoVidurkis = (89 + 120 + 103) / 3;
const mikoVidurkis = (116 + 94 + 123) / 3;
const maryVidurkis = (97 + 134 + 105) / 3;

// Atspausdiname vidurkius pasitikrinimui
console.log(`Vidurkiai -> Jono: ${jonoVidurkis}, Miko: ${mikoVidurkis}, Mary: ${maryVidurkis}`);

// 2. Lyginame visas tris komandas, atsižvelgdami į lygiąsias
if (maryVidurkis > jonoVidurkis && maryVidurkis > mikoVidurkis) {
    console.log(`Laimėtoja: Mary komanda! Vidurkis: ${maryVidurkis}`);
} else if (mikoVidurkis > jonoVidurkis && mikoVidurkis > maryVidurkis) {
    console.log(`Laimėtoja: Miko komanda! Vidurkis: ${mikoVidurkis}`);
} else if (jonoVidurkis > mikoVidurkis && jonoVidurkis > maryVidurkis) {
    console.log(`Laimėtoja: Jono komanda! Vidurkis: ${jonoVidurkis}`);
} 
// 3. Logika, jei atsiranda lygiosios tarp pirmaujančiųjų
else if (maryVidurkis === mikoVidurkis && maryVidurkis === jonoVidurkis) {
    console.log(`Neįtikėtina! Visos trys komandos surinko po lygiai. Vidurkis: ${maryVidurkis}`);
} else if (maryVidurkis === mikoVidurkis) {
    console.log(`Lygiosios tarp Mary ir Miko komandų! Vidurkis: ${maryVidurkis}`);
} else if (maryVidurkis === jonoVidurkis) {
    console.log(`Lygiosios tarp Mary ir Jono komandų! Vidurkis: ${maryVidurkis}`);
} else if (mikoVidurkis === jonoVidurkis) {
    console.log(`Lygiosios tarp Miko ir Jono komandų! Vidurkis: ${mikoVidurkis}`);
}