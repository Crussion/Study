interface Action{
	public void pickup();
}
interface Fight{
	public void attack();
	public void shield();
}
interface Move{
	public void walk();
	public void run();
	public void jump();
}
class Character implements Action, Move, Fight{
	private String name;
	public Character(String name) {
		this.name = name;
	}
	@Override
	public void attack() {
		System.out.println(name + " >> ����");
		
	}@Override
	public void jump() {
		System.out.println(name + " >> ����");
		
	}@Override
	public void pickup() {
		System.out.println(name + " >> ������ȹ��");
		
	}@Override
	public void run() {
		System.out.println(name + " >> �ٴ�");
		
	}@Override
	public void shield() {
		System.out.println(name + " >> ���");
		
	}@Override
	public void walk() {
		System.out.println(name + " >> �ȴ�");
		
	}
}
class Monster implements Fight, Move{
	private String name;
	public Monster(String name) {
		this.name = name;
	}
	@Override
	public void attack() {
		System.out.println(name + " >> �����߽��ϴ�.");
		
	}@Override
	public void jump() {
		System.out.println(name + " >> ������ �մϴ�.");
		
	}@Override
	public void run() {
		System.out.println(name + " >> �޸��ϴ�.");
		
	}@Override
	public void shield() {
		System.out.println(name + " >> ����߽��ϴ�.");
		
	}@Override
	public void walk() {
		System.out.println(name + " >> �Ƚ��ϴ�.");
		
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Character ch = new Character("���ΰ�");
		ch.walk();
		ch.run();
		ch.attack();
		ch.shield();
		
		Monster mon = new Monster("�Ǵ�");
		mon.walk();
		mon.run();
		mon.attack();
		mon.shield();
		
		Move move = new Character("�Ѹ�");
		move.walk();
		move.jump();
		move.run();
		
		Action action = (Action)move;
		action.pickup();
		
		Fight fight = (Fight)action;
		fight.attack();
		fight.shield();
		
		Move mv = new Move() {
			public void jump() {
				System.out.println(" >> ����");
				
			}
			@Override
			public void run() {
				System.out.println(" >> �ٴ�");
				
			}@Override
			public void walk() {
				System.out.println(" >> �ȴ�");
				
			}
		};
		mv.walk();
		mv.run();
		mv.jump();
		
		Character cha = new Character("��ġ") {
			public void pickup() {
				System.out.println("��ġ >> �Ѹ��� �������� ��������.");
			}
		};
		
		cha.walk();
		cha.run();
		cha.attack();
		cha.shield();
		cha.pickup();
	}
}
