
public class Practice10_5 {
	public static void main(String[] args) {
		int[][] num = {{1,2,3,0}, {4,5,6,0}, {7,8,9,0}, {0,0,0,0}};
		int sum1, sum2, sum3 = 0;
		for(int i = 0; i < num.length; i++) {
			sum1 = 0;
			sum2 = 0;
			for(int j = 0; j < num[i].length; j++) {
				if(j != num[i].length - 1) {
					sum1 += num[i][j];
					sum2 += num[j][i];
					if(i == j)
						sum3 += num[i][j];
				}else {
					num[i][j] = sum1;
					num[j][i] = sum2;
				}
			}
		}
		num[num.length - 1][num[0].length - 1] = sum3;
		
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++)
				System.out.printf("%2d ", num[i][j]);
			System.out.println();
		}
	}
}
