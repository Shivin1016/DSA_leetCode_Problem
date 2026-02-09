# Write your MySQL query statement below
-- SELECT *
-- FROM(
--     SELECT d.name as Department , e.name as  Employee , MAX(e.salary) as Salary
--     FROM Employee e
--     Inner JOIN Department d
--     ON e.departmentId = d.id
--     GROUP BY d.name 

-- ) as sub


-- SELECT d.name as Department , e.name as  Employee , MAX(e.salary) as Salary
-- FROM Employee e
-- Inner JOIN Department d
-- ON e.departmentId = d.id
-- GROUP BY d.name ;

SELECT s.Department , s.Employee , s.Salary
FROM (
    SELECT 
        *,
        DENSE_RANK() OVER(PARTITION BY Department ORDER BY Salary DESC) as 'ranking'
    FROM (
        SELECT d.name as Department , e.name as  Employee , e.salary as Salary
        FROM Employee e
        Inner JOIN Department d
        ON e.departmentId = d.id
    ) as sub 
) as s
WHERE ranking = 1; 


