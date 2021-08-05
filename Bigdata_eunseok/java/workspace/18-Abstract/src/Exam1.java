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
		System.out.println(getName() + " >> 지상 공격");
	}
	
	public void move() {
		System.out.println(getName() + " >> 지상 이동");
	}
}
class Navy extends Unit{
	public Navy(String name) {
		super(name);
	}
	
	public void attack() {
		System.out.println(getName() + " >> 해상 공격");
	}
	
	public void move() {
		System.out.println(getName() + " >> 해상 이동");
	}
}
class AirForce extends Unit{
	public AirForce(String name) {
		super(name);
	}
	
	public void attack() {
		System.out.println(getName() + " >> 공중 공격");
	}
	
	public void move() {
		System.out.println(getName() + " >> 공중 이동");
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Unit army = new Army("육군");
		Unit navy = new Navy("해군");
		Unit airForce = new AirForce("공군");
		
		army.attack();
		army.move();
		
		navy.attack();
		navy.move();
		
		airForce.attack();
		airForce.move();
		
		Unit[] units = new Unit[3];
		units[0] = new Army("육군");
		units[1] = new Navy("해군");
		units[2] = new AirForce("공군");
		
		for(int i = 0; i < units.length; i++) {
			units[i].attack();
			units[i].move();
		}
	}
}
