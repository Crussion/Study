import java.util.Scanner;

class Sales{
	private Scanner s = new Scanner(System.in);
	private String article;
	private int qty;
	private int cost;
	static int cnt;
	static double discount;
	
	void input() {
		System.out.print("품목 : ");
		article = s.next();
		System.out.print("수량 : ");
		qty = s.nextInt();
		System.out.print("단가 : ");
		cost = s.nextInt();
		setCnt(qty);
	}

	public static int getCnt() {
		return cnt;
	}

	public static void setCnt(int cnt) {
		Sales.cnt += cnt;
	}
	
	public static void setDiscount(double discount) {
		Sales.discount = discount;
	}

	public String getArticle() {
		return article;
	}

	public int getQty() {
		return qty;
	}

	public int getCost() {
		return cost;
	}
	
	
}
class Test_0 extends Sales{
	int amount;
	
	void setProcess() {
		amount = getQty() * getCost();
	}
	
	void getDisplay() {
		setProcess();
		System.out.println(getArticle() + " : " + (amount * (1 - Test_0.discount)));
	}
}
public class Practice15_03 {
	public static void main(String[] args) {
		Test_0[] op = new Test_0[2];
		for(int i = 0; i < op.length; i++) {
			op[i] = new Test_0();
			op[i].input();
		}
		Test_0.setDiscount(0.15);
		for(int i = 0; i < op.length; i++) {
			op[i].getDisplay();
		}
		System.out.println("판매 건수 : " + Test_0.getCnt());
	}
}
