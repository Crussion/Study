<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/memberScript.js?v=new">
</script>
<style type="text/css">
.col {text-align: center}
</style>
</head>
<body>
	<form action="write.do" method="post" name="frm" onsubmit="return doSubmit();">
		<table border="1">
			<tr>
				<td width="70" class="col">이름</td>
				<td><input type="text" name="name" placeholder="이름 입력" size="50"></td>
			</tr>
			<tr>
				<td class="col">아이디</td>
				<td>
					<input type="text" name="id" size="38">
					<input type="button" value="중복확인" onclick="return checkId();">
				</td>
			</tr>
			<tr>
				<td class="col">비밀번호</td>
				<td><input type="password" name="pwd" size="50"></td>
			</tr>
			<tr>
				<td class="col">재확인</td>
				<td><input type="password" name="pwd_chk" size="50"></td>
			</tr>
			<tr>
				<td class="col">성별</td>
				<td>
					<input type="radio" name="gender" value="male" checked>남
					<input type="radio" name="gender" value="female">여
				</td>
			</tr>
			<tr>
				<td class="col">이메일</td>
				<td>
					<input type="text" name="email1">
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
					<input type="text" name="tel2" size="10">
					-
					<input type="text" name="tel3" size="10">
				</td>
			</tr>
			<tr>
				<td class="col">주소</td>
				<td><input type="text" name="addr" size="50"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="회원가입">
					<input type="reset" value="다시작성">
					<input type="hidden" name="check" value="false">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>