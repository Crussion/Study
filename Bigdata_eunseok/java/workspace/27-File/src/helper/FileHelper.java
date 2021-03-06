package helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class FileHelper {
	private static FileHelper instance;
	public static FileHelper getInstance() {
		if(instance == null) instance = new FileHelper();
		return instance;
	}
	
	/**
	 * 문자열을 byte[]로 변환한 뒤, 파일에 저장.
	 * @param filePath : 저장할 파일 경로
	 * @param content : 저장할 내용
	 * @param encType : 인코딩 형식
	 * @return boolean : 성공시 true, 실패시 false
	 */
	public boolean writeFile(String filePath, String content, String encType) {
		boolean result = false;
		byte[] buf = null;
		try {
			buf = content.getBytes(encType);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		OutputStream out = null;
		try {
			out = new FileOutputStream(filePath);
			out.write(buf);
			System.out.println("파일 저장됨 >> " + filePath);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null) out.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * 파일의 내용을 문자열로 리턴한다.
	 * @param filePath : 읽어야할 파일의 경로
	 * @param encType : 인코딩 형식
	 * @return String : 읽은 내용에 대한 문자열
	 */
	public String readFile(String filePath, String encType) {
		byte[] data = null;
		String result = null;
		
		InputStream in = null;
		try {
			in = new FileInputStream(filePath);
			data = new byte[in.available()];
			in.read(data);
			System.out.println("파일 불러옴 >> " + filePath);
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
				result = new String(data, encType);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
