CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  SET N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
    --   1-> way
    --   SELECT salary as getNthHighestSalary
    --   FROM (
    --     SELECT 
    --         *,
    --         DENSE_RANK() OVER(ORDER BY salary DESC) as 'ranking'
    --     FROM Employee
    --   ) as s
    --   WHERE ranking = N
    --   LIMIT 1

    -- 2 -> way
        -- SELECT salary as getNthHighestSalary
        -- FROM Employee e1
        -- WHERE N - 1 = (
        --     SELECT COUNT(DISTINCT salary)
        --     FROM Employee e2
        --     WHERE e2.salary > e1.salary
        -- )
        -- LIMIT 1
    
    -- 3 -> way-> for we have to set n = n - 1
        SELECT DISTINCT salary
        FROM Employee 
        ORDER BY salary DESC
        LIMIT 1 OFFSET N
  );
END