import java.util.Scanner;

public class Practice11_12 {
	public static void menu(String[][] list, int n, Scanner s) {
		n = 0;
		while(true) {
			System.out.println("*********************");
			System.out.println("	1. 입고");
			System.out.println("	2. 출고");
			System.out.println("	3. 목록");
			System.out.println("	4. 종료");
			System.out.println("*********************");
			System.out.print  ("	메뉴 : ");
			switch(s.nextInt()) {
			case 1:
				in_goods(list, n, s);
				if(list[n] != null) n++;
				break;
			case 2:
				out_goods(list, s);
				break;
			case 3:
				output_list(list);
				break;
			default:
				System.exit(0);
			}
		}
	}
	public static void in_goods(String[][] list, int n, Scanner s) {
		System.out.print("품명 : ");
		String l = s.next();
		System.out.print("수량 : ");
		String c = s.next();
		for(int i = 0; i < list.length; i++) {
			if((list[i][0] != null) && list[i][0].equals(l)) {
				list[i][1] = Integer.toString((Integer.parseInt(list[i][1]) + Integer.parseInt(c)));
				return;
			}
			else break;
		}
		System.out.print("단가 : ");
		String p = s.next();
		for(int i = 0; i < list.length; i++) {
			list[n] = new String[] {l, c, p};
		}
		return;
	}
	public static void out_goods(String[][] list, Scanner s) {
		System.out.print("품명 : ");
		String l = s.next();
		System.out.print("수량 : ");
		String c = s.next();
		for(int i = 0; i < list.length; i++) {
			if((list[i][1] != null) && list[i][0].equals(l))
				list[i][1] = Integer.toString((Integer.parseInt(list[i][1]) - Integer.parseInt(c)));
		}
		return;
	}
	public static int compute(String[] list) {
		int n = Integer.parseInt(list[1]);
		int m = Integer.parseInt(list[2]);
		return n * m;
	}
	public static void output_list(String[][] list) {
		System.out.println("  품명        수량        단가(원)        총액(원)");
		for(int i = 0; i < list.length; i++) {
			if(!(list[i][0] == null))
				System.out.printf("%3s        %3s  %12s  %12d\n", list[i][0], list[i][1], list[i][2], compute(list[i]));
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = 0;
		String[][] list = new String[20][3];
		menu(list, n, s);
	}
}
