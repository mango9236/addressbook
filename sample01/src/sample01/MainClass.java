package sample01;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("hello world 1"); // 콘솔창 
		
		/* 
		범위 주석문 
		System.out.println("hello world 2");
		System.out.println("hello world 3");
		System.out.println("hello world 4"); 
		*/
		
		System.out.print("abc"); // 개행 x, \n : 개행 추가 가능
		System.out.println("abc"); // 개행 o
		
		// 이스케이프 문자열
		// \n 개행, \b 지우기, \' or \" 따옴표, \t tab키
		System.out.println("\'안녕하세요\'");
		System.out.println("\\안녕하세요\\");
		System.out.println("\t 안녕 \t 하세용");
		
		// 값을 표현 출력
		System.out.printf("%s", "world"); // format, 개행 x
		System.out.printf("%s %c %d", "hello", 'c', 1234); // char형은 ''으로 string ""
		
		
		
		
	}
}
