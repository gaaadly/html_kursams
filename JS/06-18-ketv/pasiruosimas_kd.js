// ## 1. Complex transformation with conditions

// Given:

// ```js
// const temperatures = [18, 25, 30, 10, 28];
// ```

// Use **map** to return an array of objects:

/*
"use strict";

const temperatures = [18, 25, 30, 10, 28];

let tempObjects = (temps) => {
    return temps.map(item => {
        let status = item < 15 ? "cold" : item < 25 ? "warm" : "hot";
        return { temp: item, status };
    });
}

console.log(tempObjects(temperatures));
*/

// ## 2. Filter and sort products with multiple conditions

// 1. **Filters** only products that are `inStock`.
// 2. **Filters** only products with `price >= 10`.
// 3. **Sorts** the result by price from **cheapest to most expensive**.
// 4. Returns an array of **titles only**.

/*
"use strict";

const products = [
  { title: "Keyboard", price: 40, inStock: true },
  { title: "Mouse", price: 15, inStock: false },
  { title: "Monitor", price: 120, inStock: true },
  { title: "USB Cable", price: 5, inStock: true }
];

let filterStock = (items) => items.filter(product => product.inStock);

let filterPrice = (items) => items.filter(product => product.price >= 10);

let sortPrice = (items) => items.sort((a, b) => a.price - b.price);

let titlesOnly = (items) => items.map(item => item.title);

console.log(titlesOnly(products));
*/

// ## 3. Parse CSV string into array of objects

// Given a CSV string:

// ```js
// const input = "name,age,city\nJonas,25,Vilnius\nOna,30,Kaunas\nPetras,22,Klaipeda";
// ```

// Write a function that returns:

// ```js
// [
//   { name: "Jonas", age: 25, city: "Vilnius" },
//   { name: "Ona", age: 30, city: "Kaunas" },
//   { name: "Petras", age: 22, city: "Klaipeda" }
// ]
// ```

// Use **string methods**, **arrays**, and **objects** (no libraries).

/*
"use strict";

const input = "name,age,city\nJonas,25,Vilnius\nOna,30,Kaunas\nPetras,22,Klaipeda";

const parseCSV = (str) => {
    const lines = str.split("\n");        // split into rows
    const headers = lines[0].split(","); // ["name", "age", "city"]
    
    return lines.slice(1).map(line => {  // skip header row
        const values = line.split(",");  // ["Jonas", "25", "Vilnius"]
        
        return headers.reduce((obj, header, index) => {
            obj[header] = isNaN(values[index]) ? values[index] : +values[index];
            return obj;
        }, {});
    });
}

console.log(parseCSV(input));
*/

// ## 4. Unique values from array of objects

// Given:

// ```js
// const posts = [
//   { id: 1, tags: ["js", "web", "frontend"] },
//   { id: 2, tags: ["js", "node", "backend"] },
//   { id: 3, tags: ["css", "design", "frontend"] }
// ];
// ```

// Create a function that returns an array of **unique tags**, sorted alphabetically:

// ```js
// ["backend", "css", "design", "frontend", "js", "node"]
// ```

/*
"use strict";

const posts = [
  { id: 1, tags: ["js", "web", "frontend"] },
  { id: 2, tags: ["js", "node", "backend"] },
  { id: 3, tags: ["css", "design", "frontend"] }
];

let uniqueTags = (postai) => {
    let galutinis = [];
    for (let item of postai) {
        for (let tag of item['tags']) {
            if (!galutinis.includes(tag)) {
                galutinis.push(tag);
            }
        }
    }
    return galutinis.sort();
}

console.log(uniqueTags(posts));
*/

// ## 5. Find the most frequent character in a string

// Write a function `mostFrequentChar(str)` that returns the **character** that appears **most often** in the string (ignore spaces, case-insensitive).

// Example:
// `"Hello world"` → `"l"`

// If there’s a tie, you can return **any one** of the most frequent characters.

// ---

/*
"use strict";

let mostFrequentChar = (str) => {
    let max = 0;
    let maxChar = '';

    for (let i = 0; i < str.length; i++) {
        let counter = 0;
        for (let j = 0; j < str.length; j++) {
            if (str[i].toLowerCase() === str[j].toLowerCase()) {
                counter += 1;
            }
        }
        if (counter > max) {
            max = counter;
            maxChar = str[i];
        }
    }
    return maxChar;
}

console.log(mostFrequentChar('ssusuusuuu'));
*/

// ## 6. Deep destructuring of nested objects

// Given:

// ```js
// const data = {
//   status: "ok",
//   user: {
//     id: 15,
//     profile: {
//       name: "Laura",
//       email: "laura@example.com"
//     },
//     roles: ["user", "editor"]
//   }
// };
// ```

// Using **destructuring**, extract:

// * `status`
// * `userId` (from `id`)
// * `name`
// * `primaryRole` (first element in `roles`)

// All as separate variables (no `data.` accesses allowed in your final code).

