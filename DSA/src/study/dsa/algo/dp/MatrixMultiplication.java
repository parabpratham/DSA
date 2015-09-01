package study.dsa.algo.dp;

public class MatrixMultiplication {

	public static void main(String[] args) {
		int[] p = { 35, 15, 5, 10, 20, 25 };
		int[][] m = new int[10][10];
		int[][] s = new int[10][10];
		int n = p.length;

		for (int i = 0; i < n; i++)
			m[i][i] = 0;

		for (int l = 2; l < n; l++)
			for (int i = 1; i <= n - l + 1; i++) {
				int j = i + l - 1;
				m[i][j] = 99999999;
				for (int k = i; k <= j - 1; k++) {
					int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[l];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}

		for (int i = 0; i < n; i++) {
			for (int l = 0; l < n; l++) {
				System.out.print(m[i][l] + " ");
			}
			System.out.println();
		}
	}
}
