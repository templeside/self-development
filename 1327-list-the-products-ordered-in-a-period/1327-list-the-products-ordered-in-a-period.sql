# Write your MySQL query statement below
select product_name, sum(unit) as unit
FROM Products p
LEFT JOIN Orders o
ON p.product_id = o.product_id and substring(o.order_date,1,7)= '2020-02'
GROUP BY product_name
HAVING sum(unit)>=100