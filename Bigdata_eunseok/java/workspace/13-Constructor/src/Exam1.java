class Book{
	String subject;
	String content;
	
	Book(){
		System.out.println("--- ������ ����� ---");
		subject = "JAVA �Թ�";
		content = "JAVA�� ������鿡 ���˴ϴ�.";
	}
	void read() {
		System.out.println("--- read() ����� ---");
		System.out.println(subject);
		System.out.println(content);
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Book book = new Book();
		book.read();
	}
}
