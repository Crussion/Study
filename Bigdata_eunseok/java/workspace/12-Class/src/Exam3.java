class HelloWorld{
	String message;
	
	void setEng() {
		message = "Hello Java";
	}
	void setKor() {
		message = "�ȳ��ϼ���, �ڹ�";
	}
	void sayHello() {
		System.out.println(message);
	}
}
public class Exam3 {
	public static void main(String[] args) {
		HelloWorld helloworld = new HelloWorld();
		helloworld.setEng();
		helloworld.sayHello();
		
		helloworld.setKor();
		helloworld.sayHello();
	}
}
