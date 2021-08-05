package score;

import java.io.Serializable;

public class ScoreVO implements Serializable{
	String student_num;
	String student_name;
	int kor, eng, mat, tot;
	double avg;
	
	public String toString() {
		if(student_num == null || student_name == null) return null;
		String str = String.format("%8s %6s %4d %4d %4d %4d %4.1f", student_num, 
									student_name, kor, eng, mat, tot, avg);
		return str;
	}

	public String getStudent_num() {
		return student_num;
	}

	public void setStudent_num(String student_num) {
		this.student_num = student_num;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	
	
	
}
