# Write your MySQL query statement below
SELECT max(num) AS num
FROM (
    select num
    from MyNumbers
    GROUP BY num
    HAVING COUNT(num) = 1
    )  t