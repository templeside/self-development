# Write your MySQL query statement below
# Views (article_id int, author_id int, viewer_id int, view_date date)
# 
select distinct(author_id) as id
from Views
where author_id = viewer_id
order by author_id ;