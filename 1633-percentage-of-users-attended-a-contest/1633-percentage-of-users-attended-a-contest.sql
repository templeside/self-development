# Write your MySQL query statement below
# Users (user_id int, user_name varchar(20))
# Register (contest_id int, user_id int)

# select contest_id, percentage
# percentage = count attended/ num of Users
select r.contest_id, Round(Count(r.user_id )*100 / (select Count(*) from Users),2) as percentage
from Register r
Group by contest_id
Order by percentage desc, r.contest_id;