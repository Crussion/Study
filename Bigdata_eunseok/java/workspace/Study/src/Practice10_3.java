import java.util.Scanner;
public class Practice10_3 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[] score = new int[5];
		
		for(int i = 0; i < score.length; i++) {
			System.out.printf("%d번 점수 입력 : ", i+1);
			score[i] = s.nextInt();
		}

		int[] rank = new int[5];
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score.length; j++) {
				if(i != j) {
					if(score[i] < score[j]) rank[i]++;
					else if(score[i] > score[j]) rank[i]--;
					else rank[i] -= 2;
				}
			}
		}
		for(int i = 0; i < score.length; i++)
			System.out.println(score[i] + "점 : " + (3 + rank[i] / 2) + "등");
	}
}
