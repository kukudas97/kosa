package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/*
 클라이언트가 요청을 보냄
 1. 화면 보여주세요(글쓰기, 로그인 등등) : write.do
 2. 처리해주세요(글쓰기 입력 처리, 로그인 처링 등등) : writeOk.do
 
 요청주소가 : write.do >> 화면
 요청주소가 : writeOk.do >> 처리
 
 클라이언트 요청
 1개의 주소를 가지고 판단
 요청주소 하나로(화면, 처리)판단 > 근거 > 전송 방식(get,post)
 >> http://localhost:8090/SpringMVC_Basic03_Annotation
 같은 주소인데
 전송방신
 GET >> 화면 >> view제공
 POST >> 서비스 처리 >> insert, update >> 화면
 */

@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	private ArticleService articleservice;
	
	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}

	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	public String form() {
		//*********spring 함수의 return타입이 String view의 주소를 의미...
		System.out.println("get");
		return "article/newArticleForm";
	}
	/*
	//1. 데이터 받는 가장 전통적인 방식 >> HttpServletRequest request >> 코드량 증가 >> spring은 안좋아함
	//@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public ModelAndView submit(HttpServletRequest request) {
		System.out.println("post");
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId( Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		//NewArticleController 가 service 필요해 
		this.articleservice.writeArticle(article);
		//처리완료
		
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", article);
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
	*/
	/*
	//2. Spring에서 parameter를 DTO객체로 받기
	//2.1 자동화 > 전제조건 > input name=""값이 DTO객체의 member field명과 동일
	@PostMapping
	public ModelAndView submit(NewArticleCommand command) {
		//1. 자동 DTO 객체 생성 NewArticleCommand command = new NewArticleCommand()
		//2. 넘어온 parameter값을 DTO에 setter함수를 사용해서 자동 주입
		//3. NewArticleCommand command 객체 IOC컨테이너 안에 자동 생성 id="newArticleCommand"
		this.articleservice.writeArticle(command);
		
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", command);
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
	*/
	//3.
	@PostMapping
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) {
		/*
		ModelAndView mv = new  ModelAndView();
		mv.addObject("newArticleCommand", command);
		
		는 @ModelAttribute("Articledata")로 대체
		 */
		this.articleservice.writeArticle(command);
		
		/*
		 mv.setViewName("article/newArticleSubmitted");
		 바로 리턴하는 것
		 */
		return "article/newArticleSubmitted";
		//이러면 view까지 자동 forward
	}
}
