package sample11;

import java.util.Scanner;

public class ex8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("10진수 -> 2진수: 10이라고 입력하십시오.");
		System.out.println("2진수 -> 10진수: 2라고 입력하십시오.");
		int choice = sc.nextInt();
		
		// DEX일 경우
		if (choice == 10) {
			System.out.print("10진수 숫자를 입력하세요.");
			int dec = sc.nextInt();
			String dec_to_bi = Integer.toBinaryString(dec);
			System.out.print("변환된 2진수: "+ dec_to_bi);
		}
		
		// BIN일 경우
		if (choice == 2){
			System.out.print("2진수 숫자를 입력하세요.");
			String bi = sc.next();
			int bi_to_dec = Integer.parseInt(bi,2); // 2진수 -> 10진수
			// int hex_to_dec = Integer.parseInt(bi,16); // 16진수 -> 10진수
			System.out.print("변환된 10진수: "+ bi_to_dec);
		}
	}

}
