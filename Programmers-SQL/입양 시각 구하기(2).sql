set @hour := -1;

select (@hour := @hour+1) as HOUR,
(select count(*) from animal_outs where hour(datetime) = @hour) as COUNT
from animal_outs
where @hour < 23

/* 타인의 SQL문을 참고 한문제입니다.. 어렵네요 이건 */