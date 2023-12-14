# Write your MySQL query statement below
# Signups
#     user_id, time_stamp
# Confirmations 
#     user_id, time_stamp, action
select s.user_id, round(avg(if(c.action="confirmed",1,0)),2) as confirmation_rate
from Signups as s 
left join Confirmations as c 
on s.user_id= c.user_id 
group by user_id;
