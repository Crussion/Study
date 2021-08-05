package school;

import java.util.List;
import java.util.Scanner;

public class SchoolController {
	Scanner s = new Scanner(System.in);
	String name, value;
	public void menu() {
		while(true) {
			System.out.print("************\n"
						   + "    관리\n"
						   + "************\n"
						   + "  1. 입력\n"
						   + "  2. 검색\n"
						   + "  3. 삭제\n"
						   + "  4. 종료\n"
						   + "************\n"
						   + "  번호선택 : ");
			int n = s.nextInt();
			
			if(n == 1) {
				while(true) {
					System.out.println();
					System.out.print("************\n"
								   + "  1. 학생\n"
								   + "  2. 교수\n"
								   + "  3. 관리자\n"
								   + "  4. 이전메뉴\n"
								   + "************\n"
								   + "  번호선택 : ");
					int m = s.nextInt();
					if(m == 1) {
						System.out.print("이름 입력 : ");
						name = s.next();
						System.out.print("학번 입력 : ");
						value = s.next();
						insertDB(name, value, m);
					}else if(m == 2) {
						System.out.print("이름 입력 : ");
						name = s.next();
						System.out.print("과목 입력 : ");
						value = s.next();
						insertDB(name, value, m);
					}else if(m == 3) {
						System.out.print("이름 입력 : ");
						name = s.next();
						System.out.print("부서 입력 : ");
						value = s.next();
						insertDB(name, value, m);
					}else if(m == 4)
						break;
					else System.out.println("잘못된 입력 입니다. 다시 입력해 주세요.");
				}
			}else if(n == 2) {
				while(true) {
					System.out.println();
					System.out.print("************\n"
								   + " 1. 이름 검색\n"
								   + " 2. 전체 검색\n"
								   + " 3. 이전메뉴\n"
								   + "************\n"
								   + "  번호선택 : ");
					int m = s.nextInt();
					if(m == 1) {
						System.out.print("검색할 이름 입력 : ");
						String name = s.next();
						searchDB(name);
					}else if(m == 2) {
						searchDB(null);
					}else if(m == 3) {
						break;
					}else
						System.out.println("잘못된 입력 입니다. 다시 입력해 주세요.");
				}
			}else if(n == 3) {
				System.out.print("삭제를 원하는 이름 입력 : ");
				name = s.next();
				deleteDB(name);
			}else if(n == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}else
				System.out.println("잘못된 입력 입니다. 다시 입력해 주세요.");
		}
	}
	
	public void insertDB(String name, String value, int code) {
		SchoolDAO dao = new SchoolDAO();
		int result = dao.insertArticle(name, value, code);
		System.out.println(result + "개의 행이 만들어졌습니다.");
	}
	
	public void searchDB(String name) {
		SchoolDAO dao = new SchoolDAO();
		List<SchoolDTO> list = dao.selectArticle(name);
		for(int i = 0; i < list.size(); i++) {
			switch(list.get(i).getCode()) {
			case 1:
				System.out.printf("이름=%s 학번=%s", list.get(i).getName(), list.get(i).getValue());
				break;
			case 2:
				System.out.printf("이름=%s 과목=%s", list.get(i).getName(), list.get(i).getValue());
				break;
			case 3:
				System.out.printf("이름=%s 부서=%s", list.get(i).getName(), list.get(i).getValue());
				break;
			}
			System.out.println();
		}
	}
	
	public void deleteDB(String name) {
		SchoolDAO dao = new SchoolDAO();
		int result = dao.deleteArticle(name);
		System.out.println(result + "개의 행이 삭제되었습니다.");
	}
}
