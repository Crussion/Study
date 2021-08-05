import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Exam1 {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("aaa", 111);
		map.put("bbb", 222);
		map.put("aaa", 444);
		map.put("ccc", 333);
		map.put("ccc", null);
		
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		
		System.out.println(map.size());
		
		map.remove("aaa");
		System.out.println(map.size());
		
		System.out.println(map.get("aaa"));
		
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.print(key + " : " + map.get(key));
			System.out.println();
		}
	}
}
