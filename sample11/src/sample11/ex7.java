package sample11;

public class ex7 {

	public static void main(String[] args) {
		int even = 0;
		int odd = 0;
		
		for (int i=1;i<=100;i++) {
			if (i % 2 ==0) {
				even += i;
			}
			else {
				odd += i;
			}
		}
		System.out.println("짝수의 합은 "+even+"입니다.");
		System.out.println("홀수의 합은 "+odd+"입니다.");
	}
}
