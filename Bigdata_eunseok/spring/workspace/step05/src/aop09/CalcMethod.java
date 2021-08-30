package aop09;

public class CalcMethod {
	public void sum(int n, int m) {
		System.out.println(n + " + " + m + " = " + (n + m));
	}
	public void div(int n, int m) {
		try {
			System.out.println(n + " / " + m + " = " + (n / m));
		} catch (Exception e) {
			System.out.println("0으로 나눌수 없습니다.");
		}
	}
	
}
