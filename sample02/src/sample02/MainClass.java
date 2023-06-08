package sample02;

public class MainClass {

	public static void main(String[] args) {
		/* 
		 상수 = fixed, 
		 2진수 8진수 10진수 16진수
		 
		 2진수 -> 16진수
		 1010 1100 -> 0xAC
		 
		 16진수 -> 2진수
		 0xE5 -> 1110 0011 
		 
		 변수 = variable
		 */
		 
		 //1. 숫자 
		 //1-1. 정수 
		 byte by;
		 by = -128; // -2^7 ~ 2^7-1
		 
		 short sh;
		 sh = 300;
		 
		 int i;
		 i = 5000;
		 
		 long l;
		 l = 12345123123112312L; // int보다 클 경우 L로 선언해줘야함
		 
		 //1-2. 실수
		 float f;
		 f = 3.14F; // float 자료형 혁시 F로 표시
		 
		 double d;
		 d = 3.14; // double은 안해줘도댐
		 
		 //2. 문자
		 //2-1. 문자
		 char c; // 2 byte
		 c = 'A';  
		 
		 //2-2. 문자열
		 String str; // wrapper class : 
		 str = "hello"; 
		 str = "hi";
		 
		 //3. 논리
		 // true/false
		 boolean b;
		 b = false;
		 b = true;
		 //b = 1; // 자바는 지원하지 않음
		 
		 // 예약어: 변수명 사용 불가
		 // int true;
		 // int short;
		 
		 // 변수명 규칙
		 // 안되는 규칙
		 // int 1abc;
		 // int +a;
		 // int char;
		 // int a b;
		 
		 // 허용 가능
		 int _humanHeight;
		 int human_height;
		 
		 System.out.println("sh = "+ sh);
		 
		 
	}

}
