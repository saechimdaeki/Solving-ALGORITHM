SELECT ins.animal_id, ins.animal_type, ins.name
FROM animal_ins ins, animal_outs outs
WHERE ins.sex_upon_intake like 'Intact%' 
and ins.animal_id = outs.animal_id 
AND ins.sex_upon_intake != outs.sex_upon_outcome
order by animal_id

/* 너무 직관적이다... 남들의 sql작성문을 보고 배우자!!!! */