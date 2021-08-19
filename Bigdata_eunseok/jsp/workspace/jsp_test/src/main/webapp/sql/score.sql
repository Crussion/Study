create table score(
    student_num number not null,
    student_name varchar2(12) not null,
    score_kor number,
    score_eng number,
    score_math number,
    score_total number,
    score_avg number,
    PRIMARY KEY(student_num)
);

insert into score values (100, '홍길동', 60, 70, 80, 210, 70);

select * from
(select rownum rn, tt.* from
(select * from score order by student_num asc) tt)
where rn>=1 and rn<=5;

select count(*) as cnt from score;