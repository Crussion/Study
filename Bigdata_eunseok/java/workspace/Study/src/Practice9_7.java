import java.util.Scanner;
public class Practice9_7 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print("*************"
					+ "\n1. 입력"
					+ "\n2. 검색"
					+ "\n3. 삭제"
					+ "\n4. 종료"
					+ "\n*************\n");
			System.out.print("번호 선택 : ");
			int i = s.nextInt();
			String str;
			switch(i) {
			case 1: str = "입력"; break;
			case 2: str = "검색"; break;
			case 3: str = "삭제"; break;
			default: str = "end";
			}
			if(str.equals("end")) {
				System.out.println("\n프로그램을 종료합니다.");
				break;
			}
			else System.out.printf("\n%s을(를) 선택하였습니다.\n\n", str);
		}
	}
}
