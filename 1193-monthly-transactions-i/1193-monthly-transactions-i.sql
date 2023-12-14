# Write your MySQL query statement below

# Transactions
# for each month and country, 
# the number of transactions and 
# their total amount, 
# the number of approved transactions and 
# their total amount.

# 이거 하려면 어떻게 date를 구워 삶는지 알아야 한다.
# select count(amount), sum(amount), count(state="approved"), sum(case state="approved" amount else 0)
# group by country, month로 나누고

# SELECT Format(trans_date, 'yyyy-dd') AS Month, country, count(*) AS trans_count, count(state="approved"), sum(case state="approved" amount else 0)
SELECT DATE_FORMAT(trans_date, "%Y-%m") AS month, country, 
    count(id) AS trans_count, 
    sum(state="approved") AS approved_count, 
    SUM(amount) as trans_total_amount,
    SUM(if(state="approved", amount,0)) as approved_total_amount
    
FROM Transactions
Group by month, country
