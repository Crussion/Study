package anno1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverCar {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("anno1/bean.xml");
		
		Tire tire = (Tire) context.getBean("tire");
		System.out.println(tire.getBrand());
		
		Car car = (Car) context.getBean("car");
		car.drive();
		
		context.close();
	}
}
