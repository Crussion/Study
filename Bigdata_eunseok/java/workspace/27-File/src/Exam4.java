import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Exam4 {
	public static void main(String[] args) {
		String path = "text3.txt";
		byte[] data = null;
		String result = null;
		
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			data = new byte[in.available()];
			in.read(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(data != null) {
			try {
				result = new String(data, "utf-8");
				System.out.println(result);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	}
}
