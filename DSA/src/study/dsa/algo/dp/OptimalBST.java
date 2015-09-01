package study.dsa.algo.dp;

public class OptimalBST {

	// https://www.youtube.com/watch?v=hgA4xxlVvfQ&index=6&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&spfreload=10

	// hard

	public static void main(String[] args) {

		int nodes[] = { 10, 12, 16, 21 };
		int freqs[] = { 4, 2, 6, 3 };

		int[][] cost = new int[nodes.length][nodes.length];

		for (int i = 0; i < nodes.length; i++) {
			cost[i][i] = freqs[i];
		}

		for (int l = 2; l <= nodes.length; l++) {
			for (int i = 0; i <= nodes.length - l; i++) {
				int j = i + l - 1;

				cost[i][j] = Integer.MAX_VALUE;
				int sum = calSum(freqs, i, j);
				// Important loop
				for (int k = i; k <= j; k++) {
					int t_sum = sum + (k + 1 > j ? 0 : cost[k + 1][j])
							+ (k - 1 < i ? 0 : cost[i][k - 1]);

					if (cost[i][j] > t_sum)
						cost[i][j] = t_sum;
				}
			}
		}
		System.out.println(cost[0][nodes.length - 1]);
	}

	private static int calSum(int[] freqs, int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++)
			sum = sum + freqs[k];
		return sum;
	}
}
