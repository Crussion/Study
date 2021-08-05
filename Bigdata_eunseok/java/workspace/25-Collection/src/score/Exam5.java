package score;

import java.util.Scanner;

public class Exam5 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Score score = new ScoreImpl();
		int n = 0;
		
		//27 - 파일 저장 읽기 추가
		while(true) {
			do {
				System.out.print("1. 입력\n"
							   + "2. 출력\n"
							   + "3. 학번검색\n"
							   + "4. 이름검색\n"
							   + "5. 총점 내림차순 정렬\n"
							   + "6. 학번 오름차순 정렬\n"
							   + "7. 파일 저장\n"
							   + "8. 파일 읽기\n"
							   + "9. 종료\n"
							   + "-------------------\n"
							   + "번호 : ");
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
			case 9: System.out.println("종료합니다."); System.exit(0);
			}
			System.out.println();
		}
	}
}