/*
"use strict";

const data = {
  status: "ok",
  user: {
    id: 15,
    profile: {
      name: "Laura",
      email: "laura@example.com"
    },
    roles: ["user", "editor"]
  }
};

const {
    status,
    user: {
        id: userId,
        profile: { name },
        roles: [primaryRole]
    }
} = data;

console.log(status, userId, name, primaryRole);
*/

// ## 7. Add new property during mapping


// Use **map** to return:

// Assume VAT = 21%.

/*
"use strict";

const products = [
  { title: "Phone", price: 500 },
  { title: "Laptop", price: 1200 },
  { title: "Tablet", price: 800 }
];

const withVAT = products.map(product => ({
    ...product,
    priceWithVAT: product.price * 1.21
}));

console.log(withVAT);
*/

// ## 8. Merge arrays of objects by id

// (Assume each `id` exists in both arrays.)

/*
"use strict";

const people = [
  { id: 1, name: "Jonas" },
  { id: 2, name: "Ona" },
  { id: 3, name: "Petras" }
];

const scores = [
  { id: 1, score: 10 },
  { id: 3, score: 7 },
  { id: 2, score: 9 }
];

function mergeById(people, scores) {
    return people.map(person => {
        const matchingScore = scores.find(s => s.id === person.id);
        return { ...person, score: matchingScore.score };
    });
}

console.log(mergeById(people, scores));
*/


// ## 9. Create a “short description” for products

// Given:

// ```js
// const items = [
//   { name: "Phone", description: "A very nice smartphone with good camera", price: 500 },
//   { name: "Laptop", description: "Powerful laptop for work and games", price: 1200 }
// ];
// ```

// Write a function that returns an array of **strings** in format:

// ```txt
// "Phone (500€): A very nice smartphone..."
// "Laptop (1200€): Powerful laptop for work..."
// ```

// Rules:

// * If `description.length > 25`, cut it and add `"..."`.
// * Use **template literals**, **conditions**, and **string methods**.

/*
"use strict";

const items = [
  { name: "Phone", description: "A very nice smartphone with good camera", price: 500 },
  { name: "Laptop", description: "Powerful laptop for work and games", price: 1200 }
];

function shortDescriptions(arr) {
    return arr.map(item => {
        const desc = item.description.length > 25
            ? item.description.slice(0, 25) + "..."
            : item.description;

        return `${item.name} (${item.price}€): ${desc}`;
    });
}

console.log(shortDescriptions(items));
*/

// ## 10. Sort by criteria

// Given:

// ```js
// const employees = [
//   { name: "Jonas", department: "IT", salary: 2000 },
//   { name: "Ona", department: "HR", salary: 1800 },
//   { name: "Petras", department: "IT", salary: 2200 },
//   { name: "Greta", department: "HR", salary: 2100 }
// ];
// ```

// Write functions to Sort:

// 1. Employees by `department` **alphabetically**.
// 2. Employees by `salary` **descending**.

// Return the sorted arrays.

// "use strict";

// const employees = [
//   { name: "Jonas", department: "IT", salary: 2000 },
//   { name: "Ona", department: "HR", salary: 1800 },
//   { name: "Petras", department: "IT", salary: 2200 },
//   { name: "Greta", department: "HR", salary: 2100 }
// ];

// // 1. sort by department alphabetically
// function sortByDepartment(arr) {
//     return [...arr].sort((a, b) => a.department.localeCompare(b.department));
// }

// // 2. sort by salary descending
// function sortBySalary(arr) {
//     return [...arr].sort((a, b) => b.salary - a.salary);
// }

// console.log(sortByDepartment(employees));
// console.log(sortBySalary(employees));

// ## 11. Search with multiple filters

// Given:

// ```js
// const books = [
//   { title: "JS Basics", pages: 120, tags: ["js", "beginner"] },
//   { title: "Advanced JS", pages: 350, tags: ["js", "advanced"] },
//   { title: "CSS Mastery", pages: 200, tags: ["css"] },
//   { title: "HTML & CSS", pages: 150, tags: ["html", "css", "beginner"] }
// ];
// ```

// Write a function:

// ```js
// searchBooks(books, { minPages, hasTag })
// ```

// which returns books that:

// * have at least `minPages` pages
// * **and** contain the tag `hasTag` in their `tags` array

// Example:

// ```js
// searchBooks(books, { minPages: 150, hasTag: "css" });
// ```

// Should return books matching both conditions.

// ---

"use strict";

const books = [
  { title: "JS Basics", pages: 120, tags: ["js", "beginner"] },
  { title: "Advanced JS", pages: 350, tags: ["js", "advanced"] },
  { title: "CSS Mastery", pages: 200, tags: ["css"] },
  { title: "HTML & CSS", pages: 150, tags: ["html", "css", "beginner"] }
];

function searchBooks(books, { minPages, hasTag }) {
    return books.filter(book => 
        book.pages >= minPages && book.tags.includes(hasTag)
    );
}

console.log(searchBooks(books, { minPages: 150, hasTag: "css" }));