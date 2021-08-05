
public class Exam1 {
	public static void main(String[] args) {
		CalcParent parent = new CalcParent();
		System.out.println(parent.plus(5, 7));
		System.out.println(parent.minus(5, 7));
		
		CalcChild child = new CalcChild();
		System.out.println(child.plus(3, 5));
		System.out.println(child.minus(3, 5));
		System.out.println(child.multi(3, 5));
		System.out.println(child.div(3, 5));
	}
}
