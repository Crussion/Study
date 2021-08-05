package customer;

import java.util.Scanner;

public class Practice1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Customer customer = new CustomerImpl();
		int n = 0;
		
		while(true) {
			do {
				System.out.print("1. 입력\n"
							   + "2. 출력\n"
							   + "3. 고객번호검색\n"
							   + "4. 이름검색\n"
							   + "5. 전화번호검색\n"
							   + "6. 이름 내림차순 정렬\n"
							   + "7. 고객번호 오름차순 정렬\n"
							   + "8. 종료\n"
							   + "---------------------\n"
							   + "번호 : ");
				n = s.nextInt();
			}while(n < 1 || n > 8);
			System.out.println();
			switch(n) {
			case 1: customer.input(); break;
			case 2: customer.print(); break;
			case 3: customer.serchNum(); break;
			case 4: customer.serchName(); break;
			case 5: customer.serchPhone(); break;
			case 6: customer.descSortName(); break;
			case 7: customer.ascSortNum(); break;
			case 8: System.out.println("종료합니다."); System.exit(0);
			}
			System.out.println();
		}
	}
}
