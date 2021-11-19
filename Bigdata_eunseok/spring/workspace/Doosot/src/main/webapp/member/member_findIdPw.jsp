<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두솥 아이디/비밀번호 찾기</title>
<style type="text/css">
	html{width: 590px;height: 541px;border: 5px solid orange;border-bottom: 13px solid orange;}
	#header{border-bottom: 1px solid #ececec;}
	#header p{font-size: 30px; font-weight:600;}
	
	fieldset{border:none; min-height: 178px;}
	#id{border-bottom: 1px solid #ececec;}
	.title{margin-left:30px; font-size:20px;}
	table{margin:0 auto; width:500px; height:60px; text-align:center;}
	.input{width:348px; height:50px;font-size: 15px;border: 1px solid; text-align:center;}
	.tel{
		height: 50px;
		width:104px;
		border: 1px solid;
	}
	input[type='button']{width:120px; height:40px; border:none; color:dimgray;}

</style>
<script type="text/javascript" src="../script/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="header">
		<p>두솥 아이디/비밀번호 찾기</p>
	</div>
	<br>
	<div id="content">
		<fieldset id="id">
			<span class="title">아이디 찾기</span>
			<form action="" name="id_frm">
				<table>
					<tr>
						<td>
							<input type="text" class="input" name="name" placeholder="이름을 입력하세요.">
						</td>
						<td width="130px" rowspan="2">
							<input type="button" name="checking" value="아이디 찾기">
						</td>
					</tr>
					<tr>
						<td>
							<select class="tel" name="phone1" style="text-align:center;">
								<option>--- 선택 ---</option>
								<option>010</option>
								<option>011</option>
								<option>017</option>
								<option>019</option>
							</select> -
							<input type="text" class="tel" name="phone2"> -
							<input type="text" class="tel" name="phone3">
							<span id="ph_alert"></span>
						</td>
					</tr>
				</table>
				<br>
			</form>
		</fieldset>
		<br><br>
		<fieldset>
			<span class="title">새로운 비밀번호 설정</span>
			<form action="" name="pw_frm">
				<table>
					<tr>
						<td>
							<input type="text" class="input" name="find_id" placeholder="아이디를 입력하세요.">
						</td>
						<td width="130px" rowspan="2">
							<input type="button" name="checking" value="비밀번호 변경">
						</td>
					</tr>
					<tr>
						<td>
							<input type="password" class="input" name="find_pw" placeholder="새로운 비밀번호를 입력하세요.">
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</div>
</body>
</html>