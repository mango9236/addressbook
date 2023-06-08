package main;

public abstract class AbstractClass {
	
	// 멤버 변수
	private int number;
	
	// (일반) 멤버 메소드 
	public void method() {
		System.out.println("AbstractClass method()");
	}
	
	// 추상 메소드
	public abstract void abstractMethod();
}
