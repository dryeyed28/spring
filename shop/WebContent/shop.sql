--���-ȸ������/�α���/����������/�α׾ƿ�/Ż��

--�Ǹ���-��ǰ���/��ǰ����/��ǰ��������/�����ø� ��ǰ��Ϻ���

--������-��ǰ��Ϻ���/����/��ٱ���/��ǰ�˻�

create table shop_member(
id 		varchar2(20) primary key,
pwd 	varchar2(20),
name 	varchar2(20),
email 	varchar2(50),
addr 	varchar2(50),
type 	number
);

create table shop_product(
num			number primary key,
name		varchar2(500) not null,
quantity	number not null,
price		number not null,
img			varchar2(500),
content		varchar2(500),
s_id		varchar2(20) references shop_member(id) on delete cascade
);

create sequence seq_shop_product;