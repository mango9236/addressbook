package sample37;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		/*  
			#1. static이란
	
		 	static: 정적 != 동적, 메모리의 공간을 기준으로 
		 	int arr[] = new int[5];  -> 00000
		 	
		 	stack: 지역변수, 매개변수
		 	heap: 동적으로 할당된 영역(배열, 클래스)
		 	static: 전역변수, 메모리 공간 무조건 확보, 꺼지면 없어짐
		 	
		*/
		
		// mycls: 매개변수(인스턴스) --> stack 
		// new Myclass(): 동적할당 --> heap
		Myclass mycls = new Myclass();
		mycls.method(100);
		
		
		/*  
			#2. 전역 vs 지역변수
		 	mycls.num = 10; // 인스턴스 할당후 사용가능 
		 	Myclass.global_num = 10; // 호출시 클래스.전역변수, 그냥 바로 사용가능
		*/
		
		Myclass cls2 = new Myclass();
		cls2.method(1);
		cls2.method(1);
		
		Myclass cls3 = new Myclass();
		cls3.method(2); // 전역은 계속 유지되어 옴 
		
		Myclass.global_num++;
		System.out.println("전역변수: "+ Myclass.global_num); 
		
		Myclass.static_method(); // 바로 호출가능 ex) Arrays.toString(null); --> 이런게 전부 static 함수
		
		
		YouClass ycls = YouClass.getInstance(); // 한꺼번에 처리할때 이렇게 씁니다.
	}

}


class YouClass{
	
	public YouClass() { // 생성자
		System.out.println("YouClass YouClass()");
	}
	
	// static 쓰임새 -> [실무] 여러처리를 한꺼번에 해줄때 유용 
	public static YouClass getInstance() {
		System.out.println("YouClass getInstance()");
		
		YouClass yc = new YouClass();
		yc.process();
		return yc;
	}
	
	public void process(){
		System.out.println("YouClass process()");
	}
}




class Myclass{
	public int num; // (클래스) 멤버변수(자동 초기화 = 0)
	
	static int global_num; // static --> 전역변수, 정적변수(자동 초기화 = 0)
	
	public void method(int num) { // --> 매개변수(지역)
		int cnt; // 지역(local)변수
		
		global_num++;
		System.out.println("전역변수: "+ global_num);
	}
	
	// 정적함수 --> 언제 어디서나 호출 가능
	// 할당없이 바로 사용. 
	public static void static_method() {
		System.out.println("Myclass의 정적 메소드(static Method)");
		
		// this.cnt = cnt; --> this 사용불가 
		// num = 5; 멤버변수 접근 불가
		// method(10); 멤버메소드 접근 불가
		global_num = 30; // static 변수(global)는 사용가능
	}
}





