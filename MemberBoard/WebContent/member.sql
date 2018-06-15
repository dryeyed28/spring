drop table member;
create table member
(
 id		varchar2(50) primary key,
 pwd	varchar2(50) not null,
 name	varchar2(50) not null,
 email	varchar2(50) not null
);
