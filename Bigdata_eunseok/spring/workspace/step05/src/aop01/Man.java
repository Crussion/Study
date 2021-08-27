package aop01;

public class Man {
	public void classwork() {
		System.out.println("교실문을 연다.");
		
		try {
			System.out.println("컴퓨터를 켜고 게임을 시작한다.");
		}catch(Exception e) {
			System.out.println("** 오늘은 소독하는 날 **");
		} finally {
			System.out.println("전등이 켜져있는 지 확인한다.");
		}
		
		System.out.println();
	}
}
