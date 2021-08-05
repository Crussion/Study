class Unit{
	String name;

	public Unit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void attack() {
		System.out.println(name + " >> ���� �غ�");
	}
}
class Army extends Unit{
	public Army(String name) {
		super(name);
	}
	
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> ���� ���� ������");
	}
	
	public void tank() {
		System.out.println(getName() + " >> ��ũ ����");
	}
}
class Navy extends Unit{
	public Navy(String name) {
		super(name);
	}
	
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> ��� �߻�!!");
		System.out.println(getName() + " >> ���� ���");
	}
	
	public void nucleus() {
		System.out.println(getName() + " >> �ٹ̻���");
	}
}
class AirForce extends Unit{
	public AirForce(String name) {
		super(name);
	}
	
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> �̷�");
		System.out.println(getName() + " >> ���߰��� ������");
	}
	
	public void bombing() {
		System.out.println(getName() + " >> ����");
	}
}
public class Exam2 {
	public static void main(String[] args) {
		Army a = new Army("����");
		a.attack();
		a.tank();
		Navy n = new Navy("�ر�");
		n.attack();
		n.nucleus();
		AirForce af = new AirForce("����");
		af.attack();
		af.bombing();
	}
}
