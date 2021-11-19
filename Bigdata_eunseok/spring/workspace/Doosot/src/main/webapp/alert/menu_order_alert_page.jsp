<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>두솥 주문하기</title>
<script type="text/javascript">
	if(${order_page_check} == "0"){
		window.location.href="../order/menu_order_page.jsp?mem_name=${mem_name}&mem_addr=${mem_addr}";
	}else{
		alert("죄송합니다. 페이지 불러오기에 실패했습니다. 잠시 후 다시 시도해주세요.");
		window.location.href="../main/main.jsp";
	}
</script>
</head>
</html>