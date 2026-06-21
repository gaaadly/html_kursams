/*
Write a JavaScript function to check whether an `input` is a date object or not. 
*/

/* 
"use strict";

let is_date = (input) => {
    return input instanceof Date && !isNaN(input);
}
*/

/*
Write a JavaScript function to get the current date. 
*/

/*
"use strict";

let curday = (skirtukas) => {
    const today = new Date();
  
    const year = today.getFullYear();
    // getMonth() is 0-indexed (0 = January), so we add 1
    const month = String(today.getMonth() + 1).padStart(2, '0');
    const day = String(today.getDate()).padStart(2, '0');

    return `${year}${skirtukas}${month}${skirtukas}${day}`;
}
*/

/*
Write a JavaScript function to compare dates (i.e. greater than, less than or equal to). 
*/
/*
let compare_dates = (date1, date2) => {
  // Convert dates to timestamps (milliseconds since Jan 1, 1970)
  const d1 = date1.getTime();
  const d2 = date2.getTime();

  if (d1 === d2) {
    return "Date1 = Date2";
  } else if (d1 > d2) {
    return "Date1 > Date2";
  } else {
    return "Date2 > Date1";
  }
}
*/

/*
 Write a JavaScript function to get the maximum date from an array of dates.

Test Data :
console.log(max_date(['2015/02/01', '2015/02/02', '2015/01/03']));
Output :
"2015/02/02"
*/

/*
let max_date = (dates) => {
  if (!dates || dates.length === 0) return null;

  // 1. Convert all date strings into millisecond timestamps
  const timestamps = dates.map(date => new Date(date).getTime());
  
  // 2. Find the highest timestamp value
  const maxTimestamp = Math.max(...timestamps);
  
  // 3. Find the index of that max timestamp and return the original string
  const maxIndex = timestamps.indexOf(maxTimestamp);
  
  return dates[maxIndex];
}

console.log(max_date(['2015/02/01', '2015/02/02', '2015/01/03']));

*/

/*
 Write a JavaScript function to convert a Unix timestamp to time.

Test Data :
console.log(Unix_timestamp(1412743274));
"6:41:14"
*/

"use strict";

function Unix_timestamp(t) {
  const date = new Date(t * 1000); // Convert seconds to milliseconds
  const hours   = date.getHours().toString().padStart(2, '0');
  const minutes = date.getMinutes().toString().padStart(2, '0');
  const seconds = date.getSeconds().toString().padStart(2, '0');
  return `${hours}:${minutes}:${seconds}`;
}

console.log(Unix_timestamp(1412743274));