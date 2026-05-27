day039

 - Todo1 : jsp

---

### 1. MVC1-BOARD

-[] 001. DYNAMIC WEB PROJECT
    - 프로젝트명 : borad01_mvc1

-[] 002. VIEW ( HTML+CSS+JS )
   -1) list.jsp, detail.jsp, write.jsp, write_action, edit.jsp, edit_action, delete.jsp
   -2) validator 검사
   -3) 빈칸검사

-[] 003. MODEL


상세보기
select*from mvcboard1 where bno=?

수정하기
pstmt = conn.prepareStatement("select*from mvcboard1 where bno=?");
pstmt2 = conn.prepareStatement( "update mvcboard1 set bhit = bhit + 1 where bno=?" );


삭제하기
delete from mvcboard1 where bno=? and bpass=?