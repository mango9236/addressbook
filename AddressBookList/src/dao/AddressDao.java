package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.AddressDto;

// DAO(Data Access Object)
public class AddressDao {
	// 데이터를 편집하는 클래스
	
	// composition
	private Scanner sc = new Scanner(System.in);
	
	private List<AddressDto> addressList = null;
	
	public AddressDao() {		
		addressList = new ArrayList<AddressDto>();
	}
	
	/* 1. 추가 */
	public void insert() {
		// TODO: insert()
		System.out.println("데이터를 추가합니다");
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 = ");
		int age = sc.nextInt();
		
		System.out.print("전화번호 = ");
		String phone = sc.next();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		System.out.print("주소 = ");
		String address = "";
		try {
			address = br.readLine();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
		System.out.print("메모 = ");
		String memo = "";
		try {
			memo = br.readLine();
		} catch (IOException e) { e.printStackTrace(); }
		
		addressList.add(new AddressDto(name, age, phone, address, memo));		
	}
	
	/* 2. 삭제 */
	public void delete() {	
		// TODO: delete() 함수
		System.out.print("삭제할 지인의 이름 >> ");
		String name = sc.next();
		
		int index = search(name);
		
		if(index == -1) {
			System.out.println("지인정보를 찾을 수 없습니다");
		}else {
			addressList.remove(index);
			
			System.out.println("지인정보를 삭제했습니다");
		}
		
	}
	
	/* 3. 검색 */
	public void select() {	// 이름으로 검색
		System.out.print("검색할 지인의 이름 >> ");
		String name = sc.next();
		
		List<AddressDto> findNameList = new ArrayList<AddressDto>();		
		for (int i = 0; i < addressList.size(); i++) {
			AddressDto dto = addressList.get(i);
			if(name.equals(dto.getName())) {
				findNameList.add(dto);
			}
		}
		
		if(findNameList.size() == 0) {
			System.out.println("기입하신 사람은 찾을 수 없습니다");
			return;
		}		
		
		System.out.println("--- 검색된 명단입니다 --- ");
		for (int i = 0; i < findNameList.size(); i++) {
			AddressDto dto = findNameList.get(i);
			System.out.println(dto.toString());
		}			
	}
	
	/* 4. 수정 */
	public void update() {	
		System.out.print("수정할 지인의 이름 >> ");
		String name = sc.next();
		
		// 검색
		int index = search(name);
		if(index == -1) {
			System.out.println("지인의 정보를 찾을 수 없습니다");
			return;
		}
		
		// 수정
		System.out.print("전화번호 >> ");
		String phone = sc.next();
		
		System.out.print("주소 >> ");
		String address = sc.next();
		
		System.out.println("메모 >> ");
		String memo = sc.next();
		
		AddressDto dto = addressList.get(index);
		dto.setPhone(phone);
		dto.setAddress(address);
		dto.setMemo(memo);
		
		System.out.println("수정을 완료했습니다");
	}
	
	/* 5. 검색 */
	public int search(String name) {
		int index = -1;
		for (int i = 0; i < addressList.size(); i++) {
			AddressDto dto = addressList.get(i);
			if(name.equals(dto.getName())) {
				index = i;
				break;
			}
		}		
		return index;
	}
	
	/* 6. 모두 출력 */
	public void allDataPrint() {
		// TODO: allDataPrint
		if(addressList.isEmpty()) {	// addressList.size() == 0
			System.out.println("데이터 없습니다");
			return;
		}
		
		for (int i = 0; i < addressList.size(); i++) {
			System.out.println(addressList.get(i).toString());
		}
		
	}
}










