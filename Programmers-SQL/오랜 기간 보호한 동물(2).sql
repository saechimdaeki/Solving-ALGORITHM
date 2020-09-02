SELECT ins.animal_id, ins.name from animal_ins ins, animal_outs outs
where ins.animal_id = outs.animal_id order by outs.datetime-ins.datetime desc 
limit 2