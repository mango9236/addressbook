package work7;

import java.util.Scanner;

import cls.Human;
import cls.Pitcher;
import cls.Batter;

public class MainClass {

	public static void main(String[] args) {
		/*
		
		야구팀 구성
		총원수는 5명
		
		부모 클래스 : 번호(number), 이름(name), 키(height)
		자식 클래스  
			투수 : 승 패 방어율
			타자	: 타수 히트수 타율
			
		입력 -> 투수를 등록하시겠습니까?-1 타자를 등록하시겠습니까?-2
			
		>> 1
		>> 번호(number)
		>> 이름(name)	
		>> 키(height)
		>> 승
		>> 패
		>> 방어율
		
		출력
		투수 -> 정보
		투수 -> 정보
		타자 -> 정보 
			:
		*/
		
		Scanner sc = new Scanner(System.in);
		
		// 야구단에 5명 영입
		Human baseballteam[] = new Human[5];
		
		
		for (int i=0; i<5; i++) {
			System.out.print("등록할 포지션 (1)투수 (2)타자를 입력하세요: ");
			int position = sc.nextInt();
			
			// 투수 영입
			if (position == 1) {
				// 투수 정보 : number, name, height, win, lose, defence
				System.out.println("투수를 영입합니다.");
				System.out.print("번호: ");
				int number = sc.nextInt();
				
				System.out.print("이름: ");
				String name = sc.next();
				
				System.out.print("키: ");
				double height = sc.nextDouble();
				
				System.out.print("승: ");
				int win = sc.nextInt();
				
				System.out.print("패: ");
				int lose = sc.nextInt();
				
				System.out.print("방어율: ");
				double defence = sc.nextDouble();
				
				baseballteam[i] = new Pitcher(number, name, height, win, lose, defence);
				
			}
			
			// 타자 영입
			else {
				// 타자 정보: number, name, height, batcount, hit, hitavg
				System.out.println("타자를 영입합니다.");
				System.out.print("번호: ");
				int number = sc.nextInt();
				
				System.out.print("이름: ");
				String name = sc.next();
				
				System.out.print("키: ");
				double height = sc.nextDouble();
				
				System.out.print("타수: ");
				int batcount = sc.nextInt();
				
				System.out.print("안타수: ");
				int hit = sc.nextInt();
				
				System.out.print("타율: ");
				double hitavg = sc.nextDouble();
				
				baseballteam[i] = new Batter(number, name, height, batcount, hit, hitavg);
			}
		}
		
		// 야구선수단 출력
		for(int j = 0; j< baseballteam.length; j++) {
			System.out.println(baseballteam[j].toString());
		}
	}

}
