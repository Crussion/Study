class Address{
	String name;
	String phon_num;
	String adres;
	public Address(String name, String phon_num, String adres) {
		this.name = name;
		this.phon_num = phon_num;
		this.adres = adres;
	}
	
	public void showAddress() {
		System.out.println(name);
		System.out.println(phon_num);
		System.out.println(adres);
	}
}
public class Practice13_02 {
	public static void main(String[] args) {
		Address adr = new Address("홍길동", "010-1234-5678", "서울시");
		adr.showAddress();
	}
}
