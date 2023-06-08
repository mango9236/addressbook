package sample12;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		 int random_number = (int) (Math.random() * 100) + 1;
	     int guess = 0;
	     int cnt = 0;
	     boolean check = false;
	     
	     Scanner sc = new Scanner(System.in);
	     System.out.println("1~100 사이의 숫자 업다운 게임");

	     while (cnt < 10) {
	         System.out.print("숫자를 입력하세요: ");
	         guess = sc.nextInt();
	         

	         if (guess < random_number) {
	             System.out.println("숫자가 더 커야합니다.");
	         } 
	         else if (guess > random_number) {
	             System.out.println("숫자가 더 작아야합니다.");
	            } 
	         else {
	             System.out.println("정답!");
	             System.out.println(cnt+"회만에 성공하셨습니다.");
	             check = true;
	             break;
	            }
	         cnt++;
	        }
	     
	     if (check == false)
	    	 System.out.println("정답을 맞추지 못하셨습니다.");
	}

}
