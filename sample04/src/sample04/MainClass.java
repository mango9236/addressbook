package sample04;

public class MainClass {

	public static void main(String[] args) {
		
		short sh;
		sh = 128;
		
		int i;
		
		//자동 형변환
		i = sh;
		System.out.println("i="+i);
		
		//강제 형변환
		i = 1234;
		sh = (short)i;
		
		double d;
		int n;
		n = 1024;
		d = n;
		System.out.println(d);
		
		d = 123.456;
		n = (int)d;
		System.out.println(n);
		
		int num1, num2;
		num1 = 3;
		num2 = 2;
		
		double res = (double)num1 / (double)num2;
		System.out.println(res);
		
		char c='a';
		System.out.println("c= "+c);
		System.out.println("c= "+(int)c); // ascii

	}

}
