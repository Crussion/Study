package customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CustomerImpl extends Customer{
	List<CustomerVO> list = new ArrayList<CustomerVO>();
	Scanner s = new Scanner(System.in);
	void input() {
		CustomerVO vo = new CustomerVO();
		System.out.print("����ȣ : ");
		vo.setNum(s.next());
		System.out.print("��   �� : ");
		vo.setName(s.next());
		System.out.print("��ȭ��ȣ : ");
		vo.setPhone(s.next());
		
		list.add(vo);
	}
	void print() {
		printTitle();
		for(int i = 0; i < list.size(); i++) {
			CustomerVO vo = list.get(i);
			System.out.println(vo.toString());
		}
		Comparator<CustomerVO> comp = new Comparator<CustomerVO>() {
			
			@Override
			public int compare(CustomerVO vo1, CustomerVO vo2) {
				return vo1.getNum().compareTo(vo2.getNum());
			}
		};
	}
	void printTitle() {
		String str = String.format("%3s\t%3s\t%11s", "��ȣ", "�̸�", "��ȭ��ȣ");
		System.out.println(str);
	}
	void serchNum() {
		System.out.print("�˻��� ����ȣ? ");
		String n = s.next();
		printTitle();
		for(int i = 0; i < list.size(); i++) {
			CustomerVO vo = list.get(i);
			if(n.equals(vo.getNum())) {
				System.out.println(vo.toString());
			}
		}
	}
	void serchName() {
		System.out.print("�˻��� �̸�? ");
		String n = s.next();
		printTitle();
		for(int i = 0; i < list.size(); i++) {
			CustomerVO vo = list.get(i);
			if(n.equals(vo.getName())) {
				System.out.println(vo.toString());
			}
		}
	}
	void serchPhone() {
		System.out.print("�˻��� ��ȭ��ȣ? ");
		String n = s.next();
		printTitle();
		for(int i = 0; i < list.size(); i++) {
			CustomerVO vo = list.get(i);
			if(n.equals(vo.getPhone())) {
				System.out.println(vo.toString());
			}
		}
	}
	void descSortName() {
		Comparator<CustomerVO> comp = new Comparator<CustomerVO>() {
			@Override
			public int compare(CustomerVO vo1, CustomerVO vo2) {
				return vo1.getName().compareTo(vo2.getName());
			}
		};
		Collections.sort(list, comp);
		print();
	}

	void ascSortNum() {
		Comparator<CustomerVO> comp = new Comparator<CustomerVO>() {
			
			@Override
			public int compare(CustomerVO vo1, CustomerVO vo2) {
				return vo2.getNum().compareTo(vo1.getNum());
			}
		};
		
		Collections.sort(list, comp);
		print();
	}
	
	@Override
	public void saveFile() {
		ObjectInOut inout = new ObjectInOut();
		inout.write("customer.txt", list);
	}
	
	@Override
	public void loadFile() {
		ObjectInOut inout = new ObjectInOut();
		list = inout.read("customer.txt");
	}
}
