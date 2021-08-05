import java.util.Random;
import java.util.Scanner;

public class Lotto {
	int[] m;
	int buyNum;
	
	Lotto(){
		m = new int[6];
	}
	
	void inputBuyNum() {
		Scanner s = new Scanner(System.in);
		System.out.print("구매횟수를 입력하세요 : ");
		buyNum = s.nextInt();
		System.out.println();
	}
	
	void selectLotto() {
		boolean chk = true;
		Random ran = new Random();
		ran.setSeed(System.currentTimeMillis());
		int temp;
		for(int i = 0; i < m.length; i++) {
			while(true) {
				chk = true;
				temp = ran.nextInt(45) + 1;
				for(int j = 0; j < m.length; j++) {
					if(temp == m[j]) chk = false;
				}
				if(chk) break;
			}
			m[i] = temp;
		}
	}
	
	void sort() {
		for(int i = 0; i < m.length - 1; i++) {
			for(int j = i + 1; j < m.length; j++) {
				if(m[i] > m[j]) {
					int temp = m[i];
					m[i] = m[j];
					m[j] = temp;
				}
			}
		}
	}
	
	void outputResult() {
		for(int n = 0; n < buyNum; n++) {
			selectLotto();
			sort();
			for(int i = 0; i < m.length; i++) {
				System.out.printf("%2d ", m[i]);
			}
			System.out.println();
		}
	}
}
