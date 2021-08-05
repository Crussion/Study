import java.util.Calendar;

public class Exam2 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		DataPrinter.printDateTime(cal);
		
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 6);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		DataPrinter.printDateTime(cal);
		
		cal.set(Calendar.HOUR_OF_DAY, 20);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		DataPrinter.printDateTime(cal);
		
		cal.set(1998, 5, 17);
		DataPrinter.printDateTime(cal);
		
		cal.set(2000, 5, 30, 12, 12, 12);
		DataPrinter.printDateTime(cal);
	}
}
