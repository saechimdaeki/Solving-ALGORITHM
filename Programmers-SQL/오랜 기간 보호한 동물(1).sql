SELECT name,datetime from animal_ins where animal_id not in 
(select animal_id from animal_outs) order by datetime limit 3



/* join을사용한 타인의 sql문
SELECT A.NAME, A.DATETIME
FROM ANIMAL_INS A LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.DATETIME
LIMIT 3 

*/