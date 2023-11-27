# Write your MySQL query statement below
# Visits(visit_id int, customer_id int)
# Transactions(transaction_id int, visit_id int, amount int)
# there are two data tables Visits, Transactions. 
# the condition should be the ID, which transaction is null.

# Visits, Transactions
# Common - Visits.visit_id = Transactions.visit_id


Select Visits.customer_id, count(Visits.customer_id) as count_no_trans
from Visits
Left Join Transactions
on Visits.visit_id = Transactions.visit_id
where Transactions.transaction_id IS NULL
group by Visits.customer_id;

