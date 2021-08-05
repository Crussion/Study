package school;

import java.util.List;
import java.util.Scanner;

public class SchoolController {
	Scanner s = new Scanner(System.in);
	String name, value;
	public void menu() {
		while(true) {
			System.out.print("************\n"
						   + "    ����\n"
						   + "************\n"
						   + "  1. �Է�\n"
						   + "  2. �˻�\n"
						   + "  3. ����\n"
						   + "  4. ����\n"
						   + "************\n"
						   + "  ��ȣ���� : ");
			int n = s.nextInt();
			
			if(n == 1) {
				while(true) {
					System.out.println();
					System.out.print("************\n"
								   + "  1. �л�\n"
								   + "  2. ����\n"
								   + "  3. ������\n"
								   + "  4. �����޴�\n"
								   + "************\n"
								   + "  ��ȣ���� : ");
					int m = s.nextInt();
					if(m == 1) {
						System.out.print("�̸� �Է� : ");
						name = s.next();
						System.out.print("�й� �Է� : ");
						value = s.next();
						insertDB(name, value, m);
					}else if(m == 2) {
						System.out.print("�̸� �Է� : ");
						name = s.next();
						System.out.print("���� �Է� : ");
						value = s.next();
						insertDB(name, value, m);
					}else if(m == 3) {
						System.out.print("�̸� �Է� : ");
						name = s.next();
						System.out.print("�μ� �Է� : ");
						value = s.next();
						insertDB(name, value, m);
					}else if(m == 4)
						break;
					else System.out.println("�߸��� �Է� �Դϴ�. �ٽ� �Է��� �ּ���.");
				}
			}else if(n == 2) {
				while(true) {
					System.out.println();
					System.out.print("************\n"
								   + " 1. �̸� �˻�\n"
								   + " 2. ��ü �˻�\n"
								   + " 3. �����޴�\n"
								   + "************\n"
								   + "  ��ȣ���� : ");
					int m = s.nextInt();
					if(m == 1) {
						System.out.print("�˻��� �̸� �Է� : ");
						String name = s.next();
						searchDB(name);
					}else if(m == 2) {
						searchDB(null);
					}else if(m == 3) {
						break;
					}else
						System.out.println("�߸��� �Է� �Դϴ�. �ٽ� �Է��� �ּ���.");
				}
			}else if(n == 3) {
				System.out.print("������ ���ϴ� �̸� �Է� : ");
				name = s.next();
				deleteDB(name);
			}else if(n == 4) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}else
				System.out.println("�߸��� �Է� �Դϴ�. �ٽ� �Է��� �ּ���.");
		}
	}
	
	public void insertDB(String name, String value, int code) {
		SchoolDAO dao = new SchoolDAO();
		int result = dao.insertArticle(name, value, code);
		System.out.println(result + "���� ���� ����������ϴ�.");
	}
	
	public void searchDB(String name) {
		SchoolDAO dao = new SchoolDAO();
		List<SchoolDTO> list = dao.selectArticle(name);
		for(int i = 0; i < list.size(); i++) {
			switch(list.get(i).getCode()) {
			case 1:
				System.out.printf("�̸�=%s �й�=%s", list.get(i).getName(), list.get(i).getValue());
				break;
			case 2:
				System.out.printf("�̸�=%s ����=%s", list.get(i).getName(), list.get(i).getValue());
				break;
			case 3:
				System.out.printf("�̸�=%s �μ�=%s", list.get(i).getName(), list.get(i).getValue());
				break;
			}
			System.out.println();
		}
	}
	
	public void deleteDB(String name) {
		SchoolDAO dao = new SchoolDAO();
		int result = dao.deleteArticle(name);
		System.out.println(result + "���� ���� �����Ǿ����ϴ�.");
	}
}
