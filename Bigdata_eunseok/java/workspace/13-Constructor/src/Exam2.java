class Article{
	int seq;
	String subject;
	String writer;
	
	Article(int seq, String subject, String writer){
		this.seq = seq;
		this.subject = subject;
		this.writer = writer;
	}
	
	void print() {
		System.out.println(seq);
		System.out.println(subject);
		System.out.println(writer);
	}
}
public class Exam2 {
	public static void main(String[] args) {
		Article art = new Article(2019, "JAVA연습 입니다.", "JAVA 학생");
		art.print();
	}
}
