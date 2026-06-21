// ## Print your answers to the console. 

// 1. Write a program to list the properties of an object. 
// E.g.
// const student = { 
// firstName: "John", 
// lastName: "Smith", 
// class: 12 };
// Expected Output: firstName, lastName, class

/*
"use strict";

const student = { 
    firstName: "John", 
    lastName: "Smith", 
    class: 12 
};

console.log(Object.keys(student));
*/

// 2. Create a person object. Include the person's first and last name, age, job, city etc. 
// Then print text by retrieving data from the object 
// e.g. "John Smith is a 41 year old engineer living in France".
/*
"use strict";

const person = { 
    firstName: "John", 
    lastName: "Smith", 
    age: 12,
    job: 'unemployed',
    city: "Paliktainiai" 
};

console.log(`${person.firstName} ${person.lastName} is a ${person.age} year old ${person.job} living in ${person.city}`);
*/

// 3. Write a JavaScript program to delete the "class" property (or last property) from the previous object.
/*
"use strict";

let student = { 
    firstName: "John", 
    lastName: "Smith", 
    class: 12 
};

delete student.class;

console.log(student);
*/

// 4. Write a program to get the length of a JavaScript object.
/*
"use strict";

let student = { 
    firstName: "John", 
    lastName: "Smith", 
    class: 12 
};

console.log(Object.keys(student).length);
*/

// 5. Write a program to display the reading status 
// (i.e. display book name, author name and reading status) of the following books.
// Already read Harry Potter and the Chamber of Secrets by J.K. Rowling
// Already read The Odyssey by Homer
// You still need to read To Kill a Mockingbird by Harper Lee

/*
"use strict";

const library = [ 
   {
       author: 'J.K. Rowling',
       title: 'Harry Potter and the Chamber of Secrets',
       readingStatus: true
   },
   {
       author: 'Homer',
       title: 'The Odyssey',
       readingStatus: true
   },
   {
       author: 'Harper Lee',
       title:  'To Kill a Mockingbird', 
       readingStatus: false
   }];

for (let item of library) {
    if (item.readingStatus) {
        console.log(`Already read ${item.title} by ${item.author}`);
        }
    else {
        console.log(`You still need to read ${item.title} by ${item.author}`);
        
    }
};
*/

