-- Create table to store LeetCode problems
CREATE TABLE Problems (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    difficulty VARCHAR(20),
    problem_text TEXT,
    CONSTRAINT uc_title UNIQUE (title)
);

-- Create table to store user submissions
CREATE TABLE Submissions (
    submission_id INT PRIMARY KEY,
    problem_id INT,
    user_id INT,
    language VARCHAR(50),
    status VARCHAR(20),
    runtime_ms INT,
    memory_kb INT,
    submission_time DATETIME,
    FOREIGN KEY (problem_id) REFERENCES Problems(id),
    -- Assuming you have a table for users
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);

-- Example data for Problems table
INSERT INTO Problems (id, title, difficulty, problem_text) VALUES
(1, 'Two Sum', 'Easy', 'Given an array of integers, return indices of the two numbers such that they add up to a specific target.'),
(2, 'Add Two Numbers', 'Medium', 'You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit.'),
(3, 'Longest Substring Without Repeating Characters', 'Medium', 'Given a string, find the length of the longest substring without repeating characters.');

-- Example data for Submissions table
INSERT INTO Submissions (submission_id, problem_id, user_id, language, status, runtime_ms, memory_kb, submission_time) VALUES
(101, 1, 1001, 'Python', 'Accepted', 52, 1624, '2024-06-01 10:30:45'),
(102, 1, 1002, 'Java', 'Accepted', 48, 2048, '2024-06-02 15:20:12'),
(103, 2, 1001, 'C++', 'Accepted', 68, 3072, '2024-06-03 09:45:21');
