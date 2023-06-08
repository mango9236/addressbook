package sample05;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		// 편의점 프로그램	
		// 거스름돈, 뭘로 걸러줘야할지
		int pay = 0; // 구매가격
		int money = 0; // 소지한 돈
		int change = 0;
		int changes[] = {5000,1000,500,100,50,10};
		
		// input
		Scanner sc = new Scanner(System.in);
		System.out.print("지불할 금액을 입력하세요. ");
		pay = sc.nextInt();
		System.out.print("현재 소지하고 계신 돈을 입력하세요. ");
		money = sc.nextInt();
		
		// 거스름돈
		change = money - pay;
		System.out.println("거스름돈: " + change);
		
		System.out.println("거스름돈 권종은 다음과 같습니다.");
		for (int i=0;i<changes.length;i++) {
			int cnt = change / changes[i];
			change -= (cnt * changes[i]);
			
			System.out.println(changes[i]+"원: "+cnt+"개");
		}
		if (change > 0)
			System.out.println("10원 이하 잔돈: "+ change+"원");
	}

}
