package sample18;

public class MainClass {

	public static void main(String[] args) {
		// 절차지향적
		String name = "삼성";
		int channel = 23;
		boolean power = true;
		int size = 200;
		info(name, channel, power, size);
		
		String name2 = "LG";
		int channel2 = 24;
		boolean power2 = false;
		int size2 = 300;
		info(name2, channel2, power2, size2);

		// 클래스 --> 객체 생성 (클래스 변수 선언)
		// 인스턴스, 객체(object) --> 여기서는 tv : 얘가 메모리에 올라감
		TV tv = new TV();
		tv.name = "LG";
		tv.channel = 11;
		tv.power = true;
		tv.size = 350;
		tv.info();
		
	}
	// 절차지향적 프로그래밍 함수 --> 변수 일일히 다 넘겨줘야한다.
	static void info(String name, int channel, boolean power, int size) {
		System.out.println(name+" "+channel+" "+power+" "+size);
	}
}

// class 설계
class TV{
	// (클래스 멤버)변수
	String name;
	int channel;
	boolean power;
	int size;
	// (멤버)함수 (메소드)
	void info() {
		System.out.println(name+" "+channel+" "+power+" "+size);
	}
}

/*
 	형식:
	class 클래스명{
		(멤버) 변수들 - 처리에 필요한 변수 -> 접근(외부, 내부)
		(멤버) 메소드(함수) - 처리
	}
	실제로 사용시
	클래스명 변수(instance, 객체) = new 클래스명();
	instance.변수 
	instacne.메소드
	
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
*/




