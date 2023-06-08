package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dto.StudentDto;

public class MainClass {
	public static void main(String[] args) {
		/*
		  	ArrayList : index number로 관리된다. (0 ~ n-1)
		  				선형구조
		  				검색에 적합.
		  				배열처럼 사용하는 리스트
		*/
		
		
		// Integer 타입 List 생성 
		List<Integer> list = new ArrayList<Integer>();
		// List<Integer> list = new ArrayList<>(); --> jdk1.7이상 생략가능
		// ArrayList<Integer> arrlist = new ArrayList<>();
		
		/* CRUD */
		// 1. 추가
		list.add(111);		
		
		list.add(new Integer(222)); // java5 이후로 auto-boxing으로 원시 타입-래퍼 클래스간 자동변환
		Integer in = new Integer(333);
		list.add(in);
		
		// 1-1. 원하는 위치에 추가
		Integer num = new Integer(300);
		list.add(2, num); // 2번 idx에 num 추가
				
		for(int i = 0;i < list.size(); i++) {
			Integer val = list.get(i);
			System.out.println(i + ":" + val);
		}

		
		// 2. 길이 size(== length)
		int len = list.size();
		System.out.println("리스트의 크기:" + len);
		
		// 2-1. (하나의)데이터를 목록에서 산출
		Integer value = list.get(0);  // 0번 idx 값 get 
		System.out.println(value);
		
		// 2-2. (모든)데이터를 산출
		for(int i = 0;i < list.size(); i++) {
			Integer val = list.get(i);
			System.out.println(i + ":" + val);
		}
		
		// 2-3. 향상된 for문 (for each) --> list를 돌면서 val로 return
		for(Integer val : list) {
			System.out.println(val);
		}
		
		// 3. 삭제	
		list.remove(1);
		
		for(int i = 0;i < list.size(); i++) {
			Integer val = list.get(i);
			System.out.println(i + ":" + val);
		}
		
		
		// 4. 검색
		int index = -1;
		int findNum = 333;
		
		for (int i = 0; i < list.size(); i++) { // 순회하면서 값을 얻음
			int n = list.get(i); // get(i)			
			if(findNum == n) {
				index = i;				
				break;
			}
		}
		if(index != -1) { // 만약 인덱스가 -1 아니면 찾았다는 것
			System.out.println(list.get(index));
		}
		
				
		// 5. 수정
		Integer updateDate = new Integer(555);
		list.set(1, updateDate); // set으로 값 업데이트
		
		for(int i = 0;i < list.size(); i++) {
			Integer val = list.get(i);
			System.out.println(i + ":" + val);
		}
		
		
		
		/* ArrayList */
		// 1. 추가 - 여러가지 방법 3가지
		List<String> strList = new ArrayList<String>();
		
		strList.add("giants");
		
		strList.add(new String("tigers"));
		
		String str = new String("twins");
		strList.add(str);
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(i + ":" + strList.get(i));
		}
		
		// 1-1. 원하는 위치에 추가
		String addObj = "eagles";
		strList.add(1, addObj);
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(i + ":" + strList.get(i));
		}
		
		// 2. 삭제
		strList.remove(2);
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(i + ":" + strList.get(i));
		}
		
		// 3. 검색
		int index1 = -1;
		for (int i = 0; i < strList.size(); i++) {
			String team = strList.get(i);
			if(team.equals("giants")) {
				index1 = i;
				break;
			}
		}
		System.out.println(strList.get(index1));
		
		// 4. 수정
		String newteam = "landers";
		strList.set(1, newteam);
		
		for (int i = 0; i < strList.size(); i++) {
			System.out.println(i + ":" + strList.get(i));
		}
		
		
		/* Object Dao */	
		List<StudentDto> studentBook = new ArrayList<StudentDto>();
		
		// 추가 - 4가지 방법
		
		// #1. 바로 add
		studentBook.add(new StudentDto(1, "홍길동", 172.1));
		
		// #2. 생성하고 add
		StudentDto dto = new StudentDto(2, "성춘향", 161.2);
		studentBook.add(dto);
		
		// #3. set으로 넣고 add
		dto = new StudentDto();
		dto.setNo(3);
		dto.setName("홍두께");
		dto.setHeight(181.2);
		studentBook.add(dto);
		
		// #4. idx 지정
		studentBook.add(1, new StudentDto(4, "일지매", 185.8));
				
		// 삭제
		studentBook.remove(1);
		
		// 검색 (이름, 키)
		String findStudent = "성춘향";
		for (int i = 0; i < studentBook.size(); i++) {
			StudentDto st = studentBook.get(i);
			if(findStudent.equals( st.getName() )) {
				System.out.println("[일치] "+studentBook.get(i).toString());
			}			
		}
		
		for (int i = 0; i < studentBook.size(); i++) {
			StudentDto st = studentBook.get(i);
			if(st.getHeight() >= 170.0) {
				System.out.println("170이 넘어요. "+studentBook.get(i).toString());
			}
		}
		
		// 수정
		studentBook.set(2, new StudentDto(4, "심청", 156.4)); 
		
		for (StudentDto st : studentBook) { // 모든 학생들 print
			System.out.println(st.toString());
		}
		
		// 다양한 타입의 객체들을 리스트에 담을 수 있다.
		List<Object> objList = new ArrayList<Object>();
		objList.add(new StudentDto(1100, "김용필", 180.2));
		objList.add(new String("Hello World"));
		objList.add(1024);
		objList.add(studentBook);		
		System.out.println(objList);
		
	}
}
