package sample11;

import java.util.Scanner;

public class ex6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하세요: ");
		int num = sc.nextInt();
		
		System.out.println("구구단 "+num+"단 입니다.");
		for (int i = 1; i<=9;i++) {
			System.out.println(num +"*"+ i +"="+ num*i);
		}
	}

}
