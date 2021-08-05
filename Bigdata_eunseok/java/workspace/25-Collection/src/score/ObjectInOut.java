package score;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
	public boolean write(String fileName, List<ScoreVO> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		boolean result = false;
		
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			
			oos.writeInt(list.size());
			for(int i = 0; i < list.size(); i++) {
				ScoreVO vo = list.get(i);
				oos.writeObject(vo);
			}
			result = true;
			System.out.println("���� ���� ���� >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("���� ��θ� ã�� �� ���� >> " + fileName);
		} catch (IOException e) {
			System.out.println("���� ���� ���� >> " + fileName);
		} catch (Exception e) {
			System.out.println("�� �� ���� ���� >> " + fileName);
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
	
	public List<ScoreVO> read(String fileName){
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		

		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			int num = ois.readInt();
			for(int i = 0; i < num; i++) {
				ScoreVO vo = (ScoreVO)ois.readObject();
				list.add(vo);
			}
			System.out.println("���� �б� ���� >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("���� ��θ� ã�� �� ���� >> " + fileName);
		} catch (IOException e) {
			System.out.println("���� �б� ���� >> " + fileName);
		} catch (Exception e) {
			System.out.println("�� �� ���� ���� >> " + fileName);
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