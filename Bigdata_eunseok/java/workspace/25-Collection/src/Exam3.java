import java.util.*;

public class Exam3 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("ȣ����");
		set.add("����");
		set.add("�⸰");
		set.add("ȣ����");
		set.add("�ڳ���");
		
		System.out.println(set.size());
		System.out.println();
		
		System.out.println(set.toString());
		System.out.println();
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		System.out.println();
		
		set.remove("ȣ����");
		System.out.println(set.toString());
		System.out.println();
		
		set.clear();
		System.out.println(set.toString());
		System.out.println();
	}
}
