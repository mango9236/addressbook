package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import dao.AddressDao;
import dto.AddressDto;

public class MainClass {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        AddressDao dao = new AddressDao();
        
        boolean check = true; // 종료 체크할 boolean
        
        // 메뉴
        while (check) {
            System.out.println("============ address book menu ===========");
            System.out.println("1. add address");
            System.out.println("2. delete address");
            System.out.println("3. select address");
            System.out.println("4. update address");
            System.out.println("5. allDataPrint");
            System.out.println("6. save");
            System.out.println("7. load");
            System.out.println("8. exit");
           
            System.out.print("menu number >> ");
            int menuNumber = sc.nextInt();

            switch (menuNumber) {
                case 1:
                    dao.insert();
                    break;
                case 2:
                	dao.delete();
                    break;
                case 3:
                	dao.select();
                    break;
                case 4:
                	dao.update();
                    break;
                case 5:
                    dao.allDataPrint();
                    break;
                case 6:
                	dao.Save();
                	break;
                case 7:
                	dao.load();
                	break;
                case 8:
                	check = false;
                	System.out.println("[종료] 전화번호부 프로그램 ");
                	break;
                default:
                	System.out.println("올바른 번호를 입력하세요.");
                	break;
            }
        }
    }
}