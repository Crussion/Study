package customer;

import java.io.Serializable;

public class CustomerVO implements Serializable {
	private String num, name, phone;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		String str = String.format("%3s\t%3s\t%13s", num, name, phone);
		return str;
	}

}
