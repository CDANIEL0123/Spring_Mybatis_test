package polymorphism3;

import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {

	public static void main(String[] args) {
		// 1. 클래스 패스상에 있는 XML을 로딩하여 Spring 컨테이너를 생성한다.
		GenericXmlApplicationContext container = 
			new GenericXmlApplicationContext("applcationContext.xml");
		
		// 2. 컨테이너로부터 사용할 객체를 획득한다.
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		Properties collection = bean.getAddressList();
		
		System.out.println("[ 주소 목록 ]");
		for (Object address : collection.values()) {
			System.out.println("---> " + address.toString());
		}
		
		System.out.println("[ 회원 목록 ]");
		for (Object name : collection.keySet()) {
			System.out.println("---> " + name.toString());
		}

		
		// 3. Spring 컨테이너를 종료한다.
		container.close();
	}

}
