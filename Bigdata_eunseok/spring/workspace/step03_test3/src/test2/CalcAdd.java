package test2;

public class CalcAdd implements Calc{
	private int n, m;
	
	
	public CalcAdd(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}


	@Override
	public void calculate() {
		System.out.println(n + " + " + m + " = " + (n + m));
	}
}
