-- Create new database called 'blog'

-- Switch to that database (use)

-- Create table users
CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(50),
  email VARCHAR(50),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
-- Insert new user with values name = 'John Smith', email = 'john@example.com' 

-- Add a column named age to the users table with a data type of INT

-- Insert another 2 users 

-- Update the email of the user with the id of 1 to 'johnsmith@example.com'.

-- Delete the user with the id of 2.

-- Change the data type of the email column in the users table from VARCHAR(50) to VARCHAR(255)

-- Remove the updated_at column from the users table.

-- Create table 'posts' with columns id (int, primary key, auto increment), title (varchar(255)), body (TEXT), user_id (int, foreign key)

-- Add a new column to the 'posts' table called created_at with the data type of TIMESTAMP and a default value of the current timestamp.

-- Add a new post with the following values:  title = 'First Post', body = 'This is my first post', user_id = 1.

-- Rename the body column in the posts table to content.