
public class Bank {
	private String name;
	private int money;
	private static double rate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public static double getRate() {
		return rate;
	}

	public static void setRate(double rate) {
		Bank.rate = rate;
	}

	Bank(String name, int money){
		this.name = name;
		this.money = money;
	}
	
	void print_bank() {
		System.out.println(name);
		System.out.println(money);
		System.out.println(rate);
	}
}
