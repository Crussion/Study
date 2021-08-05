import java.util.*;

public class Exam3 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		
		set.add("È£¶ûÀÌ");
		set.add("»çÀÚ");
		set.add("±â¸°");
		set.add("È£¶ûÀÌ");
		set.add("ÄÚ³¢¸®");
		
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
		
		set.remove("È£¶ûÀÌ");
		System.out.println(set.toString());
		System.out.println();
		
		set.clear();
		System.out.println(set.toString());
		System.out.println();
	}
}
