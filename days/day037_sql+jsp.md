day037

 - Todo1 : mysql
 - Todo2 : jsp

---

### mysql

-- ■ 진행1. CRUD (SELECT 집계함수) 

-- >> 1.  [진행] 
-- DDL   : CREATE , ALTER, DROP
-- DML  : INSERT, SELECT#, UPDATE, DELETE
-- DCL   : GRANT, REVOKE 

--  
-- ===== 필기
-- SELECT   검색필드1, 검색필드2,,,
-- FROM    테이블명
-- WHERE where_condition ;
--   

-- SELECT   검색필드1, 검색필드2,,,
-- FROM    테이블명
-- WHERE where_condition  
-- ORDER BY   [ASC | DESC]
-- LIMIT offset;

-- SELECT  select_expr [, select_expr] ... 
--     [FROM table_references 
--     [WHERE where_condition]
--     [GROUP BY {col_name | expr | position}, ... [WITH ROLLUP]] #
--     [HAVING where_condition]  #
--     [ORDER BY {col_name | expr | position} 
--     [LIMIT {[offset,] row_count | row_count OFFSET offset}]
--  


-- >> 2.집합(GROUP BY)과 집계함수                                          
-- avg(컬럼명)  : 집합의 평균값                                    
-- max(컬럼명)  : 집합의 최댓값                                          
-- min(컬럼명)  : 집합의 최소값                                          
-- sum(컬럼명)  : 집합의 합계                                          
-- count(*)   : 집합의 집합의 요소수                                          
--    

-- >> 3.   [ SELECT  집계함수 FROM  [테이블이름]   GROUP BY [필드명]]                                          
-- SELECT score, count(*) FROM board GROUP BY kor;                                       
-- SELECT score, count(*) FROM board GROUP BY kor;                                       
--                                           
--                                           

-- >> 4.집계결과를 다시 필터링(HAVING문)                 
-- [ SELECT   집계함수  FROM  [테이블이름]                     
--       GROUP BY [필드명]               
--       HAVING   조건               
-- ]                  
-- SELECT subject, count(*) FROM score                
-- GROUP BY kor             
-- HAVING  count(*) >= 5;         

### jsp

jsp012_milks.jsp
jsp012_insert.jsp
jsp012_update.jsp
jsp102_delete.jsp

mysqldump  -u  root -p  mbasic  >  back0520.sql : 백업코드
