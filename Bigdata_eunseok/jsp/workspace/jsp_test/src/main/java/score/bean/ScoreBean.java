package score.bean;

public class ScoreBean {
	int student_num;
    String student_name;
    double score_kor = 0;
    double score_eng = 0;
    double score_math = 0;
    double score_total = 0;
    double score_avg = 0;
	public int getStudent_num() {
		return student_num;
	}
	public void setStudent_num(int student_num) {
		this.student_num = student_num;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public double getScore_kor() {
		return score_kor;
	}
	public void setScore_kor(double score_kor) {
		this.score_kor = score_kor;
	}
	public double getScore_eng() {
		return score_eng;
	}
	public void setScore_eng(double score_eng) {
		this.score_eng = score_eng;
	}
	public double getScore_math() {
		return score_math;
	}
	public void setScore_math(double score_math) {
		this.score_math = score_math;
	}
	public double getScore_total() {
		return score_total;
	}
	public void setScore_total(double score_total) {
		this.score_total = score_total;
	}
	public double getScore_avg() {
		return score_avg;
	}
	public void setScore_avg(double score_avg) {
		this.score_avg = score_avg;
	}
    
}
