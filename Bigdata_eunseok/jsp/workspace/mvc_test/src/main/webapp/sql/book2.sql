-- 테이블 생성
create table book2(
    book_num varchar2(20) not null,
    book_subject varchar(30) not null,
    book_writer varchar(15) not null,
    book_publisher varchar(20),
    book_price number,
    book_date date,
    primary key(book_num)
);

-- 데이터 삽입
insert into book2 values ('1234', '제목', '홍길동', '제인출판사', 30000, '20-08-31');

-- 데이터 리스트
select * from 
(select rownum rn, tt.* from (select * from book2 order by book_num asc) tt)
where rn>=1 and rn<=5;

-- 데이터 갯수
select count(*) as cnt from book2;