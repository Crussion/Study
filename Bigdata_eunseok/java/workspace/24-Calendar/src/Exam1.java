import java.util.Calendar;

public class Exam1 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.toString());
		System.out.println();
		
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));

	}
}
