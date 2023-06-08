package sample19;

public class MainClass {

	public static void main(String[] args) {
		
		// stack heap static sys --> 변수는 stack으로 올라감 (블록내만)
		// new -> heap
		class1 c1 = new class1(); // heap에 생성한것을 참조해서 사용
		c1.method();
		
		
	}
		

}

class class1{
	int num;
	String name;
	
	void method() {
		System.out.println("class1 Method");
	}
}