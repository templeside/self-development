# Write your MySQL query statement below
# Sales (sale_id int, product_id int, year int, quantity int, price int)
# Product (product_id int, product_name varchar(10))

SELECT Product.product_name, Sales.year, Sales.price
from Sales
INNER Join Product 
on Product.product_id = Sales.product_id;

# SELECT 
#     DISTINCT p.product_name, s.year, s.price
# FROM 
#     Sales s
# JOIN 
#     Product p
# ON
#     s.product_id = p.product_id;