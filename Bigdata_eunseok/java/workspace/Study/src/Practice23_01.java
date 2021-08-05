
public class Practice23_01 {
	public static void main(String[] args) {
		String data = "D:/photo/2021/travel/food.jpg";
		
		String fileName = data.substring(data.lastIndexOf("/") + 1, data.lastIndexOf("."));
		String str = data.substring(data.lastIndexOf(".") + 1);
		String path = data.substring(0, data.lastIndexOf("/"));
		
		System.out.println(fileName);
		System.out.println(str);
		System.out.println(path);
	}
}
