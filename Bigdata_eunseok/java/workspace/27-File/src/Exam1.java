import java.io.File;

public class Exam1 {
	public static void main(String[] args) throws Exception{
		File f = new File("src/test.txt");
		System.out.println(f);
		System.out.println();
		
		System.out.println(f.isFile());
		System.out.println();
		
		System.out.println(f.isDirectory());
		System.out.println();
		
		System.out.println(f.isHidden());
		System.out.println();
		
		System.out.println(f.exists());
		System.out.println();
		
		try {
			f.createNewFile();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(f.exists());
		System.out.println();
		
		f.delete();
		
		System.out.println(f.exists());
		System.out.println();
		
		File folder = new File("a/b/c/target");
		System.out.println("isFile : " + folder.isFile());
		System.out.println("isDir : " + folder.isDirectory());
		System.out.println("isHidden : " + folder.isHidden());
		System.out.println("exists : " + folder.exists());
		System.out.println("절대경로 : " + folder.getAbsolutePath());
		System.out.println();
		
		folder.mkdirs();
		System.out.println("isFile : " + folder.isFile());
		System.out.println("isDir : " + folder.isDirectory());
		System.out.println("isHidden : " + folder.isHidden());
		System.out.println("exists : " + folder.exists());
		System.out.println("절대경로 : " + folder.getAbsolutePath());
		System.out.println();
		
		System.out.println(f.getName());
		System.out.println(folder.getParent());
		System.out.println();
		
		if(folder.delete()) {
			System.out.println("폴더 삭제 성공");
		}else {
			System.out.println("폴더 삭제 실패");
		}
	}
}
