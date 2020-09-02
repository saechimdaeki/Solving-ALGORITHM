SELECT ins.ANIMAL_ID,INS.NAME
from animal_ins ins, animal_outs outs
where ins.datetime> outs.datetime and ins.animal_id =outs.animal_id order by ins.datetime