package score;

import java.util.Scanner;

public class Exam5 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Score score = new ScoreImpl();
		int n = 0;
		
		//27 - ���� ���� �б� �߰�
		while(true) {
			do {
				System.out.print("1. �Է�\n"
							   + "2. ���\n"
							   + "3. �й��˻�\n"
							   + "4. �̸��˻�\n"
							   + "5. ���� �������� ����\n"
							   + "6. �й� �������� ����\n"
							   + "7. ���� ����\n"
							   + "8. ���� �б�\n"
							   + "9. ����\n"
							   + "-------------------\n"
							   + "��ȣ : ");
				n = s.nextInt();
			}while(n < 1 || n > 9);
			System.out.println();
			switch(n) {
			case 1: score.input(); break;
			case 2: score.print(); break;
			case 3: score.serchStudentNum(); break;
			case 4: score.serchName(); break;
			case 5: score.descSortTot(); break;
			case 6: score.ascSortStudentNum(); break;
			case 7: score.saveFile(); break;
			case 8: score.loadFile(); break;
			case 9: System.out.println("�����մϴ�."); System.exit(0);
			}
			System.out.println();
		}
	}
}
