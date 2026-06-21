// ## 1. Remove Blanks: Create a function that, given a string, 
// returns all of that string’s contents, but without blanks.

/*
"use strict";

let removeBlanks = (sentence) => {
    return sentence.trim();
}

console.log(removeBlanks('   smirda mano kambarys    '));
*/

// ## 2. Get Digits: Create a function that given a string, 
// returns the integer made from the strings digits.

/*
"use strict";

let returnInterger = (sentence) => {
    let finalNumber = "";
    for (let i = 0; i < sentence.length; i++) {
        if (!isNaN(+sentence[i]) && sentence[i] !== ' ') finalNumber += sentence[i];
    }
    return +finalNumber;
}

console.log(returnInterger('su45q  ęčį3445ė5 45345į ė į 45435'));
*/

// ## 3. Acronyms: Create a function that, given a string, 
// returns the string’s acronym (first letter of the word capitalized)

/*
"use strict";

let returnAcronym = (sentence) => {
    let laikinas = sentence.toUpperCase().split(" ");
    let galutinis = '';
    for (let item of laikinas) {
        galutinis += item[0];
    }

    return galutinis;
}

console.log(returnAcronym("Saugirde vaiksciojo viena po parduotuve"));
*/

// ## 9. Write a JavaScript function to extract a specified number of characters from a string.


/*
"use strict";

let truncateString = (stringas) => {
    return stringas.slice(0,4);
}
console.log(truncateString("Robin Singh",4));
*/

// ## 10. Write a JavaScript function to convert a string in abbreviated form.

// - console.log(abbrev_name("Robin Singh")); --> "Robin S."

/*
"use strict";

let abbrevName = (stringas) => {
    return (stringas.slice(0,stringas.indexOf(' ') + 2) + '.');
}
console.log(abbrevName("Robin Singh"));
*/

// 14. Write a JavaScript function to capitalize the first letter of each word in a string.

/*
"use strict";

let capitalize = (stringas) => {
    return stringas.split(" ")
              .map(word => word[0].toUpperCase() + word.slice(1))
              .join(" ");
}

console.log(capitalize('js string exercises'));
*/

// 17. Write a JavaScript function to uncamelize a string.

/*
"use strict";

let uncamelize = (stringas, separator = ' ') => {
    return stringas.split("")
              .map(char => char === char.toUpperCase() && char !== char.toLowerCase() 
                  ? separator + char.toLowerCase() 
                  : char)
              .join("");
}

console.log(uncamelize('helloWorld', '-'));
*/

// 21. Write a JavaScript function to truncates a string if it is longer than the specified number of characters. 
// Truncated strings will end with a translatable ellipsis sequence ("…") (by default) or specified characters.

"use strict";

let truncateString = (stringas, limit = stringas.length + 1, separator = '...') => {
    if (limit > stringas.length) {
        return stringas;
    }
    return (stringas.slice(0, limit - separator.length) + separator);
}

console.log(truncateString('We are doing JS string exercises.')); // --> "We are doing JS string exercises."
console.log(truncateString('We are doing JS string exercises.',19)); // --> "We are doing JS ..."
console.log(truncateString('We are doing JS string exercises.',15,'!!')); // --> "We are doing !!"