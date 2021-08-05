
public class Exam1 {
	public static void main(String[] args) {
		int a = 5;
		System.out.println(a);
		
		Integer b = new Integer(7);
		System.out.println(b);
		
		Integer c = 9;
		System.out.println(c);
		
		Object ob = a;
		int aa = (int)ob;
		
		int num = Integer.parseInt("20");
		double n = Double.parseDouble("3.14");
		System.out.println(num + 100);
		System.out.println(n + 5.2);
	}
}
