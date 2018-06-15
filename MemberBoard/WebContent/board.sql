drop table board
drop sequence seq_board;

create table board(
num number primary key,
pwd varchar2(30),
writer varchar2(20),
board_date date,
content varchar2(100)
);

create sequence seq_board;