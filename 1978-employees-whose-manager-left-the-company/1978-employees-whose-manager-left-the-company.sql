# Write your MySQL query statement below
# SELECT e2.employee_id

# SELECT e.employee_id
SELECT employee_id
FROM Employees
WHERE salary<30000
AND manager_id NOT IN(
    SELECT DISTINCT(employee_id) FROM Employees
    )
ORDER BY employee_id;