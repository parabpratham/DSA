package study.dsa.algo.dp;

public class RodCurring {

	// https://www.youtube.com/watch?v=IRwVmTmN6go&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=31

	// Cutting Rod dynamic programming

	public static void main(String[] args) {

		int[] size = { 1, 2, 3, 4 };
		int[] profit = { 2, 5, 7, 8 };

		int maxLength = 5;

		int[][] maxPro = new int[size.length][maxLength + 1];

		for (int i = 0; i < size.length; i++)
			maxPro[i][0] = 0;

		for (int i = 0; i < size.length; i++) {
			int sizeTillNow = 0;
			for (int j = 1; j <= maxLength; j++) {

				if (i == 0 || sizeTillNow < i) {
					maxPro[i][j] = i == 0 ? profit[i] * j : maxPro[i][j]
							+ maxPro[i - 1][j];
				} else {
					maxPro[i][j] = Math.max(maxPro[i - 1][j], maxPro[i][j]
							+ profit[i]);
				}
				sizeTillNow++;
			}
		}

		System.out.println(maxPro[size.length - 1][maxLength]);
	}

}
