import java.util.Scanner;
public class Practice10_4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean[] place = {false, false, false, false, false};
		int i;
		boolean end = false;
		while(true) {
			System.out.print("���� ���� ���α׷�\n"
					+ "****************"
					+ "\n    1. ����"
					+ "\n    2. ����"
					+ "\n    3. ����Ʈ"
					+ "\n    4. ����"
					+ "\n****************"
					+ "\n  �޴� : ");
			int c = s.nextInt();
			switch(c) {
			case 1:
				System.out.print("��ġ �Է� : ");
				i = s.nextInt() - 1;
				if(!place[i]) {
					place[i] = !place[i];
					System.out.printf("%d��ġ�� �����Ǿ����ϴ�.\n", i + 1);
				}
				else System.out.println("�̹� �����Ǿ��ֽ��ϴ�.");
				break;
			case 2:
				System.out.print("��ġ �Է� : ");
				i = s.nextInt() - 1;
				if(place[i]) {
					place[i] = !place[i];
					System.out.printf("%d��ġ�� �����Ǿ����ϴ�.\n", i + 1);
				}
				else System.out.println("�����Ǿ� �����ʽ��ϴ�.");
				break;
			case 3:
				for(int j = 0; j < place.length; j++) {
					System.out.println(j + 1 + "��ġ : " + place[j]);
				}
				break;
			default:
				System.out.println("����Ǿ����ϴ�.");
				end = true;
			}
			if(end == true) break;
		}
	}
}
