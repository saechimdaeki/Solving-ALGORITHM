select if(grades.grade>=8 , students.name,null) , grades.grade,students.marks
from grades, students
where students.marks >= grades.min_mark and students.marks<= grades.max_mark
order by grades.grade desc, students.name