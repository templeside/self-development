# Write your MySQL query statement below
# Queries(query_name, result, position, rating)

# | query_name | quality | poor_query_percentage |

# quality = avg(query rating/ position)
# poor query percentage = rating<3 / count(query_name)



Select query_name, 
    ROUND(AVG(rating/position),2) as quality,  
    ROUND(AVG(rating<3) *100,2)as poor_query_percentage
from Queries 
group by query_name;