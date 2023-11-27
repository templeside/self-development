# Write your MySQL query statement below
# Activity (machine_id int, process_id int, activity_type ENUM('start', 'end'), timestamp float)
# divide up by machines.
# tables split up in two cases - 'start', 'end'
# In the first one, a solution based on 'join' is achieved (which is more self-explanatory)

select a1.machine_id, round(avg(a2.timestamp- a1.timestamp), 3) as processing_time
from Activity a1
join Activity a2
on a1.machine_id = a2.machine_id and a1.process_id = a2.process_id
and a1.activity_type='start' and a2.activity_type = 'end'
group by a1.machine_id