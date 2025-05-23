# Write your MySQL query statement below
select 
round(sum(if(order_date = customer_pref_delivery_date , 1, 0)) * 100 /count(distinct customer_id),2)  AS immediate_percentage
from delivery 
where(customer_id , order_date) IN (
    select customer_id , MIN(order_date) AS first_order_date
    from Delivery
    group by customer_id
)



/*\U0001f50d Problem Context (likely from LeetCode SQL problem):
We have a delivery table with:

customer_id: who placed the order

order_date: when the order was placed

customer_pref_delivery_date: when the customer wanted the delivery

We are calculating the percentage of customers who received their first order on the date they preferred.

\U0001f9e0 Line-by-Line Breakdown:
SELECT ROUND(...) AS immediate_percentage
We are selecting a single computed value called immediate_percentage.

ROUND(..., 2) rounds the result to 2 decimal places for percentage formatting.

SUM(IF(order_date = customer_pref_delivery_date, 1, 0))
IF(...) is a conditional statement:

Returns 1 if order_date == customer_pref_delivery_date

Returns 0 otherwise

SUM(...) adds up all the 1s → i.e., counts how many first orders were delivered on the customer's preferred date.

✅ This is the numerator of the percentage.

* 100 / COUNT(DISTINCT customer_id)
Multiply the above count by 100 to convert it into a percentage.

COUNT(DISTINCT customer_id) counts the number of unique customers who placed at least one order.

✅ This is the denominator — total number of customers' first orders.

FROM delivery
The main table being queried.

WHERE (customer_id, order_date) IN (...)
Filters the rows to include only the first order for each customer.

We're only interested in checking if the first order was delivered immediately or not.

Subquery:
sql
Copy
Edit
SELECT customer_id, MIN(order_date) AS first_order_date
FROM Delivery
GROUP BY customer_id
For each customer (GROUP BY customer_id):

Find the earliest order date → this is their first order.

So What Does the WHERE Clause Do?
sql
Copy
Edit
WHERE (customer_id, order_date) IN (subquery)
Keeps only those rows in the main query where:

customer_id matches AND

order_date is their first order date.

\U0001f9fe Final Output:
A single value: immediate_percentage

It tells us:
What % of customers received their very first order on their preferred delivery date?

*/