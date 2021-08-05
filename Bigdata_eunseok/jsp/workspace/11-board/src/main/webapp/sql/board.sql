--------------------------------------------------------
-- 글 관리 테이블
create table board(
    seq number not null,                    --글번호
    id varchar2(30) not null,               --아이디
    name varchar2(40) not null,             --이름
    subject varchar2(255) not null,         --제목
    content varchar(4000) not null,         --내용
    hit number default 0,                   --조회수
    logtime date default sysdate            --작성일
);

--시퀀스 객체 생성
create sequence seq_board nocache nocycle;
--시퀀스 객체 삭제
drop sequence seq_board;

-- 글 데이터 저장
insert into board values
(seq_board.nextval, 'num1', '홍길동', '내일은', '웃으리.....', 0, sysdate);

-- 전체 확인
select * from board;
-- 특정 글번호로 확인
select * from board where seq=1;

-- 데이터 삭제
delete board where seq=1;

commit;

-- 인덱스 뷰
-- 데이터 베이스에 저장된 데이터를 몇개씩 묶어서 불러오는 방법
select * from board order by seq desc;  -- seq 기준 내림차순

-- rownum : hidden column, 행(목록)의 숫자를 나타냄
select rownum rn, tt.* from
(select * from board order by seq desc) tt;

select * from
(select rownum rn, tt.* from
(select * from board order by seq desc) tt)
where rn>=1 and rn<=5;

-- 5개씩 잘라서 출력
select seq, id, name, subject, content, hit, to_char(logtime, 'YYYY.MM.DD')as logtime from
(select rownum rn, tt.* from
(select * from board order by seq desc) tt)
where rn>=1 and rn<=5;

-- 조회수 올리기
update board set hit=hit+1 where seq=40;

-- 총 데이터 수
select count(*) as cnt from board;
---------------------------------------------------------