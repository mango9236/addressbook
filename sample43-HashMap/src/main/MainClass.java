package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {

	public static void main(String[] args) {
		/* LinkedList(링크리스트) */
		List<String> list = new LinkedList<String>();
		
		list.add(new String("giants"));
		list.add(new String("tigers"));
		list.add(new String("twins"));
		list.add("이렇게도 넣어짐");
		
		list.remove(1); // 지우기
		
		String team = new String("bears");
		list.set(1, team); // set
		
		// 모든 값 순회
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		// 링크리스트 -> 배열리스트: 서로 호환이 됩니다.
		List<String> arrlist = new ArrayList<String>(list);  
		for (String s: arrlist) {
			System.out.println(s);
		}
		
		/* HashMap */
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		// 부모 인스턴스로 자식클래스 생성 (Map interface -> HashMap)
		Map<Integer, String> hashMap2 = new HashMap<Integer, String>();
		
		// 1. 추가
		hashMap.put(25, "최민규");
		hashMap.put(27, "김현민");
		hashMap.put(26, "최영석");
		
		// 1-1. 값 얻기 (key -> value 얻기)
		String value = hashMap.get(25);
		System.out.println(value);
		
		// 2. 삭제
		// hashMap.remove(26); --> 그냥 삭제해도됨.
		value = hashMap.remove(26); // 어떤 값이 삭제되는지 확인하기 위해
		System.out.println("삭제되는 값: " + value);
		
		
		// 3. 검색
		
		// key가 있는지 없는지 확인 --> 기존 데이터가 날라갈 수 있으므로 먼저 검사하는게 좋음
		//boolean b = hashMap.containsKey(new Integer(25));
		boolean b = hashMap.containsKey(25); 
		System.out.println(b);
		
		if (b == true) {
			String v = hashMap.get(25);
			System.out.println("value: "+ v);
		}
		
		// 4. 수정
		hashMap.replace(25, "정규도"); // value값 수정
		hashMap.put(25, "김민석"); // 중복값이 있을경우 덮어쓰므로 key 먼저 확인하는게 좋음
		
		// 5. 값을 모두 출력
		// iterator : 반복자(주소) -> key값
		Iterator<Integer> iter = hashMap.keySet().iterator(); // 처음 주소로 keySet()
		while(iter.hasNext()) { // hasNext(): 다음것을 가지고 있는지 -> boolean
			
			Integer key = iter.next(); // 다음 iterator 지정
			System.out.print("key: " + key); 
			
			String val = hashMap.get(key);  
			System.out.println(" value: "+ val);
		}
		
		Map<String, String> hMap = new HashMap<String, String>();
		// 과일명 4개추가
		hMap.put("apple","사과");
		hMap.put("banana","바나나");
		hMap.put("kiwi","키위");
		hMap.put("grape","포도");
		
		// 모두 출력
		Iterator<String> it_string = hMap.keySet().iterator();
		while(it_string.hasNext()) {
			String k = it_string.next();
			String v = hMap.get(k);
			System.out.println("키: "+ k +" 값: "+ v); // 순서가 없다. 딕셔너리처럼
			 
		}
		
		// HashMap --> TreeMap
		TreeMap<String, String> tMap = new TreeMap<String, String>(hMap);
		
		// TreeMap은 sorting가능
		
		// 오름차순
		// Iterator<String> it_tree = tMap.keySet().iterator();
		
		// 내림차순
		Iterator<String> it_tree = tMap.descendingKeySet().iterator();
		
		while(it_tree.hasNext()) {
			String k = it_tree.next();
			String v = tMap.get(k);
			System.out.println("key: "+ k +" value: "+ v);
		}
		
		// Map활용 --> string, integer, object
		// 제일 많이 쓰는 Map<String, Object> 
		Map<String, Object> userMap = new HashMap<String, Object>();
		List<String> list1 = new ArrayList<String>();
		
		userMap.put("info", "hello world");
		userMap.put("counting", new Integer(1024));
		userMap.put("list", list1);
		
	}

}
