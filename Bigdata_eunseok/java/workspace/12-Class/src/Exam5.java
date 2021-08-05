class Member{
	String name;
	int age;
	
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	void say() {
		System.out.println(getName());
		System.out.println(getAge());
	}
}
public class Exam5 {
	public static void main(String[] args) {
		Member member = new Member();
		member.setName("ȫ�浿");
		member.setAge(20);
		member.say();
	}
}
