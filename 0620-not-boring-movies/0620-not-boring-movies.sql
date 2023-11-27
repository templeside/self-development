# Write your MySQL query statement below
# cinema (id int, movie varchar(255), description varchar(255), rating float(2, 1), primary key(id))

# movie, id, description
select  id,movie, description, rating
from Cinema
# where description !="boring" and odd number
Where description !="boring" and id%2= 1
# order by rating in desc.
ORDER BY rating desc;