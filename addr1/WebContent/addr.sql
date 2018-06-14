
drop table addr
create sequence addr_seq;

create table addr(
 num number primary key,
 name varchar2(10) not null,
 tel varchar2(20) not null,
 address varchar2(30) not null,
 Postal number not null
);