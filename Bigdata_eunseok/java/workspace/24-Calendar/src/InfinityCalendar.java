import java.util.Calendar;
import java.util.Scanner;

public class InfinityCalendar {
	Scanner s = new Scanner(System.in);
	Calendar cal = Calendar.getInstance();
	int y, m;
	int dayNum;
	
	void input() {
		do {
			System.out.print("�� : ");
			y = s.nextInt();
		}while(y<1);
		
		do {
			System.out.print("�� : ");
			m = s.nextInt();
		}while(m < 1 || m > 12);
	}
	
	void setDate() {
		cal.set(y, m - 1, 1);
		dayNum = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("���ϼ� : " + dayNum);
	}
	
	void outputTitle() {
		System.out.println();
		System.out.println("��  ��  ȭ ��  �� ��  ��");
		System.out.println("---------------------");
	}
	
	void output() {
		for(int i = 1; i < dayNum; i++) {
			System.out.print("   ");
		}
		int daysOfMonth = cal.getActualMaximum(Calendar.DATE);
		for(int i = 1; i <= daysOfMonth; i++) {
			System.out.printf("%2d ", i);
			dayNum++;
			if(dayNum%7 == 1) {
				System.out.println();
			}
		}
	}
}
