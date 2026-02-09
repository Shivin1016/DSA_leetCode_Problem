# Write your MySQL query statement below 

-- 1--> way
-- SELECT s.Department , s.Employee , s.Salary
-- FROM (
--     SELECT 
--         *,
--         DENSE_RANK() OVER(PARTITION BY Department ORDER BY Salary DESC) as 'ranking'
--     FROM (
--         SELECT d.name as Department , e.name as  Employee , e.salary as Salary
--         FROM Employee e
--         Inner JOIN Department d
--         ON e.departmentId = d.id
--     ) as sub 
-- ) as s
-- WHERE ranking = 1; 

-- 2 --> way
SELECT d.name as Department , e.name as  Employee , e.salary as Salary
FROM Employee e
Inner JOIN Department d
ON e.departmentId = d.id
WHERE e.salary = (
    SELECT MAX(SALARY)
    FROM Employee
    WHERE departmentId = e.departmentId
);




