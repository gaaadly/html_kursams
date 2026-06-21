// ## 1. Given two integers, function returns the sum of all integers between those two 
// integers, inclusive.

/* "use strict";

function sumOfRange(leftSummand, rightSummand) {
    let suma = 0;
    for (let i = leftSummand; i <= rightSummand; i++) {
        suma += i;
    }
    return suma
}

console.log(sumOfRange(1, 2));  */

// ## 2. Write a function `fizzbuzz` that returns the fizzbuzz string for 
// an input number.

/* "use strict";

function fizzbuzz (number) {
    let output = "";
    for (let i = 1; i <= number; i++) { 
        
        if (i % 5 === 0 && i % 3 === 0) {
            output += "FizzBuzz";
        }
        else if (i % 3 === 0) {
        output += "Fizz"; 
        }
        else if (i % 5 === 0) {
        output += "Buzz"; 
        }
        else {
            output += ".";
        }
    }
    return output;
}

console.log(fizzbuzz(15));   */

// ## 7. Write a function `factors` which is given a number and 
// returns an array containing all its factors.

/* "use strict";

let factors = (number) => {
    let faktoriai = []; 
    for (let i = 1; i <= number; i++) {
        if (number % i === 0) {
            faktoriai.push(i);
        }
    }
    return faktoriai;
}

console.log(factors(12)); */

// ## 10. Write a function "makeBanner" which is given some text and returns a banner with a border surrounding the text. 
// The border should stretch to the length of the text.

"use strict";

let makeBanner = (tekstas) => {
    let banneris = '* ' + tekstas + ' *';

    for (let i = 1; i <= 3; i++) {
        let rowString = "";

        if (i === 2) {
            rowString = banneris;
            console.log(rowString);
            continue
        }
    
        for (let j = 0; j < (tekstas.length + 4); j++) {
        rowString += "*"; 
        }
    
    // Print the completed row, then the outer loop restarts
    console.log(rowString);
    }
}

makeBanner('Visiškai prasta programa!')
