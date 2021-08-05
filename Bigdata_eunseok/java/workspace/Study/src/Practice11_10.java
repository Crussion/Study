import java.util.Scanner;

public class Practice11_10 {
	public static int input_menu(Scanner s) {
		System.out.print("���� ���� ���α׷�\n"
				+ "****************"
				+ "\n    1. ����"
				+ "\n    2. ����"
				+ "\n    3. ����Ʈ"
				+ "\n    4. ����"
				+ "\n****************"
				+ "\n  �޴� : ");
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
			System.out.println("����Ǿ����ϴ�.");
			System.exit(0);
		}
	}
	public static void input_car(boolean[] place, int i, Scanner s) {
		System.out.print("��ġ �Է� : ");
		i = s.nextInt() - 1;
		if(!place[i]) {
			place[i] = !place[i];
			System.out.printf("%d��ġ�� �����Ǿ����ϴ�.\n", i + 1);
		}
		else System.out.println("�̹� �����Ǿ��ֽ��ϴ�.");
	}
	public static void output_car(boolean[] place, int i, Scanner s) {
		System.out.print("��ġ �Է� : ");
		i = s.nextInt() - 1;
		if(place[i]) {
			place[i] = !place[i];
			System.out.printf("%d��ġ�� �����Ǿ����ϴ�.\n", i + 1);
		}
		else System.out.println("�����Ǿ� �����ʽ��ϴ�.");
	}
	public static void print_list(boolean[] place) {
		for(int j = 0; j < place.length; j++) {
			System.out.println(j + 1 + "��ġ : " + place[j]);
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
