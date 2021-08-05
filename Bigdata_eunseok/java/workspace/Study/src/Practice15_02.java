class Article{
	private int num;
	private String title;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
class FileArticle extends Article{
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String toString() {
		return "자료실 [번호=" + getNum() + ", 제목=" + getTitle() + ", 첨부파일=" + getFileName() + "]";
	}
	
}
class QNAArticle extends Article{
	private String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String toString() {
		return "질문/답변 [번호=" + getNum() +", 제목=" + getTitle() + ", 답변=" + getAnswer() + "]";
	}
}
public class Practice15_02 {
	public static void main(String[] args) {
		FileArticle fa = new FileArticle();
		fa.setNum(1);
		fa.setTitle("첫번쨰 자료입니다.");
		fa.setFileName("java.ppt");
		System.out.println(fa.toString());
		System.out.println();
		
		QNAArticle qna = new QNAArticle();
		qna.setNum(1);
		qna.setTitle("첫번째 질문입니다.");
		qna.setAnswer("첫번째 답변입니다.");
		System.out.println(qna.toString());
	}
}
