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


create materialized view employeeOne
AS
select * from employee  where lname = 'employee1';

select distinct nn
from (
		select p.pnumber as nn from (department d Inner join (select * from employeeOne) e on d.dnumber = e.dno and d.mgr_snn = e.ssn) 
	    										  Inner join project p on p.dnumber = e.dno
) as s
UNION 
		select w.pno as nn from works_on w inner join (select * from employeeOne)  e on w.essn = e.ssn;



select *
from employee
where salary > (select max(salary) from employee group by dno having dno = 5);



select e.fname,e.lname 
from employee e , dependent d
where e.fname = d.dependent_name
and e.sex = d.sex
and e.ssn = d.essn;

select distinct fname, lname
from employee e,dependent d
where e.ssn = d.essn; 

select s1.dno, count(*)
from (select dno
	  from employee e
       where e.salary > 40000) s1 inner join (  select dno
												from employee e
												group by e.dno 
												having count(*) > 5) s2
		on s1.dno = s2.dno 
		group by s1.dno;



create materialized view optReservesView as
select r.sid from reserves r where r.bid = 103;

select s.sname
from sailors s
where
s.sid in (select * from optReservesView);



create materialized view optBoatView as
select r.sid
from reserves r where r.bid in(select b.bid from boat b where b.color = 'red');

select distinct s.sname
from sailors s
where s.sid in (select sid from optBoatView);


select s.sname
from sailors s inner join (reserves r inner join (select * from boat b where color = 'red') as b on r.bid = b.bid) on s.sid = r.sid
and
exists ( select r2.sid
		 from reserves r2 inner join (select * from boat b2 where color = 'green') as b2 on r2.bid = b2.bid
	   	 where r2.sid = s.sid);

select *
from actor
where act_id in(
select act_id
from movie_cast mc inner join movie m on mc.mov_id = m.mov_id
where m.mov_title ='Annie Hall'); 


create materialized view eyesWideShutMovieID as
select  mov_id 
from movie 
where mov_title='Eyes Wide Shut';

create materialized view rolesInEyesWideShut as
select role 
from movie_cast 
where mov_id =ANY (select mov_id from eyesWideShutMovieID);

create materialized view moviesCastRoles as
select mov_id 
from movie_cast 
where role =any(select * from rolesInEyesWideShut );

create materialized view movieDirection as
select dir_id 
from movie_direction
where mov_id in(select * from moviesCastRoles);


select dir_fname, dir_lname
from  director
where dir_id in(select * from movieDirection);


select mov_title
from movie
where mov_id in (
select mov_id
from movie_direction md inner join director d on md.dir_id = d.dir_id
where dir_fname='Woddy'
and
dir_lname='Allen'); 