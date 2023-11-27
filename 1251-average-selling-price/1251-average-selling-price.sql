# Write your MySQL query statement below
# prices(product_id, start_date, end_date, price, PRIMARY KEY (product_id, start_date, end_date))
# UnitsSold(product_id, purchase_date, units)

# average selling price for each product

# calculate by average selling price of product = SUM(units*price)/SUM(units)
SELECT prices.product_id, IFNULL(ROUND(SUM(prices.price* UnitsSold.units) / SUM(UnitsSold.units),2),0) AS average_price
from prices
# join 
LEFT JOIN UnitsSold
ON prices.product_id = UnitsSold.product_id AND UnitsSold.purchase_date Between start_date and end_date
# group by each product
GROUP BY prices.product_id;
