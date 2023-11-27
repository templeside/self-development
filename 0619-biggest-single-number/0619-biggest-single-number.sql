# Write your MySQL query statement below
select IF(COUNT(num) =1, num, null) AS num
from MyNumbers
group by num
order by count(num), num desc limit 1;

# SELECT IF(COUNT(num) =1, num, null) AS num
# FROM MyNumbers 
# GROUP BY num 
# ORDER BY COUNT(num), num DESC LIMIT 1;
