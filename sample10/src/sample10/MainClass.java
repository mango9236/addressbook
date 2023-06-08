package sample10;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// 문자열 비교시 == 연산 말고, equals()로 무조건 비교
		
		int num = 23;
		
		if (num % 2 == 0) {
			System.out.println("짝수입니다.");
		}
		else {
			System.out.println("홀수입니다.");
		}
		
		// 최대값 산출
		int arr_num[] = {34,-2,7,15};
		int max_arr = arr_num[0];
		for (int i = 0;i < arr_num.length;i++) {
			if (max_arr < arr_num[i]) {
				max_arr = arr_num[i];
			}
		}
		System.out.println(max_arr);
		
		// while문 배열 10개 넣고 최대값 산출
		int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("숫자를 입력하세요: ");
            arr[i] = sc.nextInt();
        }
        
        int max_value = arr[0]; 
        for (int i = 1; i < 10; i++) {
            if (arr[i] > max_value) {
            	max_value = arr[i];
            }
        }

        System.out.println("최대값: " + max_value);
		}
		
	}


