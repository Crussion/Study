import study.Article;
public class Exam1 {
	public static void main(String[] args) {
		Article.setCategory("자유게시판");
		Article a1 = new Article(1, "첫번째 글 제목입니다", "2021-07-01");
		Article a2 = new Article(2, "두번째 글 제목입니다", "2021-07-03");
		Article a3 = new Article(3, "세번째 글 제목입니다", "2021-07-05");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3.toString());
		
		System.out.println();
		
		Article.setCategory("공지사항");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3.toString());
	}
}
