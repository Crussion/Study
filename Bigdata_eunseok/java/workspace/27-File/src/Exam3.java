import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Exam3 {
	public static void main(String[] args) {
		String str = "가나다라마바사abcdefg";
		String path = "text3.txt";
		
		byte[] buf = null;
		try {
			buf = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		OutputStream out = null;
		try {
			out = new FileOutputStream(path);
			out.write(buf);
			System.out.println("파일 저장됨 >> " + path);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) out.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
