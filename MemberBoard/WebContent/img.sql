drop table img;
drop sequence seq_img_board;
drop sequence seq_img;

create table img(
num number primary key,
path varchar2(100) not null,
title varchar2(30),
id varchar2(20)
);

create sequence seq_img_board;
create sequence seq_img;

create table img_board(
num number primary key,
content varchar2(50),
writer varchar2(20),
img_num number references img(num));
