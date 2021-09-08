<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script type="text/javascript" src="../script/memberScript.js?v=3">
</script>
</head>
<body>
   <form action="memberModify.do" name="modifyForm" method="post"  onsubmit="checkModify();return false;">
      <table border="1" width="550">
         <tr>
            <td width="100">이름</td>
            <td><input type="text" name="name" value="${dto.name}" readonly/></td>      
         </tr>      
         <tr>
            <td>아이디</td>
            <td><input type="text" name="id" value="${dto.id}" readonly/></td>      
         </tr>      
         <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pwd" value="${dto.pwd}"></td>      
         </tr>      
         <tr>
            <td>재확인</td>
            <td><input type="password" name="repwd" value="${dto.pwd}"></td>      
         </tr>      
         <tr>
            <td>성별</td>
            <td>
            	<c:if test="${dto.gender == '남' }">
            		<input type="radio" name="gender" value="남" checked="checked">남
               		<input type="radio" name="gender" value="여">여
            	</c:if>
            	<c:if test="${dto.gender == '여' }">
            		<input type="radio" name="gender" value="남">남
               		<input type="radio" name="gender" value="여" ch>여
            	</c:if>
            </td>      
         </tr>      
         <tr>
            <td>이메일</td>
            <td>
               <input type="text" name="email1" value="${dto.email1}">@
               <input type="text" name="email2" value="${dto.email2}">
            </td>      
         </tr>      
         <tr>
            <td>핸드폰</td>
            <td>
               <input type="text" name="tel1" size="10" value="${dto.tel1}">-
               <input type="text" name="tel2" size="10" value="${dto.tel2}">-
               <input type="text" name="tel3" size="10" value="${dto.tel3}">
            </td>      
         </tr>      
         <tr>
            <td>주소</td>
            <td><input type="text" name="addr" size="50" value="${dto.addr}"></td>      
         </tr>      
         <tr>
            <td colspan="2" align="center">
               <input type="submit" value="수정 완료">
               <input type="reset" value="다시 작성">
            </td>
      </table>
   </form>
   <a href="../main/index.jsp">메인화면</a>

</body>
</html>