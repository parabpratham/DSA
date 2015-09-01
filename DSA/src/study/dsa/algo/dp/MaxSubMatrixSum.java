package study.dsa.algo.dp;

import study.dsa.algo.dp.SubSetKadaneAlgo.Outcome;

public class MaxSubMatrixSum {

	
	/*
	 * https://www.youtube.com/watch?v=yCQN096CwWM&list=
	 * PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=5
	 */

	public static void main(String[] args) {

		int[][] ip = { { 1, -3, -4, 5 }, { 6, 3, 4, 1 },
				{ -2, -1, 4, -5 }, { 3, 1, 0, 3 } };

		int[] calc = new int[ip.length];

		int currSum = 0;
		int maxSum = -Integer.MAX_VALUE;
		int left = -1, right = -1, up = -1, down = -1;

		for (int l = 0; l < ip[0].length; l++) {
			for (int i = 0; i < ip.length; i++)
				calc[i] = 0;

			for (int r = 0; r < ip[0].length; r++) {
				// copy column to the array
				for (int i = 0; i < ip.length; i++) {
					calc[i] = calc[i] + ip[i][r];
				}
				Outcome outcome = kadaneAlgo(calc);
				currSum = outcome.sum;
				if (currSum > maxSum) {
					left = l;
					right = r;
					up = outcome.left;
					down = outcome.right;
					maxSum = currSum;
				}

			}
		}

		System.out.println(maxSum + " ( " + left + " , " + up + " ) (" + right
				+ " , " + down + " )");
	}

	public static SubSetKadaneAlgo.Outcome kadaneAlgo(int[] ip) {
		SubSetKadaneAlgo s = new SubSetKadaneAlgo();
		Outcome curr = s.new Outcome();
		Outcome maxsum = s.new Outcome();
		curr.sum = 0;
		curr.left = 0;
		for (int i = 0; i < ip.length; i++) {
			if (curr.sum < 0) {
				curr.sum = ip[i];
				curr.left = i;
				curr.right = i;
			} else {
				curr.sum = curr.sum + ip[i];
				curr.right = i;
			}
			if (maxsum.sum < curr.sum) {
				maxsum.sum = curr.sum;
				maxsum.left = curr.left;
				maxsum.right = curr.right;
			}
		}
		return maxsum;
	}
}
