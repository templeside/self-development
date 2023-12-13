# Write your MySQL query statement below
SELECT name, population, area
FROM World as w
# it has an area of at least three million (i.e., 3000000 km2), or
# it has a population of at least twenty-five million (i.e., 25000000).
WHERE w.area>=3000000 OR w.population >=25000000;