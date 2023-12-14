# Write your MySQL query statement below
# Users
# | user_id     | int     |
# | user_name   | varchar |
# Register
# | contest_id  | int     |
# | user_id     | int     |

SELECT contest_id
    , ROUND(COUNT(DISTINCT user_id) * 100 / (SELECT COUNT(*) FROM Users), 2) AS percentage
FROM Register 
GROUP BY contest_id
    ORDER BY percentage DESC, contest_id
