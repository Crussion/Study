class Salary{
	String name;
	int salary;
	public Salary(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	void viewInformation() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + salary);
	}
}
class Department extends Salary{
	String department;
	public Department(String name, int salary, String department){
		super(name, salary);
		this.department = department;
	}
	void viewInformation() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + salary);
		System.out.println("�μ� : " + department);
	}
}
public class Practice16_01 {
	public static void main(String[] args) {
		Department ob = new Department("��ȣ��", 85000000, "���ߺ�");
		ob.viewInformation();
	}
}
