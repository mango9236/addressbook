package sample38;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainClass {

	public static void main(String[] args) {
		/*
		 	날짜 + 시간 클래스
		 	Calendar --> 일정관리 
		 	Date 
		 	
		 */
		
		// 1. 캘린더 설정
		// Calendar cal = new GregorianCalendar();
		Calendar cal = Calendar.getInstance(); // 이게 더 편리함
		
		// 2. 오늘 날짜 얻어오기(get)
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 월은 0 ~ 11월 
		int day = cal.get(Calendar.DATE);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		
		// 날짜 출력
		System.out.println(year+"/"+ two(month+1+"")+"/"+day+" "+hour+":"+minute);
		// 다른 방법: String s = Integer.toString(month); --> 숫자를 문자로 바꾸는 함수 (파이썬 형변환처럼) 
		
		
		// 3. 날짜 세팅(set) + 세팅한 것을 얻어오기(get)
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 4 - 1); // 일부러 알아보기 쉽게 4 - 1 (4월)
		cal.set(Calendar.DATE, 28);
		
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH); // 월은 0~11월 
		day = cal.get(Calendar.DATE);
		
		// 세팅된 날짜 출력
		System.out.println(year+"/"+two(month+1+"")+"/"+day);
		
		
		// 4. 오전 or 오후 판별
		// System.out.println(cal.get(Calendar.AM_PM)); --> 오전 = 0, 오후 = 1
		String am_pm = cal.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
		System.out.println(am_pm);
		
		
		// 5. 요일
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekday); // 일, 월.. 토 (1 ~ 7)
		
		
		// 6. 지정한 달의 마지막날(28,29,30,31)
		int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastday);
		
		
	}
	
	// utility 함수
	// 날짜 두자리 표기 -- ex) 1일 --> 01로 표현
	public static String two(String s) {
		return s.length() > 1? s : "0" + s; // 길이가 1보다 크면 그대로, 아니면 0붙혀서
	}

}
