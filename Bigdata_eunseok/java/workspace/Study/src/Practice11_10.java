import java.util.Scanner;

public class Practice11_10 {
	public static int input_menu(Scanner s) {
		System.out.print("주차 관리 프로그램\n"
				+ "****************"
				+ "\n    1. 입차"
				+ "\n    2. 출차"
				+ "\n    3. 리스트"
				+ "\n    4. 종료"
				+ "\n****************"
				+ "\n  메뉴 : ");
		return s.nextInt();
	}
	public static void check_end(int c, boolean[] place, int i, Scanner s) {
		switch(c) {
		case 1:
			input_car(place, i, s);
			break;
		case 2:
			output_car(place, i, s);
			break;
		case 3:
			print_list(place);
			break;
		default:
			System.out.println("종료되었습니다.");
			System.exit(0);
		}
	}
	public static void input_car(boolean[] place, int i, Scanner s) {
		System.out.print("위치 입력 : ");
		i = s.nextInt() - 1;
		if(!place[i]) {
			place[i] = !place[i];
			System.out.printf("%d위치에 주차되었습니다.\n", i + 1);
		}
		else System.out.println("이미 주차되어있습니다.");
	}
	public static void output_car(boolean[] place, int i, Scanner s) {
		System.out.print("위치 입력 : ");
		i = s.nextInt() - 1;
		if(place[i]) {
			place[i] = !place[i];
			System.out.printf("%d위치에 출차되었습니다.\n", i + 1);
		}
		else System.out.println("주차되어 있지않습니다.");
	}
	public static void print_list(boolean[] place) {
		for(int j = 0; j < place.length; j++) {
			System.out.println(j + 1 + "위치 : " + place[j]);
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean[] place = {false, false, false, false, false};
		int i = 0;
		while(true) {
			int c = input_menu(s);
			check_end(c, place, i, s);
		}
	}
}
