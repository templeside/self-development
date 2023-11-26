# Write your MySQL query statement below
# Tweets(tweet_id int, content varchar(50))
# invalid len(content)>15

select tweet_id
from Tweets
where char_length(content)>15;