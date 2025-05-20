package polymorphism3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv")
public class LGTV implements TV{
	
	//type injection
	//1. Speaker타입의 객체가 반드시 메모리에 있어야 한다.
	//2. 메모리에 있어야하는데 Speaker타입의 객체는 유일해야 한다.
	@Autowired
	private Speaker speaker;
	
	public LGTV() {
		System.out.println("===> LGTV 생성");
	}
	public void powerOn() {
		System.out.println("LGTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("LGTV---전원 끈다.");
	}
	public void volumeUp() {
		System.out.println("LGTV---소리 올린다.");
		speaker.volumeUp();
	}
	public void volumeDown() {
		System.out.println("LGTV---소리 내린다.");
		speaker.volumeDown();
	}
}
