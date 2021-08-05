package exam6;

import java.util.ArrayList;
import java.util.List;

public class Exam6 {
	public static void main(String[] args) {
		List<StudentVO> list = new ArrayList<StudentVO>();
		
		list.add(new StudentVO("È«±æµ¿", 25, "¼ö¿ø"));
		list.add(new StudentVO("°í±æµ¿", 27, "ÀåÈï"));
		list.add(new StudentVO("±èÃ¶¼ö", 23, "¿ï»ê"));
		list.add(new StudentVO("ÀÌ¿µÈñ", 23, "°­¸ª"));
		
		ObjectInOut oio = new ObjectInOut();
		
		oio.write("student.txt", list);
		
		list = oio.read("student.txt");
		
		for(int i = 0; i < list.size(); i++) {
			StudentVO vo = list.get(i);
			System.out.println(vo.toString());
		}
	}
}
