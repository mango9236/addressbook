package sample20;

import java.util.Scanner;

public class Calculator {
	int num1, num2;
	String op;
	int result;
	
	// 입력
	void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("num1 = ");
		num1 = sc.nextInt();
		
		System.out.print("(+,-,*,/)중에 입력하시오 = ");
		op = sc.next();
		
		System.out.print("num2 = ");
		num2 = sc.nextInt();
	}
	
	// 연산 처리
	void process() {
		switch(op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;
		}
	}
	
	// 결과 출력
	void print() {
		System.out.println(num1 +" "+ op +" "+ num2 +" = "+ result);
	}
	
	// 입력 + 연산 + 출력 --> 모든 과정 수행
	void procedure() {
		input();
		process();
		print();
	}
}
