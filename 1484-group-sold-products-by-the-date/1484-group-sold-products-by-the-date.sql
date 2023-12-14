# Write your MySQL query statement below

# Write a solution to find for each date the number of different products sold and their names.

SELECT sell_date, count(DISTINCT (product)) AS num_sold, GROUP_CONCAT(DISTINCT(product)) AS products
FROM Activities
GROUP BY sell_date
ORDER BY sell_date, product;