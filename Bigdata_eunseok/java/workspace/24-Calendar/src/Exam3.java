import java.util.Calendar;

public class Exam3 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		long ms1 = cal.getTimeInMillis();
		System.out.println(ms1);
		
		long n = 0;
		for(int i = 0; i < 2000000000l; i++) {
			n += i;
		}
		/*
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		*/
		cal = Calendar.getInstance();
		long ms2 = cal.getTimeInMillis();
		System.out.println(ms2);
		
		System.out.println(ms2 - ms1);
	}
}
