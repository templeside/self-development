# Write your MySQL query statement below
# Employees (id int, name varchar(20))
# EmployeeUNI (id int, unique_id int)
select EmployeeUNI.unique_id, Employees.name
from Employees
LEFT JOIN EmployeeUNI on EmployeeUNI.id = Employees.id;

