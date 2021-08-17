<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	margin: 0;
	padding: 0;
	height: 100%;
}

#header{
	width: 100%; height: 10%;
	text-align: center;
	border: 1px solid lightgray;
}

#container{
	width: 100%;
	height: 500px;
}

#nav{
	width: 20%;
	height: 100%;
	background: orange;
	float: left;
}

#section{
	width: 80%;
	height: 100%;
}

#footer{
	width: 100%;
	height: 10%;
	text-align: center;
	border: 1px solid lightgray;
	clear: both;
}

#nav > h3 > a:link{color:black; text-decoration: none;}
#nav > h3 > a:visited{color:black; text-decoration: none;}
#nav > h3 > a:hover{color:green; text-decoration: underline;}
#nav > h3 > a:action{color:black; text-decoration: none;}
</style>
</head>
<body>
	<div id="header">
		<h1>이미지 게시판</h1>
	</div>
	
	<div id="container">
		<div id="nav">
			<h3><a href="../main/index.jsp">** 메인 화면 **</a></h3>
			<c:if test="${memId == null}">
				<a href="../main/index.jsp?req=loginForm">로그인</a><br>
				<a href="../main/index.jsp?req=writeForm">회원가입</a><br>
			</c:if>
			<c:if test="${memId != null }">
				<p>${memId }님 환영합니다.</p>
				<a href="../main/index.jsp?req=boardWriteForm">글쓰기</a><br>
				<a href="../member/logout.jsp">로그아웃</a><br>
				<a href="../main/index.jsp?req=modifyForm">회원정보수정</a><br>
				<a href="../main/index.jsp?req=memberList&pg=1">회원목록</a><br>
			</c:if>
			<a href="../main/index.jsp?req=boardList&pg=1">글목록</a><br>
			<hr>
			<a href="../main/index.jsp?req=imageboardWriteForm">이미지 등록</a><br>
			<a href="../imageboard/imageboardList.jsp?pg=1">이미지 목록</a><br>
		</div>
		<div id="section">
			<c:if test="${param.req == null}">
				<jsp:include page="body.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'imageboardWriteForm' }">
				<jsp:include page="../imageboard/imageboardWriteForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'imageboardWriteResult' }">
				<jsp:include page="../imageboard/imageboardWriteResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'imageboardListResult' }">
				<jsp:include page="../imageboard/imageboardListResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'imageboardViewResult' }">
				<jsp:include page="../imageboard/imageboardViewResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'imageboardDeleteResult' }">
				<jsp:include page="../imageboard/imageboardDeleteResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'imageboardModifyForm' }">
				<jsp:include page="../imageboard/imageboardModifyForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'imageboardModifyResult' }">
				<jsp:include page="../imageboard/imageboardModifyResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'writeForm' }">
				<jsp:include page="../member/writeForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'writeResult' }">
				<jsp:include page="../member/writeResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'loginForm' }">
				<jsp:include page="../member/loginForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'loginResult' }">
				<jsp:include page="../member/loginResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'boardWriteForm' }">
				<jsp:include page="../board/boardWriteForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'boardModifyForm' }">
				<jsp:include page="../board/boardModifyForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'modifyForm' }">
				<jsp:include page="../member/modifyForm.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'modifyResult' }">
				<jsp:include page="../member/modifyResult.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'memberList' }">
				<jsp:include page="../member/memberList.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'boardList' }">
				<jsp:include page="../board/boardList.jsp"/>
			</c:if>
			
			<c:if test="${param.req == 'boardView' }">
				<jsp:include page="../board/boardView.jsp"/>
			</c:if>

		</div>
	</div>
	
	<div id="footer">
		<p>EZEN IT ACADEMY</p>
	</div>
</body>
</html>