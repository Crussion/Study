package sample9;

public class Engineer{
	private Emp emp;
	private String dept;
	
	public Engineer() {}

	public Engineer(Emp emp) {
		super();
		this.emp = emp;
	}
	
	public Engineer(Emp emp, String dept) {
		super();
		this.emp = emp;
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Engineer [" + emp + ", dept=" + dept + "]";
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	
}
