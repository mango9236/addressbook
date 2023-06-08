package sample02;

public class ex2 {

	public static void main(String[] args) {
		String name1, name2, name3;
		name1 = "홍길동";
		name2 = "일지매";
		name3 = "장옥정";
		
		int age1, age2, age3;
		age1 = 20;
		age2 = 18;
		age3 = 14;
		
		boolean g1, g2, g3;
		g1 = true;
		g2 = true;
		g3 = false;
		
		String p1, p2, p3;
		p1 = "010-111-2222";
		p2 = "02-123-4567";
		p3 = "02-345-7890";
		
		float h1, h2, h3;
		h1 = 175.12f;
		h2 = 180.01f;
		h3 = 155.78f;
		
		String ad1, ad2, ad3;
		ad1 = "경기도";
		ad2 = "서울";
		ad3 = "부산";
		
		System.out.println("=========================================================");
		System.out.println("\\ name\t age\t man\t phone\t\t height\t address \\");
		System.out.println("=========================================================");
		System.out.printf("\\ %s %d\t %b\t %s\t %.2f\t %s \\\n", name1, age1, g1, p1, h1, ad1);
		System.out.printf("\\ %s %d\t %b\t %s\t %.2f\t %s \\\n", name2, age2, g2, p2, h2, ad2);
		System.out.printf("\\ %s %d\t %b\t %s\t %.2f\t %s \\\n", name3, age3, g3, p3, h3, ad3);
		System.out.println("=========================================================");
	}

}
