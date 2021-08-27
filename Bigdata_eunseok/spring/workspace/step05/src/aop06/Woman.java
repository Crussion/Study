package aop06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person{
	public void classwork() {
		System.out.println("컴퓨터를 켜고 쇼핑을 시작한다.");
	}
}
