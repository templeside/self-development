Select employee_id, department_id
from Employee
Where primary_flag = 'Y'
UNION
Select employee_id, department_id
from Employee
group by employee_id
having count(employee_id) = 1