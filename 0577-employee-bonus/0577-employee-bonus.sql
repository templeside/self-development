# Write your MySQL query statement below
# Employee (empId, name, supervisor, salary)
# Bonus(empId, bonus)

select emp.name, bonus.bonus
from Employee emp
Left Join Bonus bonus
on emp.empId = bonus.empId
where bonus.bonus< 1000 or bonus.bonus IS NULL