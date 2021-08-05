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
	 * ���ڿ��� byte[]�� ��ȯ�� ��, ���Ͽ� ����.
	 * @param filePath : ������ ���� ���
	 * @param content : ������ ����
	 * @param encType : ���ڵ� ����
	 * @return boolean : ������ true, ���н� false
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
			System.out.println("���� ����� >> " + filePath);
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
	 * ������ ������ ���ڿ��� �����Ѵ�.
	 * @param filePath : �о���� ������ ���
	 * @param encType : ���ڵ� ����
	 * @return String : ���� ���뿡 ���� ���ڿ�
	 */
	public String readFile(String filePath, String encType) {
		byte[] data = null;
		String result = null;
		
		InputStream in = null;
		try {
			in = new FileInputStream(filePath);
			data = new byte[in.available()];
			in.read(data);
			System.out.println("���� �ҷ��� >> " + filePath);
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