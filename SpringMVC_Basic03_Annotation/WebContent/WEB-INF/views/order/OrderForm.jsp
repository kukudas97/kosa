<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문화면</title>
</head>
<body>
<!-- 
private List<OrderItem> orderItem;
 -->
	<form method="post">
		상품1<br>
		상품 ID : <input type="text" name="orderItem[0].itemid">
		상품수량 : <input type="text" name="orderItem[0].number">
		상품주의사항 : <input type="text" name="orderItem[0].remark">
		<br>
		상품2<br>
		상품 ID : <input type="text" name="orderItem[1].itemid">
		상품수량 : <input type="text" name="orderItem[1].number">
		상품주의사항 : <input type="text" name="orderItem[1].remark">
		<br>
		상품3<br>
		상품 ID : <input type="text" name="orderItem[2].itemid">
		상품수량 : <input type="text" name="orderItem[2].number">
		상품주의사항 : <input type="text" name="orderItem[2].remark">
		<br>
		<hr>
		<input type="submit" value="전송">
	</form>
</body>
</html>