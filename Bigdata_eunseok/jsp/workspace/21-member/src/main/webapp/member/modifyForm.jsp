<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/memberScript.js?ver=new"></script>
</head>
<body>
	<form action="modify.do" method="post" name="modify_frm" 
		onsubmit="return modify();">
		<table border="1">
			<tr>
				<td width="70" class="col">이름</td>
				<td><input type="text" name="name" value="${bean.name }" size="50" disabled="disabled"></td>
			</tr>
			<tr>
				<td class="col">아이디</td>
				<td>
					<input type="text" name="id" size="50" value="${bean.id }" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td class="col">비밀번호</td>
				<td><input type="password" name="pwd" size="50" value="${bean.pwd }"></td>
			</tr>
			<tr>
				<td class="col">재확인</td>
				<td><input type="password" name="pwd_chk" size="50"></td>
			</tr>
			<tr>
				<td class="col">성별</td>
				<td>
					<c:choose>
						<c:when test="${bean.gender == 'male' }">
							<input type="radio" name="gender" value="male" checked>남
							<input type="radio" name="gender" value="female">여
						</c:when>
						<c:when test="${bean.gender == 'female' }">
							<input type="radio" name="gender" value="male">남
							<input type="radio" name="gender" value="female" checked>여
						</c:when>
						<c:otherwise>
							<input type="radio" name="gender" value="male">남
							<input type="radio" name="gender" value="female">여
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td class="col">이메일</td>
				<td>
					<input type="text" name="email1" value="${bean.email1 }">
					@
					<select name="email2">
						<option value="">---선택해주세요---</option>
						<option value="naver.com">naver.com</option>
						<option value="daum.net">daum.net</option>
						<option value="google.com">google.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="col">핸드폰</td>
				<td>
					<select name="tel1" style="width: 70px">
						<option value="">---</option>
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="012">012</option>
						<option value="013">013</option>
					</select>
					-
					<input type="text" name="tel2" size="10" value="${bean.tel2 }">
					-
					<input type="text" name="tel3" size="10" value="${bean.tel3 }">
				</td>
			</tr>
			<tr>
				<td class="col">주소</td>
				<td><input type="text" name="addr" size="50" value="${bean.addr }"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="정보수정">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>