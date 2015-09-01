package study.math.problems;

public class UpperTriangularMatrix {

	public static void main(String[] args) {
		int[][] temp = new int[4][4];
		int c = 1;
		int i = 1, j = 0;
		while (i < 4) {
			for (j = 0; j < 4 - i; j++) {
				temp[j][i + j] = c++;
			}
			i++;
		}

		for (i = 0; i < 4; i++) {
			System.out.println();
			for (j = 0; j < 4; j++) {
				System.out.print(temp[i][j] + " ");
			}
		}

	}
}
