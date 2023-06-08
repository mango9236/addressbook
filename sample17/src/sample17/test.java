package sample17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		
		/* 7. 파일 읽기 */
		// FileReader Class: 텍스트 데이터 파일 읽어올때 사용, file3라는 경로에서 불러옴.
		File file = new File("C:\\Users\\교육생38\\Desktop\\최민규\\test2.txt");
		FileReader fr = new FileReader(file); 
		
		
		// 한 문자씩 읽기
		String str = "";
		int c = fr.read(); // 이게 왜 int일까는 그냥 그렇게 정해져있음.
		while( c != -1 ) {	// -1 == 파일의 끝
			//System.out.println((char)c); --> 한 글자씩 출력		
			str += (char)c;
			c = fr.read(); 
		}

		System.out.println("--- 불러온 내용 ---");
		System.out.println(str); // 전체 출력
		System.out.println("--- 불러온 내용 [완료]---");
		
		
		// 한 문장씩 읽기
		// BufferedReader Class의 readLine()으로 문장 단위로 읽어오기
		File file4 = new File("C:\\Users\\교육생38\\Desktop\\최민규\\test3.txt");
		FileReader fr2 = new FileReader(file4); 
		BufferedReader br = new BufferedReader(fr2);		
		String str2 = br.readLine();
		
		System.out.println("--- 불러온 내용2 ---");
		while( str2 != null ) { // 문장이 null이 아닐때까지 읽기
			System.out.println(str2);			
			str2 = br.readLine();
		}
		System.out.println("--- 불러온 내용 [완료]---");
		br.close();
	}

}
