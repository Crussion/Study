class Charactor{
	String name;
	int age;
}
public class Exam2 {
	public static void main(String[] args) {
		Charactor c = new Charactor();
		c.name = "�Ѹ�";
		c.age = 19;
		
		Charactor h = new Charactor();
		h.name = "��";
		h.age = 3;
		
		System.out.printf("%s %d %s %d", c.name, c.age, h.name, h.age);
	}
}
