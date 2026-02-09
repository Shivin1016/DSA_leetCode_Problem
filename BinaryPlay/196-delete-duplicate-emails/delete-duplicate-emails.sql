# Write your MySQL query statement below

-- 1-> way
-- DELETE FROM Person
-- WHERE id IN(
--     SELECT 
--         id
--     FROM(
--         SELECT 
--             id,
--             ROW_NUMBER() OVER(PARTITION BY email ORDER BY id) as ranking
--         FROM Person
--     )as s
--     WHERE ranking > 1
-- ) ;

-- 2 -> way
-- DELETE FROM Person
-- WHERE id NOT In(
--     SELECT id
--     FROM (
--         SELECT MIN(id) as id
--         FROM Person
--         GROUP BY email
--     ) as s
-- );

-- 3 -> way
DELETE p1 
FROM Person p1
JOIN Person p2
ON p1.email = p2.email
WHERE p1.id > p2.id;
