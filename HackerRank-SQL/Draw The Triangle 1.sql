set @star:=21;
select repeat('* ', @star:=@star-1)
from information_schema.tables