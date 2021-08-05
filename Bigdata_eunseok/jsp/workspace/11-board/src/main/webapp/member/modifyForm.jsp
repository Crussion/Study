<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = session.getAttribute("memId").toString();

	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.member_read(id);
	String name = dto.getName();
	String pwd = dto.getPwd();
	String gender = dto.getGender();
	String email1 = dto.getEmail1();
	//String email2 = dto.getEmail2();
	//String tel1 = dto.getTel1();
	String tel2 = dto.getTel2();
	String tel3 = dto.getTel3();
	String addr = dto.getAddr();
	//String logtime = dto.getLogtime();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/memberScript.js?ver=new"></script>
</head>
<body>
	<form action="modify.jsp" method="post" name="modify_frm" 
		onsubmit="return modify();">
		<table border="1">
			<tr>
				<td width="70" class="col">이름</td>
				<td><input type="text" name="name" value="<%=name %>" size="50" disabled="disabled"></td>
			</tr>
			<tr>
				<td class="col">아이디</td>
				<td>
					<input type="text" name="id" size="50" value="<%=id %>" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td class="col">비밀번호</td>
				<td><input type="password" name="pwd" size="50" value="<%=pwd %>"></td>
			</tr>
			<tr>
				<td class="col">재확인</td>
				<td><input type="password" name="pwd_chk" size="50"></td>
			</tr>
			<tr>
				<td class="col">성별</td>
				<td>
				<%if(gender.equals("male")) {%>
					<input type="radio" name="gender" value="male" checked>남
					<input type="radio" name="gender" value="female">여
				<%} else if(gender.equals("female")) {%>
					<input type="radio" name="gender" value="male">남
					<input type="radio" name="gender" value="female" checked>여
				<%} else {%>
					<input type="radio" name="gender" value="male">남
					<input type="radio" name="gender" value="female">여
				<%} %>
				</td>
			</tr>
			<tr>
				<td class="col">이메일</td>
				<td>
					<input type="text" name="email1" value="<%=email1 %>">
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
					<input type="text" name="tel2" size="10" value="<%=tel2 %>">
					-
					<input type="text" name="tel3" size="10" value="<%=tel3 %>">
				</td>
			</tr>
			<tr>
				<td class="col">주소</td>
				<td><input type="text" name="addr" size="50" value="<%=addr %>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="정보수정">
					<input type="reset" value="다시작성">
				</td>
			</tr>
		</table>
	</form>
	<a href="../main/index.jsp">메인 화면</a>
</body>
</html>