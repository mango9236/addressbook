package main;

public class MyClass extends AbstractClass{ // override 안하면 오류

	// Source -> override
	// 추상클래스 반드시 해주기
	@Override 
	public void abstractMethod() {
		System.out.println("My class abstractMethod()");
	}
	
}
