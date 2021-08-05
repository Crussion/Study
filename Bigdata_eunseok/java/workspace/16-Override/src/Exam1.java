class Score{
	String name;
	int kor, eng, mat;
	int tot;
	double avg;
	public Score() {}
	public Score(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public int calc_tot() {
		tot = kor + eng + mat;
		return tot;
	}
	
	public double calc_avg() {
		avg = tot / 3.0;
		return avg;
	}
	
	public void output_result() {
		System.out.printf("%s %d %.1f\n", name, calc_tot(), calc_avg());
	}
}
class Score2 extends Score{
	int mus, com;
	
	public Score2(String name, int kor, int eng, int mat, int mus, int com) {
		super(name, kor, eng, mat);
		this.mus = mus;
		this.com = com;
	}
	
	public int calc_tot() {
		tot = super.calc_tot() + mus + com;
		return tot;
	}
	
	public double calc_avg() {
		avg = tot / 5.0;
		return avg;
	}
	
}
public class Exam1 {
	public static void main(String[] args) {
		Score s1 = new Score("È«±æµ¿", 80, 70, 50);
		s1.output_result();
		
		Score2 s2 = new Score2("±èÃ¶¼ö", 60, 70, 90, 80, 70);
		s2.output_result();
	}
}
