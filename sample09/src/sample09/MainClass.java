package sample09;

public class MainClass {

	public static void main(String[] args) {
		/* wrapper class */
		// 일반 자료형 (int, char, long)을 class로 만들어 놓은 것
		// 일반 자료형 + 앞 글자 대문자
		
		/* 많이 쓰는 wrapper class */
		// int -> Integer
		// double -> Double
		// char[] -> String
		
		/*
		 클래스명 변수 = new 클래스명(); --> 동적할당, 클래스 선언
		 
		 */
		
		int i = 123;
		Integer in = 123;
		System.out.println(in);
		
		Integer obj = new Integer(123);
		System.out.println(obj);
		
		String str_num = "12345";
		// 문자-> 숫자
		int number = Integer.parseInt(str_num);
		System.out.println(number);
		
		// 2진수 문자 -> 10진수 
		str_num = "1010";
		int binary_num = Integer.parseInt(str_num, 2);
		System.out.println(binary_num);
		
		// 숫자 -> 문자열
		Integer int_num = 12345;
		System.out.println(int_num.toString() + 999);
		
		// 문자열 합치기
		String str1 = new String("hello");
		String str2 = "world";
		String str3 = str1 + str2; // str1.concat(str2)
		System.out.println(str3); 
		
		// equals
		// IndexOf
		// lastIndexOf
		// length
		// replace
		// 문자열 자르기 -> 범위 기호
		// 마지막 인덱스 str.length() -1
		// 범위: substring(처음, 끝) 끝을 안주면 default로 끝까지 --> 파이썬 슬라이싱 같은거
		// 기호: token --> String split[] = str.split("")
		// str.trim() 앞뒤공백제거 strip() 존재
		// str.charAt(2) --> 2번째 index 문자  
		// 문자열 (포함)비교 -->  str1.contains(str2) 포함하면 true
		// String 클래스 
		
	}

}
