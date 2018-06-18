drop table sns_member;
drop table sns_board;
drop sequence sns_board_seq;ss

create table sns_member(
	id varchar2(20) primary key,
	pwd varchar2(20) not null;
	name varchar2(20) not null,
	sg number not null;
	address varchar2(50),
	tel varchar2(20) not nulls

create table sns_board(
num number primary key,
writer_id varchar2(20) not null,
content varchar2(100)
);

create sequence sns_board_seq
increment by 1
start with 1
maxvalue 9999
nocache
nocycle;
