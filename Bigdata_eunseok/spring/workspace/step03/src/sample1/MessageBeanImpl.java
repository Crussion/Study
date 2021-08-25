package sample1;

public class MessageBeanImpl implements MessageBean{
	private String fruit;
	private int cost;
	
	public MessageBeanImpl() {
		System.out.println("MessageBeanImpl() 호출");
	}
	
	public MessageBeanImpl(String fruit) {
		this.fruit = fruit;
		System.out.println("MessageBeanImpl(String fruit) 호출");
	}
	
	@Override
	public void sayHello() {
		System.out.println("Fruit = " + fruit + ", Cost = " + cost);
		
	}
	@Override
	public void sayHello(String a, int b) {
		System.out.println("a = " + a + ", b = " + b);
	}
	
	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
		System.out.println("setFruit() 호출");
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
		System.out.println("setCost() 호출");
	}
}
