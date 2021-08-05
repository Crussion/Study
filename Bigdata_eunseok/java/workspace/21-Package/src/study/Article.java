package study;

public class Article {
	private static int count = 0;
	private static String category;
	
	private int num;
	private String title;
	private String regDate;
	public Article(int num, String title, String regDate) {
		super();
		this.num = num;
		this.title = title;
		this.regDate = regDate;
		
		Article.count++;
	}
	@Override
	public String toString() {
		return "글 분류 = " + Article.category + ", 전체 글 수 = " + Article.count + ", [num=" + num + ", title=" + title + ", regDate=" + regDate + "]";
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Article.count = count;
	}
	public static String getCategory() {
		return category;
	}
	public static void setCategory(String category) {
		Article.category = category;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
