
public class Exam5 {
	
	public static void main(String[] args) {
		String[] sc = {"가", "2", "aaa", "ccc"};
		int[] arr = new int[3];
		
		try {
			for(int i = 0; i < sc.length; i++) {
				arr[i] = Integer.parseInt(sc[i]);
			}
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("데이터 변환 종료");
		}
	}
}
