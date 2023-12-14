# Write your MySQL query statement below
# Project
# | project_id  | int     |
# | employee_id | int     |    
# Employee
# | employee_id      | int     |
# | name             | varchar |
# | experience_years | int     |

# average experience years of all the employees for each project, rounded to 2 digits.

select p.project_id, IFNULL(ROUND(AVG(e.experience_years),2),0) as average_years
FROM Project as p
CROSS JOIN Employee as e
on p.employee_id = e.employee_id
GROUP BY p.project_id;