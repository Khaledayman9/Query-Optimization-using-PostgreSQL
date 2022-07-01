--Query7
create materialized view optReservesView as
select r.sid from reserves r where r.bid = 103;

select s.sname
from sailors s
where
s.sid in (select * from optReservesView);


--Query8
create materialized view optBoatView as
select r.sid
from reserves r where r.bid in(select b.bid from boat b where b.color = 'red');

select distinct s.sname
from sailors s
where s.sid in (select sid from optBoatView);


--Query9
select s.sname
from sailors s inner join (reserves r inner join (select * from boat b where color = 'red') as b on r.bid = b.bid) on s.sid = r.sid
and
exists ( select r2.sid
		 from reserves r2 inner join (select * from boat b2 where color = 'green') as b2 on r2.bid = b2.bid
	   	 where r2.sid = s.sid);

