<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
textarea{
	background: skyblue;
	border: 2px solid black;
	width: 300px; height: 200px;
}
input{
	width:255px;
}
</style>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		// key 이벤트 사용
		$("#query").keydown(function(e){
			if(e.which == 13){
				var text = $("#output").val();
				var query = $("#query").val();
				$("#output").html(text + query + "\n");
				$("#query").val("");
				
				// ajax 통신 처리
				$.ajax({
					url: "chat_json.jsp",
					type: "post",
					data: {"query": query},
					dataType: "json",
					timeout: 30000,
					success: function(json){
						$("#output").append(json.Answer + "\n\n");
						var top = $("#output").prop("scrollHeight");
						$("#output").scrollTop(top);
					},
					error: function(xhr, textStatus, errorThrown){
						$("#output").html("접속실패, " + xhr.status + "\n" + textStatus + "\n"
								+ errorThrown + "\n");
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<div>
		<textarea id="output" readonly="readonly"></textarea><br>
		<label>주문 : </label>
		<input type="text" name="query" id="query" size="36">
	</div>
</body>
</html>