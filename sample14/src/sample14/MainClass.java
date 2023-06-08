package sample14;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		// 함수 1
		System.out.println("거리는 "+ get_distance(1,2,2,3));
		
		// 함수 2
		int arr[] = {1,2,3,4,5,6,7,8,9};
		shuffle(arr);
		System.out.println("셔플 후 배열: "+Arrays.toString(arr)); // 자바 배열 출력
		
		// 함수 3
		System.out.println("배열의 최대값은 "+max_num(arr)+"입니다.");
		
		// 함수 4
		String str ="123abc";
		System.out.println(str+"은 모두 숫자입니까? "+is_number(str));
		String str2 ="123456";
		System.out.println(str2+"은 모두 숫자입니까? "+is_number(str2));
		
		// 함수 5
		int arr2[] = {1,10,30,4,5};
		System.out.println(Arrays.toString(twice(arr2)));
		
		// 함수 6
		int n1 = 23;
		int n2 = 0;
		divide(n1,n2);
		
	}
	
	// 1. 거리 구하기
	static double get_distance(int x1,int y1,int x2,int y2){
		int dx = Math.abs(x2-x1);
		int dy = Math.abs(y2-y1);
		
		double d = Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
		return d;
	}

	// 2. 배열 셔플
	static int[] shuffle(int[] arr) {
		
		for (int i=0;i<arr.length;i++) {
			int num1 = (int)(Math.random()*arr.length); // 0~n-1번 인덱스
			int num2 = (int)(Math.random()*arr.length);
					
			// swap
			int tmp = arr[num1];
			arr[num1] = arr[num2];
			arr[num2] = tmp;
		}
		
		return null; // 자바에서는 null로
	}
	
	// 3. 최대값 구하기
	static int max_num(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -99999;
		}
		else {
			int max = arr[0];
			for (int i = 0;i<arr.length;i++) {
				 if (max < arr[i]) {
					 max = arr[i];
				 }
			}
			return max;
		}
	}
	
	// 4. isNum = 문자열이 모두 숫자인지 검사
	static boolean is_number(String str) {
		if (str == null || str.length() == 0) { // 객체가 비었음 = null
			return false;
		}
		
		boolean check = true;
		for (int i=0;i<str.length();i++) {
			char check_num = str.charAt(i); // str에서 i번째 idx 글자
			int ascii = (int)check_num; // 0~9 --> 아스키 48~57
			
			if (48 <= ascii && ascii <= 57) {
				continue;
			}
			
			else {
				check = false;
				break;
			}
		}
		return check;
	}
	
	// 5. 배열 값에 2배 연산하기
	static int[] twice(int[] arr) {
		for(int i =0;i<arr.length;i++) {
			arr[i] *= 2;
		}
		
		return arr;
	}
	
	// 6. 두 수 몫, 나머지 연산하기
	static void divide(int n1, int n2) {
		
		// 0으로 나누면 안됨.
		if (n2 == 0) {
			System.out.println("Division Erorr: divide by zero");
		}
		
		int Q = (int) n1 / n2; 
		int R = n1 % n2;
		
		System.out.println("몫: "+Q);
		System.out.println("나머지: "+R);
	}
}
