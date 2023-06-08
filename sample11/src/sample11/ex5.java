package sample11;

public class ex5 {

	public static void main(String[] args) {
		for (int i=1; i<=9; i++) {
			System.out.println(i+"단");
			for (int j=1; j<=9; j++) {
				System.out.println(i+"*"+j+"="+i*j);
			}
			System.out.println(i+"단 끝입니다.");
		}
	}

}
