# Write your MySQL query statement below

-- 1-> way
-- SELECT actor_id , director_id
-- FROM ActorDirector 
-- GROUP BY actor_id , director_id
-- HAVING COUNT(timestamp) >= 3;

-- 2 -> way
SELECT actor_id , director_id
FROM(
    SELECT actor_id , director_id , COUNT(timestamp) as cnt
    FROM ActorDirector
    GROUP BY actor_id , director_id
) as s
WHERE s.cnt >= 3;