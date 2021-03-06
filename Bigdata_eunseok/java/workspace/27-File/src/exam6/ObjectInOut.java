package exam6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
	public boolean write(String fileName, List<StudentVO> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		boolean result = false;
		
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			oos.writeInt(list.size());
			for(int i = 0; i < list.size(); i++) {
				StudentVO vo = list.get(i);
				oos.writeObject(vo);
			}
			result = true;
			System.out.println("파일 저장 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("저장 경로를 찾을 수 없음 >> " + fileName);
		} catch (IOException e) {
			System.out.println("파일 저장 실패 >> " + fileName);
		} catch (Exception e) {
			System.out.println("알 수 없는 오류 >> " + fileName);
		} finally {
			try {
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<StudentVO> read(String fileName){
		List<StudentVO> list = new ArrayList<StudentVO>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		

		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			int num = ois.readInt();
			for(int i = 0; i < num; i++) {
				StudentVO vo = (StudentVO)ois.readObject();
				list.add(vo);
			}
			System.out.println("파일 읽기 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("저장 경로를 찾을 수 없음 >> " + fileName);
		} catch (IOException e) {
			System.out.println("파일 읽기 실패 >> " + fileName);
		} catch (Exception e) {
			System.out.println("알 수 없는 오류 >> " + fileName);
		} finally {
			try {
				if(ois != null) ois.close();
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
