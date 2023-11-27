# Write your MySQL query statement below
# triangle can be done sum(samller two)> biggest
# select t.x, t.y, t.z, (case when  (t.x+t.y> t.z or t.y+t.z>t.x or t.z+t.x>t.y) then 'Yes' else 'No') as triangle
# from Triangle t 

select t.x, t.y, t.z,
  (case when t.x+t.y > t.z and t.y+t.z > t.x and t.z+t.x > t.y then 'Yes' else 'No' end) as triangle
from Triangle t
