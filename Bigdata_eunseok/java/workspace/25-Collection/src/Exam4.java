import java.util.*;
import study.java.model.People;

public class Exam4 {
	public static void main(String[] args) {
		List<People> list = new ArrayList<>();
		
		People p1 = new People("È«±æµ¿", "010-1234-5678");
		list.add(p1);
		People p2 = new People("±èÃ¶¼ö", "010-2345-6789");
		list.add(p2);
		People p3 = new People("È«±æµ¿", "010-3456-7890");
		list.add(p3);
		People p4 = new People("È«±æµ¿", "010-0987-6543");
		list.add(p4);
	}
}
