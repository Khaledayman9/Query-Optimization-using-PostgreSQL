--Query1

select *
from (select *
create materialized view takesAndSection1 as 
select t.student_id, t.section_id, t.grade, s.semester, s.year, s.instructor_id, s.course_id, s.classroom_building, s.classroom_room_no
from takes t inner join section s
on t.section_id = s.section_id where semester = 1
and
year = 2019;

select *
from (select *
from student
where
department = 'CSEN') as CS1_student full outer join takesAndSection1 as sem1_student
on CS1_student.id = sem1_student.student_id;


