<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품목록(EL & JSTL사용 출력)</h3>
	${orderCommand}
	<hr>
	
	<c:forEach var="order" items="${orderCommand.orderItem}">
		상품명 : ${order.itemid}<br>
		상품수량 : ${order.number}<br>
		주의사항 : ${order.remark}<br>
		<hr>
	</c:forEach>
	
	<c:forEach var="order" items="${orderCommand.orderItem}">
		<li>
			${order.itemid}-${order.number}-${order.remark }
		</li>
	</c:forEach>
	
</body>
</html>