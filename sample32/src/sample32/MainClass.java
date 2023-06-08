package sample32;

public class MainClass {

	public static void main(String[] args) {
		/* 
		 	캡슐화: 접근 지정자를 통해서 외부로부터 접근을 제한
		 	private(개인적) - 클래스 내부만 접근을 허용 - variable
		 	public(대중적) - 어디서나 접근 허용 - method
		 	
		 	상속성: 확장
		 	
		 	다형성: 상속후에 여러가지 형태로 자식 클래스가 구현되는 것
		 	
		 	this: 자기자신, super: 부모
		 	
		 	Override: 관리(자식 클래스)의 목적
		 	
		 	Overload: 함수명은 같고 매개변수가 다른 것
		 	
		 	형식: 
		 		class 부모클래스{
		 			변수
		 			메소드
		 		}
		 		
		 		class 자식클래스 extends 부모클래스{
		 			(부모 변수 메소드 상속)
		 		}
		 		
		 */
		
		//Parent pa = new Parent();
		//pa.pMethod();
		
		Child ch = new Child(); 
		ch.pMethod(); // 부모클래스 상속 
		ch.Process(); // 오버라이딩된 메소드를 호출
		
		// Override - 상속받은 함수를 고쳐기입
		Parent pcls = new Child();
		pcls.Process(); // 자식이 호출
		
		Child c1 = (Child)pcls; // 클래스를 바꿔줌 Child로, 생성x
		c1.func();
		c1.height = 174.4;
	}

}

class Parent{
	int number;
	String name;
	
	public void pMethod() {
		System.out.println("부모의 메소드");
	}
	public void Process() {
		System.out.println("부모 프로세스");
	}
}

class Child extends Parent{
	int age;
	double height;
	
	public void func(){
		number = 12;
		name = "홍길동";
		age = 24;
		height = 174.5;
	}
	
	public void Process() {
		System.out.println("자식 프로세스");
	}
}