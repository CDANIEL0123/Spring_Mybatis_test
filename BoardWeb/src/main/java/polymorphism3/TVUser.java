package polymorphism3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		//1. 클래스 패스상에 있는 XML을 로딩하여 Spring 컨테이너를 생성한다.
		GenericXmlApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");

		
		//2. 컨테이너로부터 사용할 객체를 획득한다. id가 tv인 객체 줘 xml아
		TV tv =(TV)container.getBean("tv");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		//3. 스프링 컨테이너를 종료한다.
		container.close();
		
	}

}
