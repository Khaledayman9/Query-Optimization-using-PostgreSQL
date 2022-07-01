--Query2

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


--Query3
select *
from employee
where salary > (select max(salary) from employee group by dno having dno = 5);


--Query4
select e.fname,e.lname 
from employee e , dependent d
where e.fname = d.dependent_name
and e.sex = d.sex
and e.ssn = d.essn;


--Query5
select distinct fname, lname
from employee e,dependent d
where e.ssn = d.essn; 


--Query6
select s1.dno, count(*)
from (select dno
	  from employee e
       where e.salary > 40000) s1 inner join (  select dno
												from employee e
												group by e.dno 
												having count(*) > 5) s2
		on s1.dno = s2.dno 
		group by s1.dno;



