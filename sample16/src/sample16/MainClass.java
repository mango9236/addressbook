package sample16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {
	public static void main(String[] args) throws IOException {
		/*
			source code(logic) -> file, database(기능) 
			저장매체 : file, database
			목적 : 데이터를 저장, 불러오기
			
			.txt
			jpg		png	 	gif		tiff	tga		bmp(bitmap) 
			jpeg
			용량이 작아서 -> 가볍다			
		*/
		
		/* 1. 파일 목록 출력 */
		File fileDir = new File("C:\\"); // File 클래스 생성
		
		String fileList[] = fileDir.list(); // .list(): 경로에 있는 파일 이름들 return
		for (int i = 0; i < fileList.length; i++) {
			System.out.println(fileList[i]);
		}
		
		
		/* 2. 파일, 폴더, 그외의 것들 */
		File fileList2[] = fileDir.listFiles(); // .listFiles(): 경로에 있는 파일들 배열로 리턴
		for (int i = 0; i < fileList2.length; i++) {
			// isFile(): 파일인지 T/F
			if(fileList2[i].isFile()) { 
				System.out.println("[파일]" + fileList2[i].getName()); // getName(): 파일 이름 가져오기
			}
			
			// isDirectory(): 폴더인지 T/F
			else if(fileList2[i].isDirectory()) {
				System.out.println("[폴더]" + fileList2[i].getName());
			}
			
			// 그외의 것들
			else {
				System.out.println("[?]" + fileList2[i].getName());
			}
		}
		
		
		
		/* 3. 파일 생성 */
		String filename = "C:\\Users\\교육생38\\Desktop\\최민규\\newfile.txt"; // 디렉토리 지정
		File newfile = new File(filename);
				
		try {
			if(newfile.createNewFile()) { // createNewFile(): 파일 생성
				System.out.println("파일 생성 성공!");
			}
			
			else {
				System.out.println("파일 생성 실패");
			}
		} 
		
		catch (IOException e) {	// 지정된 디렉토리가 없을때		
			e.printStackTrace();
		}
		
		
		/* 4. 파일의 존재여부 확인 */
		File file = new File("C:\\Users\\교육생38\\Desktop\\최민규\\newfile.txt");
		// exists(): 파일이 존재하는지 확인
		if(file.exists()) { 
			System.out.println("파일이 존재합니다.");
		}
		else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
		/* 5. 읽고 쓰기 가능 여부 */
		// canRead(): 읽을 수 있는지
		if(file.canRead()) {
			System.out.println("파일을 읽을 수 있습니다.");
		}
		
		// setReadOnly(): 읽기 전용으로 변경
		file.setReadOnly();
		
		// canWrite(): 파일 쓰기를 할 수 있는지
		if(file.canWrite()) {
			System.out.println("파일 쓰기를 할 수 있습니다.");
		}
		else {
			System.out.println("파일 읽기 전용입니다.");
		}
		
		
		
		/* 6. 파일 쓰기 */
		File file2 = new File("C:\\Users\\교육생38\\Desktop\\최민규\\test.txt");
		
		// 새로 쓰기 - 한 문장씩 쓰기
		// FileWriter Class: 텍스트 데이터 파일 저장시 사용, file2라는 경로에 쓸것임.
		FileWriter fw = new FileWriter(file2); 
		fw.write("fw.write는 개행이 안됩니다. \n"); // write는 개행 x, 한 문자씩 써집니다.
		fw.write("fw.write는 하나씩 저장됩니다. \n"); // 새로쓰는 것임. 덮어쓰기 x
		fw.close();
		System.out.println("파일이 새로 작성. [저장완료]");
		
		
		// 추가로 쓰기
		FileWriter appendFw = new FileWriter(file2, true); // true값을 주면 추가로 append할수있다.
		appendFw.write("true를 추가하면 기존 파일에 덧붙이기 가능." + "\n");
		appendFw.close();
		System.out.println("파일에 추가로 append. [저장완료]");
		
		
		
		// 문장으로 기입
		// 작성해보니 기존에 것은 삭제됨.
		FileWriter fw2 = new FileWriter(file2); // 위에 fw 있어서 fw2라고 명명함.
		BufferedWriter bw = new BufferedWriter(fw2);
		PrintWriter pw = new PrintWriter(bw); 
		
		pw.print("안녕" + "\n"); // 개행 x
		pw.println("하이하이"); // 개행 o
		pw.println("건강하세요");
		
		pw.close();
		System.out.println("파일에 문장을 추가. [저장완료]");
		
		
		
		/* 7. 파일 읽기 */
		// FileReader Class: 텍스트 데이터 파일 읽어올때 사용, file3라는 경로에서 불러옴.
		File file3 = new File("C:\\Users\\교육생38\\Desktop\\최민규\\test2.txt");
		FileReader fr = new FileReader(file3); 
		
		
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








