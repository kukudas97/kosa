package com.model;
/*
 주문서 클래스
 하나의 주문은 여러개의 상품을 가질 수 있다
 
 board : reply
 하나의 게시글은 여러개의 댓글을 가질 수 있다
 
 하나의 은행은 여러개의 계좌를 가질 수 있다
 */

import java.util.List;

public class OrderCommand {
	private List<OrderItem> orderItem;
	
	public List<OrderItem> getOrderItem(){
		return this.orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
}
/*
주문발생
OrderCommand command = new OrderCommand();

List<OrderItem> itemlist = new ArrayList<OrderItem>();
itemlist.add(new OrderItem(1,10,"파손주의"))
itemlist.add(new OrderItem(10,1,"리모콘은 별도 구매"))

command.setOrderItem(itemlist); < 주문한 물건들이 들어가야함
*/