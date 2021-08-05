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
		System.out.println(name + " >> 공격 준비");
	}
}
class Army extends Unit{
	public Army(String name) {
		super(name);
	}
	
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> 지상 공격 실행함");
	}
	
	public void tank() {
		System.out.println(getName() + " >> 탱크 공격");
	}
}
class Navy extends Unit{
	public Navy(String name) {
		super(name);
	}
	
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> 어뢰 발사!!");
		System.out.println(getName() + " >> 지상 상륙");
	}
	
	public void nucleus() {
		System.out.println(getName() + " >> 핵미사일");
	}
}
class AirForce extends Unit{
	public AirForce(String name) {
		super(name);
	}
	
	public void attack() {
		super.attack();
		System.out.println(getName() + " >> 이륙");
		System.out.println(getName() + " >> 공중공격 실행함");
	}
	
	public void bombing() {
		System.out.println(getName() + " >> 폭격");
	}
}
public class Exam2 {
	public static void main(String[] args) {
		Army a = new Army("육군");
		a.attack();
		a.tank();
		Navy n = new Navy("해군");
		n.attack();
		n.nucleus();
		AirForce af = new AirForce("공군");
		af.attack();
		af.bombing();
	}
}
