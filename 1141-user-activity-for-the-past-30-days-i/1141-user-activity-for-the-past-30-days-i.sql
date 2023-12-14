# Write your MySQL query statement below


# Write a solution to find the daily active user count for a period of 30 days ending 2019-07-27 inclusively. A user was active on someday if they made at least one activity on that day.


select activity_date AS day, count(distinct(user_id)) AS active_users
FROM Activity
Where DateDiff('2019-07-27', activity_date  )<30 and DateDiff('2019-07-27', activity_date  )>=0
GROUP BY activity_date;