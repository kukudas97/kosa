package com.service;

import com.model.NewArticleCommand;

/*
 @Service >> 너는 빈 객체로 생성되어야 해
 public class ArticleService
 
 xml파일에 
 <context:component-scan base-package="com.service">
 
 자동으로 빈 객체 생성 >> ArticleService
 */
public class ArticleService {
	public ArticleService() {
		System.out.println("ArticleService 생성자 호출");
	}
	
	public void writeArticle(NewArticleCommand command) {
		//DAO있다고 가정
		//Insert되었다고 가정
		System.out.println("글쓰기 작업 완료 : " + command.toString());
	}
}
