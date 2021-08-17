<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${delete > 0}){
		alert("삭제 성공");
	}else if(${delete == 0}){
		alert("삭제 실패");
	}
	if(${modify > 0}){
		alert("수정 성공");
	}else if(${modify == 0}){
		alert("비밀 번호가 다릅니다.");	
	}
</script>
</head>
<body>
<div align="center">
	<table width="500" height="400">
		<tr>
			<th colspan="2"><h2>글 내용 상세 보기</h2></th>
		</tr>
		<tr>
			<td>제목 : ${bean.board_subject }</td>
			<td align="right">첨부파일 : <a href="fileDown.do?downFile=${bean.board_file }" >${bean.board_file }</a></td>
		</tr>
		<tr>
			<td colspan="2" valign="top" align="center" height="300" bgcolor="orange">
				${bean.board_content }
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a href="#">[답변]</a>
				<a href="boardModifyForm.do?pg=${pg }&board_num=${bean.board_num }">[수정]</a>
				<a href="board/boardDelete.jsp?pg=${pg }&board_num=${bean.board_num }">[삭제]</a>
				<a href="boardList.do?pg=${pg }">[목록]</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>