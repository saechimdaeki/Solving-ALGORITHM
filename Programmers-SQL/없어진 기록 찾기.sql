SELECT animal_id,name from animal_outs
where animal_id not in(select animal_id from animal_ins) order by animal_id


/* 주석처리한것은 join을 사용한 타인의 sql문
SELECT A.ANIMAL_ID, A.NAME
FROM ANIMAL_OUTS A LEFT JOIN ANIMAL_INS B ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE B.ANIMAL_ID IS NULL
ORDER BY A.ANIMAL_ID
*/