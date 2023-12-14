# Write your MySQL query statement below
# Queries(query_name, result, position, rating)
# quality = avg( (rating/ position))
# poor query = avg(case rating<3 1 else 0)*100 

SELECT query_name, ROUND(SUM(rating/position)/ COUNT(rating),2) as quality, Round(avg(rating<3)*100,2) as poor_query_percentage
FROM Queries
where query_name is not null
GROUP BY query_name;
