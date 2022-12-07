package Spring_DI4;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Program {

   public static void main(String[] args) {
      /*
	   //NewRecordView view = new NewRecordView(100, 50, 40);
      //view.Print();
	   
	   NewRecordView view = new NewRecordView();
	   //놀다가
	   //NewRecord객체가 필요하면
	   NewRecord record = new NewRecord();
	   view.setRecord(record); //의존객체의 주소가 주입(setter를 통해서)
	   
	   view.input();
	   view.Print();
	   */
	   /*
	    (스프링은 자신만의 메모리 공간이 필요해요)
	    1. SpringFramework가 제공하는 컨테이너에 객체 생성(메모리생성 : IOC(제어의 역전) 컨테이너)
	    	ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
	    2. 컨테이너를 만들고 그 메모리에 필요한 객체를 생성하고 조립(주입)...자동소멸
	       	컨테이너가 생성되고 DIConfig.xml read하고 컴파일해요
	    
	    */
	   ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
	   //Spring 필요한 메모리공간을 생성하고 생성된 메모리에 DIConfig.xml read해서 객체 생성하는 코드
	   RecordView view = (RecordView) context.getBean("view");
	   
	   view.input();
	   view.Print();
   }
}