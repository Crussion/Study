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
		Unit[] units = new Unit[5];
		
		units[0] = new AirForce("공군1호");
		units[1] = new AirForce("공군2호");
		units[2] = new Navy("해군1호");
		units[3] = new Army("육군1호");
		units[4] = new Army("육군2호");
		
		for(int i = 0; i < units.length; i++) {
			units[i].attack();
			
			if(units[i] instanceof Army) {
				Army a = (Army)units[i];
				a.tank();
			}else if(units[i] instanceof Navy) {
				Navy n = (Navy)units[i];
				n.nucleus();
			}else if(units[i] instanceof AirForce) {
				AirForce af = (AirForce)units[i];
				af.bombing();
			}
		}
	}
}
