
public class Exam3 {
	public static void main(String[] args) {
		String jumin = "9006074234567";
		String year = jumin.substring(0,2);
		String month = jumin.substring(2,4);
		String day = jumin.substring(4,6);
		int s = Integer.parseInt(jumin.substring(6,7));
		String sung;
		String y;
		switch(s) {
		case 1: sung = "����"; y = "19"; break;
		case 2: sung = "����"; y = "19"; break;
		case 3: sung = "����"; y = "20"; break;
		case 4: sung = "����"; y = "20"; break;
		default: sung = "����"; y = "19";
		}
		System.out.printf("%s%s�� %s�� %s�� %s", y, year, month, day, sung);
	}
}
