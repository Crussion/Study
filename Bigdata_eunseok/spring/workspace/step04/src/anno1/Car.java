package anno1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    <bean id="car" class="anno1.Car"> => @Component
		<property name="tire" ref="tire"/> => @Autowired
	</bean>
	@Autowired : setter를 통해 멤버변수를 초기화 함, 변수는 객체여야된다, 멤버는 bean 객체로 초기화 된다.
				setter가 있어도 없어도, 내부적으로 생성해서 사용함, 기본 생성자를 사용
 */
@Component
public class Car {
	@Autowired
	private Tire tire;
	
	public Car() {
	}
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public void drive() {
		System.out.println(tire.getBrand() + "로 만들어진 국산 자동차");
	}

}
