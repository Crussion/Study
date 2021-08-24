package sample1;

public class HelloSpring {
	public static void main(String[] args) {
		MessageBeanKr kr = new MessageBeanKr();
		kr.tellMe();
		System.out.println("-----------");
		MessageBeanEn en = new MessageBeanEn();
		en.SayHello();
	}
}
