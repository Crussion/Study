import java.util.Scanner;
class Sub3{
	int kor, eng, tot;
	double avg;
	String g;
	public void grade() {
		
		if(avg >= 90) g = "A";
		else if(avg >= 80) g = "B";
		else if(avg >= 70) g = "C";
		else if(avg >= 60) g = "D";
		else g = "F";
	}
	
	public void input_kor() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		kor = s.nextInt();
	}
	public void input_eng() {
		Scanner s = new Scanner(System.in);
		System.out.print("���� ���� �Է� : ");
		eng = s.nextInt();
	}
	public void calc_tot() {
		tot = kor + eng;
	}
	public void calc_avg(double len) {
		avg = tot / len;
	}
	public void output() {
		System.out.println(g + "�����Դϴ�.");
	}
}
public class Practice12_03 {
	public static void main(String[] args) {
		Sub3 sub3 = new Sub3();
		sub3.input_kor();
		sub3.input_eng();
		sub3.calc_tot();
		sub3.calc_avg(2);
		sub3.grade();
		sub3.output();
	}
}
