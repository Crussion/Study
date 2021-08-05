import java.util.Calendar;

public class Exam4 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		/*
		long mils = cal.getTimeInMillis();
		long result = mils/1000/3600/24;
		System.out.println(result);
		
		
		int dayNum = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayNum);
		
		int week_cnt = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
		System.out.println(week_cnt);
		
		int day_cnt = cal.getActualMaximum(Calendar.DATE);
		System.out.println(day_cnt);
		*/
		cal.set(Calendar.DAY_OF_MONTH, 1);
		DataPrinter.printDateTime(cal);
		
		int first_day = cal.get(Calendar.DAY_OF_WEEK);
		String[] day_name = {"일","월","화","수","목","금","토"};
		
		System.out.println(day_name[first_day - 1]);
	}
}
