// 1) Turn an array of numbers into a total of all the numbers
/*
"use strict";

function total(arr) {
   return arr.reduce((acc, cur) => acc + cur, 0);
}
console.log(total([1,2,3]));
*/

// 2) Turn an array of numbers into a long string of all those numbers.
/*
"use strict";

function stringConcat(arr) {
   return arr.reduce((acc, cur) => String(acc) + String(cur));
}
console.log(stringConcat([1,2,3]));
*/

// 3) Turn an array of voter objects into a count of how many people voted
/*
"use strict";

function totalVotes(arr) {
   let counter = 0;
   for (const item of arr) {
    if (item.voted === true) {
        counter += 1;
    }
   }
   return counter;
}
var voters = [
    {name:'Bob' , age: 30, voted: true},
    {name:'Jake' , age: 32, voted: true},
    {name:'Kate' , age: 25, voted: false},
    {name:'Sam' , age: 20, voted: false},
    {name:'Phil' , age: 21, voted: true},
    {name:'Ed' , age:55, voted:true},
    {name:'Tami' , age: 54, voted:true},
    {name: 'Mary', age: 31, voted: false},
    {name: 'Becky', age: 43, voted: false},
    {name: 'Joey', age: 41, voted: true},
    {name: 'Jeff', age: 30, voted: true},
    {name: 'Zack', age: 19, voted: false}
];
console.log(totalVotes(voters));

function totalVotes(arr) {
  return arr.reduce((acc, voter) => {
    return voter.voted ? acc + 1 : acc;
  }, 0);
}

*/

// 4) Given an array of all your wishlist items, figure out how much it would cost to just 
// buy everything at once

/*
"use strict";

function shoppingSpree(arr) {
    return arr.reduce((acc, cur) => acc + cur.price, 0);
}
var wishlist = [
    { title: "Tesla Model S", price: 90000 },
    { title: "4 carat diamond ring", price: 45000 },
    { title: "Fancy hacky Sack", price: 5 },
    { title: "Gold fidgit spinner", price: 2000 },
    { title: "A second Tesla Model S", price: 90000 }
];
console.log(shoppingSpree(wishlist));
*/

// 5) Given an array of arrays, flatten them into a single array

/*
"use strict";

function flatten(arr) {
   return arr.reduce((acc, cur) => [...acc, ...cur], []);   
}
var arrays = [
    ["1", "2", "3"],
    [true],
    [4, 5, 6]
];
console.log(flatten(arrays));
*/

// 6) Given an array of potential voters, return an object representing the results of the 
// vote
// Include how many of the potential voters were in the ages 18-25, how 
// many from 26-35, how many from 36-55, and how many of each of those
// age ranges actually voted. The resulting object containing this data 
// should have 6 properties. See the example output at the bottom.

"use strict";

var voters = [
    {name:'Bob' , age: 30, voted: true},
    {name:'Jake' , age: 32, voted: true},
    {name:'Kate' , age: 25, voted: false},
    {name:'Sam' , age: 20, voted: false},
    {name:'Phil' , age: 21, voted: true},
    {name:'Ed' , age:55, voted:true},
    {name:'Tami' , age: 54, voted:true},
    {name: 'Mary', age: 31, voted: false},
    {name: 'Becky', age: 43, voted: false},
    {name: 'Joey', age: 41, voted: true},
    {name: 'Jeff', age: 30, voted: true},
    {name: 'Zack', age: 19, voted: false}
];
function voterResults(arr) {
   return arr.reduce((acc, voter) => {
        if (voter.age >= 18 && voter.age <= 25) {
            acc.numYoungPeople++;
            if (voter.voted) acc.numYoungVotes++;
        } else if (voter.age >= 26 && voter.age <= 35) {
            acc.numMidsPeople++;
            if (voter.voted) acc.numMidVotesPeople++;
        } else if (voter.age >= 36 && voter.age <= 55) {
            acc.numOldsPeople++;
            if (voter.voted) acc.numOldVotesPeople++;
        }
        return acc;
    }, {
        numYoungVotes: 0,
        numYoungPeople: 0,
        numMidVotesPeople: 0,
        numMidsPeople: 0,
        numOldVotesPeople: 0,
        numOldsPeople: 0
    });
}
console.log(voterResults(voters)); // Returned value shown below:
/*
{ numYoungVotes: 1,
  numYoungPeople: 4,
  numMidVotesPeople: 3,
  numMidsPeople: 4,
  numOldVotesPeople: 3,
  numOldsPeople: 4 
}
*/