# Write your MySQL query statement 
-- 1-> way
-- SELECT (
--     SELECT DISTINCT salary      
--     FROM Employee
--     ORDER BY salary DESC
--     LIMIT 1  OFFSET 1
-- ) AS SecondHighestSalary;

-- 2-> way
-- SELECT(
--     SELECT DISTINCT salary
--     FROM (
--         SELECT 
--             *,
--             DENSE_RANK() OVER(ORDER BY salary DESC) as 'ranking'
--         FROM Employee
--     ) as sub
--     WHERE ranking = 2
-- ) AS SecondHighestSalary;

-- 3-> way
-- SELECT (
--     SELECT DISTINCT salary
--     FROM Employee
--     WHERE salary < (
--         SELECT MAX(salary) FROM Employee
--     )
--     ORDER BY salary DESC
--     LIMIT 1 
-- ) AS SecondHighestSalary;

-- 4-> way
SELECT (
    SELECT DISTINCT MAX(salary)
    FROM Employee
    WHERE salary < (
        SELECT MAX(salary) FROM Employee
    ) 
) AS SecondHighestSalary;
