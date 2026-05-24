-- 1. Add a new column named "FirstName" to the "executors" table and populate it with data.

ALTER TABLE executors ADD COLUMN FirstName VARCHAR(40);

UPDATE executors SET FirstName = 'Jonas'   WHERE executor_id = 1;
UPDATE executors SET FirstName = 'Petras'  WHERE executor_id = 2; 
UPDATE executors SET FirstName = 'Gabija'  WHERE executor_id = 3; 
UPDATE executors SET FirstName = 'Ona'     WHERE executor_id = 4; 
UPDATE executors SET FirstName = 'Antanas' WHERE executor_id = 5; 

-- 2. Retrieve the executors' last names, qualifications, and the roles they hold in projects.

-- 3. Retrieve the executors' first names and last names along with the name of the project they work on.

-- 4. Retrieve the first and last names of executors working on the 'Financial Accounting' project along with the project name.

-- 5. Retrieve all executors from the 'Student Accounting' project who have a qualification of 'Computer Scientist'.

-- 6. Retrieve all female executors with the role of 'Manager' and display their first names, last names, and the project name.
--    (Assumes that gender identification is inferred from naming conventions.)

-- 7. Retrieve project names, importance, and the total hours dedicated to each project.

-- 8. Retrieve project names along with the count of employees working on each project.

-- 9. Limit the results from query #8 to include only projects with no more than 3 employees.

-- 10. Retrieve executors' first and last names along with the names of the projects they work on, excluding those who hold a 'Manager' role.

-- 11. Create a new record in the "executors" table with:
--     executor_id: 6, FirstName: 'Pranas', last_name: 'Logis', qualification: NULL, category: NULL, and education: NULL.

-- 12. Retrieve executors' first names and last names along with project names, including those executors who are not associated with any project.

-- 13. Retrieve executors' first names, last names, and project names for those with roles 'Programmer' or 'Analyst', who have logged at least 250 hours,
--     and where the project's duration is at least 10 weeks.
