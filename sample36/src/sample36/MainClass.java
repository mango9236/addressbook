package sample36;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	final : 제약사항 - 변수, 메소드, 클랫스 적용 가능
		 			
		 */
		
		final int max = 1000; // 변수 --> 상수
		// max = 20; -> 오류발생
		
		// 상수는 주로 대문자를 사용
		final int MAX = 100;
		int num = MAX;
	}

}

// final 클래스 -> 더 이상 상속안해.
// 항상 Object는 최상위 클래스 요즘에는 없음
/* final */ class Parent /* extends Object */{
	int number;
	
	// final 메소드 -> 오버라이딩 금지
	// 잘 쓰이지는 않음
	public /* final */ void method() {
		
	}
}

class Child extends Parent{
	
	public void method() { 
		
	}
	
}


