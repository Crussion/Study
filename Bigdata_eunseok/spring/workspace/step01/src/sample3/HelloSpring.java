package sample3;

public class HelloSpring {
	public static void main(String[] args) {
		BeanFactory beanFactory = new BeanFactory();
		MessageBean bean = beanFactory.getBean("en");
		bean.sayHello();
	}
}
