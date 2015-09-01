package study.dsa.algo.dp;

public class BitonicSubSeq {

	// https://www.youtube.com/watch?v=WxpIHvsu1RI&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=30

	// Find the length of max increasing-decreasing sequence

	public static void main(String[] args) {

		int[] ip = { 2, -1, 4, 3, 5, -1, 3, 2, 7 };
		int[] inorderSub = new int[ip.length];
		int[] reorderSub = new int[ip.length];

		longestIncreasingSubseq(ip, inorderSub);
		longestIncreasingSubseq(reverse(ip), reorderSub);

		int max = -Integer.MAX_VALUE;
		for (int i = 0; i < ip.length; i++)
			max = max < (inorderSub[i] + reorderSub[i] - 1) ? (inorderSub[i]
					+ reorderSub[i] - 1) : max;

		System.out.println(max);
	}

	private static int[] reverse(int[] ip) {
		int[] temp = new int[ip.length];
		for (int i = 0; i < ip.length / 2; i++) {
			temp[i] = ip[ip.length - i - 1];
			temp[ip.length - i - 1] = ip[i];
		}

		if (ip.length % 2 == 1)
			temp[ip.length / 2] = ip[ip.length / 2];

		return temp;
	}

	public static void longestIncreasingSubseq(int[] ip, int[] op) {
		for (int i = 0; i < ip.length; i++)
			op[i] = 1;

		for (int i = 1; i < ip.length; i++) {
			int j = 0;
			while (j < i) {
				if (ip[j] < ip[i]) {
					if (op[j] + 1 > op[i])
						op[i] = op[j] + 1;
				}
				j++;
			}

		}
	}
}
