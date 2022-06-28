# Query-Optimization-using-PostgreSQL
Analyzing and writing efficient SQL queries in terms of cost and execution time which includes the use of different indices and investigating the performance. Done using PostgreSQL

* We have in here 4 Schemas, Each one is a separate schema/database.
* After each schema, there are one or more SQL statements. In total there are 12 queries you are going to optimize.

# The Schemas:

* Schema 1:

![Schema 1](https://user-images.githubusercontent.com/105018459/176202995-14647a64-a8d8-4606-a494-941ee735f9e8.PNG)



* Schema 2:

![Schema 2](https://user-images.githubusercontent.com/105018459/176203113-73713a97-fedc-46ac-8ac4-bd155179eecd.PNG)


* Schema 3:

![Schema 3](https://user-images.githubusercontent.com/105018459/176203161-1e8aed4e-228e-4a9d-8516-c9ac344b0304.PNG)


* Schema 4:

![Schema 4](https://user-images.githubusercontent.com/105018459/176203210-a24bf990-1c91-4074-a18f-a1f05d9c7c9c.PNG)




# The Queries are:
 
Query 1 -->  select * 
from (select * 
from student 
where 
department = 'CSEN') as CS1_student 
full outer join
(select * 
from takes t inner join section s 
on t.section_id = s.section_id 
where semester = 1 
and 
year = 2019) as sem1_student 
on CS1_student.id = sem1_student.student_id; 


Query 2 --> select distinct pnumber 
from project 
where pnumber in
(select pnumber 
from project, department d, employee e 
where e.dno=d.dnumber 
and 
 d.mgr_snn=ssn 
and 
 e.lname='employee1' ) 
or 
pnumber in
(select pno 
 from works_on, employee 
 where essn=ssn and lname='employee1' ); 

    
Query 3 --> select lname, fname 
from employee 
where salary > all ( 
select salary 
from employee 
where dno=5 );


Query 4 --> select e.fname, e.lname 
from employee as e 
where e.ssn in ( 
select essn 
from dependent as d 
where e.fname = d.dependent_name 
and 
e.sex = d.sex ); 


Query 5 --> select fname, lname 
from employee 
where exists ( select * 
 from dependent 
 where ssn=essn ); 
 
 
Query 6 --> select dnumber, count(*) 
from department, employee 
where dnumber=dno 
and 
salary > 40000 
and 
dno = ( 
 select dno 
 from employee 
 group by dno 
 having count (*) > 5) 
group by dnumber; 

Query 7 --> select s.sname 
from sailors s 
where 
s.sid in( select r.sid 
from reserves r 
where r.bid = 103 ); 


Query 8 --> select s.sname 
from sailors s 
where s.sid in ( select r.sid 
from reserves r 
where r. bid in (select b.bid 
from boat b 
where b.color = 'red'));


Query 9 --> select s.sname 
from sailors s, reserves r, boat b 
where 
s.sid = r.sid 
and 
r.bid = b.bid 
and 
b.color = 'red' 
and 
s.sid in ( select s2.sid 
from sailors s2, boat b2, reserves r2 
where s2.sid = r2.sid 
and 
r2.bid = b2.bid 
and 
b2.color = 'green');


Query 10 --> select * 
from actor 
where act_id in( 
select act_id 
from movie_cast 
where mov_id in( 
select mov_id 
from movie 
where mov_title ='Annie Hall'));


Query 11 --> select dir_fname, dir_lname 
from director 
where dir_id in( 
select dir_id 
from movie_direction 
where mov_id in( 
select mov_id 
from movie_cast 
where role =any( select role 
from movie_cast 
 where mov_id in( 
select mov_id 
from movie 
where
mov_title='Eyes 
Wide Shut')))); 


Query 12 --> select mov_title 
from movie 
where mov_id in ( 
select mov_id 
from movie_direction 
where dir_id= 
(select dir_id 
from director 
where dir_fname='Woddy' 
and 
dir_lname='Allen')); 

    

* Schema 1 contains (Query 1)
* Schema 2 contains (Query 2,3,4,5,6)
* Schema 3 contains (Query 7,8,9)
* Schema 4 contains (Query 10,11,12)



-For each Query, We used these indices to check whether it will enhance the performances or not:
 
 1- Query without an index.
 
 2- Query with B+ trees indices only.
 
 3- Query with hash indices only.
 
 4- Query with BRIN indices only.
 
 5- Query with mixed indices (any mix of indices).
 
 
 
# Populating the data of the tables of each Schema:
-This was done using the Java file/package called MP2DataGenerator and it contains 4 classes, named Schema1, Schema2, Schema3, Schema4 respectively.

-Schema1 java class was used to populate Schema 1 tables.

-Schema2 java class was used to populate Schema 2 tables.

-Schema3 java class was used to populate Schema 4 tables.

-Schema4 java class was used to populate Schema 4 tables.

-In order to link Eclipse with pgAdmin, we had the library called "postgresql-jdbc.jar" which helped us transform the data generated from executing the java classes to the tables of each Schema.


# Technologies

Java SE: 1.8

Eclipse IDE

pgAdmin 4 v6

postgresql-jdbc.jar Library


# Setup

In order to run the java file:
1. Import the java project MP2DataGenerator into Eclipse IDE 
2. Right Click on the project name, choose build path 
3. Click on the add external archives option 
4. Browse for "postgresql-jdbc.jar ", which is inside the project folder "MP2DataGenerator" 


Note: Make sure to have only one jdbc driver imported. There is already one imported in 
the project provided to you. You will need to edit the path to that or remove it and add 
your own. You can do that in Eclipse IDE from Build Path -> Configure Build Path... 

 
 
 
 
 
 
 
 
 
