package DI_03_Spring;

public class MessageBean_en implements MessageBean {

	@Override
	public void sayHello(String name) {
		System.out.println("안녕" + name + "!");

	}

}
