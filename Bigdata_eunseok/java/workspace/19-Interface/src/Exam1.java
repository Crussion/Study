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
		System.out.println(name + " >> 공격");
		
	}@Override
	public void jump() {
		System.out.println(name + " >> 점프");
		
	}@Override
	public void pickup() {
		System.out.println(name + " >> 아이템획득");
		
	}@Override
	public void run() {
		System.out.println(name + " >> 뛰다");
		
	}@Override
	public void shield() {
		System.out.println(name + " >> 방어");
		
	}@Override
	public void walk() {
		System.out.println(name + " >> 걷다");
		
	}
}
class Monster implements Fight, Move{
	private String name;
	public Monster(String name) {
		this.name = name;
	}
	@Override
	public void attack() {
		System.out.println(name + " >> 공격했습니다.");
		
	}@Override
	public void jump() {
		System.out.println(name + " >> 점프를 합니다.");
		
	}@Override
	public void run() {
		System.out.println(name + " >> 달립니다.");
		
	}@Override
	public void shield() {
		System.out.println(name + " >> 방어했습니다.");
		
	}@Override
	public void walk() {
		System.out.println(name + " >> 걷습니다.");
		
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Character ch = new Character("주인공");
		ch.walk();
		ch.run();
		ch.attack();
		ch.shield();
		
		Monster mon = new Monster("악당");
		mon.walk();
		mon.run();
		mon.attack();
		mon.shield();
		
		Move move = new Character("둘리");
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
				System.out.println(" >> 점프");
				
			}
			@Override
			public void run() {
				System.out.println(" >> 뛰다");
				
			}@Override
			public void walk() {
				System.out.println(" >> 걷다");
				
			}
		};
		mv.walk();
		mv.run();
		mv.jump();
		
		Character cha = new Character("또치") {
			public void pickup() {
				System.out.println("또치 >> 둘리의 아이템을 가져오다.");
			}
		};
		
		cha.walk();
		cha.run();
		cha.attack();
		cha.shield();
		cha.pickup();
	}
}
