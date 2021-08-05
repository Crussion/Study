
public class Exam1 {
	public static void main(String[] args) {
		String str1 = "자바 Programming";
		String str2 = "Java";
		
		System.out.println(str1.length());
		System.out.println(str2.length());
		System.out.println();
		
		System.out.println(str1.indexOf(" "));
		System.out.println(str2.indexOf("a"));
		System.out.println();
		
		System.out.println(str1.lastIndexOf("r"));
		System.out.println(str2.lastIndexOf("a"));
		System.out.println();
		
		System.out.println(str1.replace(" ", "_"));
		System.out.println(str2.replace("a", "A"));
		System.out.println();
		
		System.out.println(str1.toUpperCase());
		System.out.println(str2.toLowerCase());
		System.out.println();
		
		String str3 = "      enjoy java programming            ";
		System.out.println(str3.trim());
		System.out.println(str3.replace(" ", ""));
		System.out.println();
		
		System.out.println(str1.equals(str2));
		System.out.println();
		
		System.out.println(str1.substring(0, 2));
		System.out.println(str2.substring(0, 2));
		System.out.println(str1.substring(3));
		System.out.println();
		
		System.out.println(String.format("%d년 %02d월 %02d일 %s", 2021, 7, 8, "목요일"));
		System.out.println();
		
		String[] str = "C++/Java/C#/Javascript/Python".split("/");
		
		for(int i = 0; i < str.length; i++)
			System.out.print(str[i] + " ");
		System.out.println();
	}
}
