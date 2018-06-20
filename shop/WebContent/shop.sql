--멤버-회원가입/로그인/내정보수정/로그아웃/탈퇴

--판매자-상품등록/상품삭제/상품정보수정/내가올린 상품목록보기

--구매자-상품목록보기/구매/장바구니/상품검색

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