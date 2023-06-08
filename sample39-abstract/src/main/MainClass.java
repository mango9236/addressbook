package main;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	abstract class : 일반 메소드 + 추상메소드 + 멤버 변수
		 */
		
		/* AbstractClass ac = new AbstractClass() { // 그냥 추상클래스만 생성 불가 
			
			@Override
			public void abstractMethod() {
				
			}
		};*/
		
		// 1. 자식 클래스로 생성하는 방법.
		MyClass mycls = new MyClass();
		mycls.method();
		mycls.abstractMethod();
		
		// 2. 부모클래스의 인스턴스로 생성하는 방법.
		// 부모클래스명 인스턴스 = new 자식클래스명();
		AbstractClass ac = new MyClass();
		ac.method();
		ac.abstractMethod();
		
		// 3. 생성과 함께 추상메소드를 정의하는 방법.
		AbstractClass ac2 = new AbstractClass() {
			
			@Override
			public void abstractMethod() {
				System.out.println("ac2의 추상메소드");
			}
		};
		ac2.method();
		ac2.abstractMethod();
	}

}
