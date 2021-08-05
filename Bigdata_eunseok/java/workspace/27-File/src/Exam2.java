import java.io.FileReader;
import java.io.FileWriter;

public class Exam2 {
	public static void main(String[] args) {
		String str = "가나다라마바사abcdefg";
		String path = "text2.txt";
		
		try {
			FileWriter fw = new FileWriter(path);
			fw.write(str);
			fw.close();
			System.out.println("파일 생성");
		}catch(Exception e) {
			System.out.println("파일 생성 실패");
			e.printStackTrace();
		}
		
		try {
			FileReader fr = new FileReader(path);
			int data = 0;
			String result = "";
			while(true) {
				data = fr.read();
				if(data == -1) break;
				result += (char)data;
			}
			System.out.println(result);
			fr.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
