abstract class Unit{
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
	
	abstract public void attack();
	abstract public void move();
}
class Army extends Unit{
	public Army(String name) {
		super(name);
	}
	
	public void attack() {
		System.out.println(getName() + " >> ���� ����");
	}
	
	public void move() {
		System.out.println(getName() + " >> ���� �̵�");
	}
}
class Navy extends Unit{
	public Navy(String name) {
		super(name);
	}
	
	public void attack() {
		System.out.println(getName() + " >> �ػ� ����");
	}
	
	public void move() {
		System.out.println(getName() + " >> �ػ� �̵�");
	}
}
class AirForce extends Unit{
	public AirForce(String name) {
		super(name);
	}
	
	public void attack() {
		System.out.println(getName() + " >> ���� ����");
	}
	
	public void move() {
		System.out.println(getName() + " >> ���� �̵�");
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Unit army = new Army("����");
		Unit navy = new Navy("�ر�");
		Unit airForce = new AirForce("����");
		
		army.attack();
		army.move();
		
		navy.attack();
		navy.move();
		
		airForce.attack();
		airForce.move();
		
		Unit[] units = new Unit[3];
		units[0] = new Army("����");
		units[1] = new Navy("�ر�");
		units[2] = new AirForce("����");
		
		for(int i = 0; i < units.length; i++) {
			units[i].attack();
			units[i].move();
		}
	}
}
