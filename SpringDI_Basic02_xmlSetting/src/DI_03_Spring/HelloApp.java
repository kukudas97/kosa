package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		//영문
		/*
		 * MessageBean_en messagebean_en = new MessageBean_en();
		 * messagebean_en.sayHello("hong");
		 * 
		 * 
		 * //한글 MessageBean_kr messagebean_kr = new MessageBean_kr();
		 * messagebean_kr.sayHello("hong");
		 */
		
		/*
		 * //인터페이스 사용 (다형성) MessageBean messageBean = new MessageBean_kr(); //new
		 * MessageBean_en(); messageBean.sayHello("hong");
		 */
		
		//Spring 통해서 객체를 생성하고 조립하는 작업
		//1. 컨테이너 생성(메모리)
		//2. 컨테이너 안에서 생성될 객체 만들고 주업하는 작업(xml) >> DI_03.xml
		
		//new ClassPathXmlApplicationcontext("DIConfig.xml");
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		
			 	MessageBean message = context.getBean("mesagebean", MessageBean.class);	
			 	message.sayHello("hong");
	}

}
