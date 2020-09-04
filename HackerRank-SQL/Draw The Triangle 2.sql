set @star:=0;
select repeat('* ',@star:=@star+1)
from information_schema.tables
where @star<20