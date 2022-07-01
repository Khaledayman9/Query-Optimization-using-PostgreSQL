--Query10
select *
from actor
where act_id in(
select act_id
from movie_cast mc inner join movie m on mc.mov_id = m.mov_id
where m.mov_title ='Annie Hall'); 

--Query11
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



--Query12
select mov_title
from movie
where mov_id in (
select mov_id
from movie_direction md inner join director d on md.dir_id = d.dir_id
where dir_fname='Woddy'
and
dir_lname='Allen'); 