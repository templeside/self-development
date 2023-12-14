# Write your MySQL query statement below
select e1.name
FROM Employee e1
INNER JOIN Employee e2
on e1.id = e2.managerId
group by e2.managerId
having count(e1.id)>=5;