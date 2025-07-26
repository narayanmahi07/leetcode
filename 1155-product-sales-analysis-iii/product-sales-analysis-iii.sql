# Write your MySQL query statement below
Select 
product_id,
year AS first_year,
quantity,
price

from sales
where (product_id , year) IN (
    select product_id , MIN(year) AS f_year
    from sales
    group by product_id
)