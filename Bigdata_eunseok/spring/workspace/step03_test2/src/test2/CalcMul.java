package test2;

public class CalcMul implements Calc{
	private int n, m;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
	
	@Override
	public void calculate() {
		System.out.println(n + " * " + m + " = " + (n * m));
	}
}
