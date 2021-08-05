import java.util.Scanner;

class EmpVO{
	private String name;
	private int salary;
	private String department;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmpVO [�̸�=" + name + ", ����=" + salary + ", �μ�=" + department + "]";
	}
	public EmpVO(String name, int salary, String department) {
		super();
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	public EmpVO() {}
}

class Controller{
	EmpVO[] emp = new EmpVO[5];
	int n = 0;
	void input() {
		Scanner s = new Scanner(System.in);
		System.out.print("�̸� : ");
		String name = s.next();
		System.out.print("���� : ");
		int salary = s.nextInt();
		System.out.print("�μ� : ");
		String department = s.next();
		emp[n] = new EmpVO(name, salary, department);
		n++;
	}
	void output() {
		for(int i = 0; i < n; i++) {
			System.out.println(emp[i].toString());
		}
		System.out.println();
	}
}

public class Practice17_02 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Controller control = new Controller();
		while(true) {
			System.out.printf("1. �Է�\n"
							+ "2. ���\n"
							+ "3. ����\n"
							+ "-----------\n"
							+ "��ȣ �Է� : ");
			char c = s.next().charAt(0);
			System.out.println();
			if(c == '1') {
				control.input();
			}else if(c == '2') {
				control.output();
			}else if(c == '3') {
				System.out.println("���α׷� ����");
				break;
			}
			System.out.println();
		}
	}
}
