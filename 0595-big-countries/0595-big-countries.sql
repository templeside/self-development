# Write your MySQL query statement below
# World (name varchar(255), continent varchar(255), area int, population int, gdp bigint)
# i need to find the big coutry, 
# area> 3000000 or population > 25000000
select name, population, area
from World
where area>= 3000000 or population >= 25000000;