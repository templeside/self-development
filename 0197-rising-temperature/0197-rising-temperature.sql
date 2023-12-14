# Write your MySQL query statement below

select today.id
FROM Weather today
LEFT JOIN Weather yesterday
on DateDiff(today.recordDate, yesterday.recordDate) = 1
where today.temperature> yesterday.temperature;
