import helper.*;

public class Exam5 {
	public static void main(String[] args) {
		FileHelper f = FileHelper.getInstance();
		String encType = "UTF-8";
		String filePath = "myfile.txt";
		String content = "�ȳ��ϼ���. �ڹ� ���α׷���";
		boolean result = f.writeFile(filePath, content, encType);
		
		if(!result) {
			System.out.println("���� ���忡 �����߽��ϴ�.");
			return;
		}
		
		String read_str = f.readFile(filePath, encType);
		System.out.println(read_str);
	}
}
