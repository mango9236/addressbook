package sample03;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception{
		// 1. 입력
		Scanner sc = new Scanner(System.in);
		
		// boolean
		boolean b;
		System.out.print("b = ");
		b = sc.nextBoolean();
		System.out.println("num = "+ b);
		
		// integer
		int num;
		System.out.print("num = ");
		num = sc.nextInt();
		System.out.println("num = "+ num);
		
		// double
		double d_num;
		System.out.print("d_num = ");
		d_num = sc.nextDouble();
		System.out.println("d_num = "+ d_num);
		
		// string
		String str;
		System.out.print("str = ");
		str = sc.next();
		//str = sc.nextLine(); 
		System.out.println("d_num = "+ str);
//		
		// 2. buffer(저장공간)
		// 문장 입력시
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String name = br.readLine();
			
			System.out.print("name: ");
			
		}
	
	}
