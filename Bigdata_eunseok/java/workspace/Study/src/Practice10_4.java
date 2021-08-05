import java.util.Scanner;
public class Practice10_4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean[] place = {false, false, false, false, false};
		int i;
		boolean end = false;
		while(true) {
			System.out.print("주차 관리 프로그램\n"
					+ "****************"
					+ "\n    1. 입차"
					+ "\n    2. 출차"
					+ "\n    3. 리스트"
					+ "\n    4. 종료"
					+ "\n****************"
					+ "\n  메뉴 : ");
			int c = s.nextInt();
			switch(c) {
			case 1:
				System.out.print("위치 입력 : ");
				i = s.nextInt() - 1;
				if(!place[i]) {
					place[i] = !place[i];
					System.out.printf("%d위치에 주차되었습니다.\n", i + 1);
				}
				else System.out.println("이미 주차되어있습니다.");
				break;
			case 2:
				System.out.print("위치 입력 : ");
				i = s.nextInt() - 1;
				if(place[i]) {
					place[i] = !place[i];
					System.out.printf("%d위치에 출차되었습니다.\n", i + 1);
				}
				else System.out.println("주차되어 있지않습니다.");
				break;
			case 3:
				for(int j = 0; j < place.length; j++) {
					System.out.println(j + 1 + "위치 : " + place[j]);
				}
				break;
			default:
				System.out.println("종료되었습니다.");
				end = true;
			}
			if(end == true) break;
		}
	}
}
