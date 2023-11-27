# Write your MySQL query statement below
#  Teacher(teacher_id, subject_id, dept_id)
select teacher_id, count(distinct(subject_id)) as cnt
from Teacher
group by teacher_id;