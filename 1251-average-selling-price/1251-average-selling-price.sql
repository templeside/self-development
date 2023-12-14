# Write your MySQL query statement below
# Prices
# | product_id    | int     |
# | start_date    | date    |
# | end_date      | date    |
# | price         | int     |

# UnitsSold
# | product_id    | int     |
# | purchase_date | date    |
# | units         | int     |

Select p.product_id, IFNULL(Round(sum(p.price * u.units)/ sum(u.units),2),0) AS average_price
FROM Prices p
LEFT JOIN UnitsSold u
on p.product_id = u.product_id 
    AND p.start_date <= u.purchase_date and u.purchase_date<= p.end_date
Group BY p.product_id;