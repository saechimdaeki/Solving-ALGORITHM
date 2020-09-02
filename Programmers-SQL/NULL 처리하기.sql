SELECT animal_type, IFNULL(name,'No name'), sex_upon_intake from animal_ins 
-- IFNULL(X,Y) x==null Y , x!=null X