import java.io.FileReader;
import java.io.FileWriter;

public class Exam2 {
	public static void main(String[] args) {
		String str = "�����ٶ󸶹ٻ�abcdefg";
		String path = "text2.txt";
		
		try {
			FileWriter fw = new FileWriter(path);
			fw.write(str);
			fw.close();
			System.out.println("���� ����");
		}catch(Exception e) {
			System.out.println("���� ���� ����");
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