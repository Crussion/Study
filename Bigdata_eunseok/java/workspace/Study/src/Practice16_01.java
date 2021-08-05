class Salary{
	String name;
	int salary;
	public Salary(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	void viewInformation() {
		System.out.println("이름 : " + name);
		System.out.println("연봉 : " + salary);
	}
}
class Department extends Salary{
	String department;
	public Department(String name, int salary, String department){
		super(name, salary);
		this.department = department;
	}
	void viewInformation() {
		System.out.println("이름 : " + name);
		System.out.println("연봉 : " + salary);
		System.out.println("부서 : " + department);
	}
}
public class Practice16_01 {
	public static void main(String[] args) {
		Department ob = new Department("강호동", 85000000, "개발부");
		ob.viewInformation();
	}
}
