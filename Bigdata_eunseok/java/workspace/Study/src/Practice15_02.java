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
		return "�ڷ�� [��ȣ=" + getNum() + ", ����=" + getTitle() + ", ÷������=" + getFileName() + "]";
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
		return "����/�亯 [��ȣ=" + getNum() +", ����=" + getTitle() + ", �亯=" + getAnswer() + "]";
	}
}
public class Practice15_02 {
	public static void main(String[] args) {
		FileArticle fa = new FileArticle();
		fa.setNum(1);
		fa.setTitle("ù���� �ڷ��Դϴ�.");
		fa.setFileName("java.ppt");
		System.out.println(fa.toString());
		System.out.println();
		
		QNAArticle qna = new QNAArticle();
		qna.setNum(1);
		qna.setTitle("ù��° �����Դϴ�.");
		qna.setAnswer("ù��° �亯�Դϴ�.");
		System.out.println(qna.toString());
	}
}
