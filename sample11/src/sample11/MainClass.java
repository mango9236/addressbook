package sample11;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// 숫자 5개 입력 배열 저장 배열 출력
		// 숫자가 음수면 저장 x
		// while 권장
		
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[5];
		int cnt = 0;
		
		while (cnt < 5) {
			System.out.print("숫자를 입력하세요.");
			int num = sc.nextInt();
			if (num <= 0) {
				System.out.println("범위를 벗어났습니다.");
				continue;
			}
			arr[cnt] = num;
			cnt++;
		}
		
		// 배열 출력
		System.out.print(Arrays.toString(arr));
	}

}
