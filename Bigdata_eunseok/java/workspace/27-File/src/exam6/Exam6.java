package exam6;

import java.util.ArrayList;
import java.util.List;

public class Exam6 {
	public static void main(String[] args) {
		List<StudentVO> list = new ArrayList<StudentVO>();
		
		list.add(new StudentVO("ȫ�浿", 25, "����"));
		list.add(new StudentVO("��浿", 27, "����"));
		list.add(new StudentVO("��ö��", 23, "���"));
		list.add(new StudentVO("�̿���", 23, "����"));
		
		ObjectInOut oio = new ObjectInOut();
		
		oio.write("student.txt", list);
		
		list = oio.read("student.txt");
		
		for(int i = 0; i < list.size(); i++) {
			StudentVO vo = list.get(i);
			System.out.println(vo.toString());
		}
	}
}
