drop table member;
create table member(
id	varchar2(20) primary key,
pwd varchar2(20) not null,
name varchar2(20) not null,
msg varchar2(100)
);