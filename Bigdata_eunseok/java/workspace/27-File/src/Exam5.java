import helper.*;

public class Exam5 {
	public static void main(String[] args) {
		FileHelper f = FileHelper.getInstance();
		String encType = "UTF-8";
		String filePath = "myfile.txt";
		String content = "안녕하세요. 자바 프로그래밍";
		boolean result = f.writeFile(filePath, content, encType);
		
		if(!result) {
			System.out.println("파일 저장에 실패했습니다.");
			return;
		}
		
		String read_str = f.readFile(filePath, encType);
		System.out.println(read_str);
	}
}
