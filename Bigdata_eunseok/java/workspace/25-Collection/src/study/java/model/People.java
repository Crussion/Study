package study.java.model;

public class People {
	private String name;
	private String phone_num;
	public People() {}
	public People(String name, String phone_num) {
		super();
		this.name = name;
		this.phone_num = phone_num;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", phone_num=" + phone_num + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
}
