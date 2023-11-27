# Write your MySQL query statement below
# for the table, it should be joining with recordDate = recordDate-1.
# and compare the two temperature.

SELECT curr.id 
FROM Weather curr
LEFT JOIN Weather yester
# ON curr.recordDate = yester.recordDate+1
ON DATEDIFF(curr.recordDate, yester.recordDate) =1
where curr.temperature> yester.temperature;