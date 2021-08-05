import java.util.ArrayList;
import java.util.List;

public class Exam2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		
		System.out.println(list.size());
		
		System.out.println(list.get(3));
		
		list.set(4, 500);
		System.out.println(list.get(4));
		
		list.add(2, 100);
		System.out.println();
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		list.remove(5);
		System.out.println();
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		list.sort(null);
		System.out.println();
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		
		list.clear();
		System.out.println();
		System.out.println(list.size());
		
	}
}
