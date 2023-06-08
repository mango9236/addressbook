package sample11;

import java.util.Scanner;

public class ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int a = num / 10;
		int lower = a*10;
		int upper = (a+1)*10;
		
		// 100만 제외 
		if (num == 100) {
			System.out.println("입력한 수는 100입니다.");
		}
		
		else{
			System.out.println("입력한 수는 " + lower+"보다 크거나 같고 "+upper+"보다 작거나 같다.");
		}
	}
}
