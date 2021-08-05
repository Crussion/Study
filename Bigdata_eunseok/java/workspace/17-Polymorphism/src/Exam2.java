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
		Unit[] units = new Unit[5];
		
		units[0] = new AirForce("����1ȣ");
		units[1] = new AirForce("����2ȣ");
		units[2] = new Navy("�ر�1ȣ");
		units[3] = new Army("����1ȣ");
		units[4] = new Army("����2ȣ");
		
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
