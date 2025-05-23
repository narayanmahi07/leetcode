# Write your MySQL query statement below
select round(count(distinct player_id) / (select count(distinct player_id) from Activity) , 2 ) AS fraction
from Activity
where (player_id , Date_SUB(event_date , INTERVAL 1 DAY) ) IN(
    select player_id, MIN(event_date) AS first_login
    from Activity
    Group by player_id
)