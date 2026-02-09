CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
      SELECT salary as getNthHighestSalary
      FROM (
        SELECT 
            *,
            DENSE_RANK() OVER(ORDER BY salary DESC) as 'ranking'
        FROM Employee
      ) as s
      WHERE ranking = N
      LIMIT 1
  );
END