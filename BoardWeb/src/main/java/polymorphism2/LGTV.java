package polymorphism2;

public class LGTV implements TV{
	public LGTV() {
		System.out.println("===> LGTV 생성");
	}
	public void powerOn() {
		System.out.println("LGTV---전원 켠다.");
	}
	public void powerOff() {
		System.out.println("LGTV---전원 끈다.");
	}
	public void soundUp() {
		System.out.println("LGTV---소리 올린다.");
	}
	public void soundDown() {
		System.out.println("LGTV---소리 내린다.");
	}
}
