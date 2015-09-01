package study.dsa.algo.dp;

public class MaximumSumSubseqNonAdjucent {

	// https://www.youtube.com/watch?v=UtGtF6nc35g&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=8

	// Find maximum sum such that adjacent numbers are not chosen

	public static void main(String[] args) {

		int[] ip = { 4, 1, 1, 4, 2, 1 };

		int ex = ip[0];
		int in = ip[0];

		for (int i = 1; i < ip.length; i++) {
			int curr = Math.max(in, ex + (i == 1 ? 0 : ip[i]));
			ex = in;
			in = curr;
		}
		System.out.println(Math.max(ex, in));
	}

}
