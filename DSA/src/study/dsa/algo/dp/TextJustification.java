package study.dsa.algo.dp;

public class TextJustification {

	// https://www.youtube.com/watch?v=RORuwHiblPc&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=4

	public static void main(String[] args) {

		/*
		 * 'Tushar Roy likes to code' {6 3 5 2 4}.
		 * 
		 * The monitor can display only 10 characters so we have to add spaces
		 * such that the spaces are evenly distributed.
		 * 
		 * Note : The spaces between the words are not considered.
		 */

		int[] ip = { 6, 3, 5, 2, 4 };
		int maxChar = 10;
		// We will find the cost for the displaying the letter.
		// Here, we use 2d matrix.
		// Entry i,j represents the cost of having words from i to j together on
		// single line.
		// eg 2,4 --> Having 'likes to code' together on single line
		// cost is evaluated as the square of number of white spaces on the
		// line.
		// 2->3 5+2 letters +1 space --> cost = (10-(5+2+1))^2 = 1.
		//
		int[][] cost = new int[ip.length][ip.length];
		for (int i = 0; i < ip.length; i++) {
			for (int j = i; j < ip.length; j++) {
				int temp = maxChar;
				if (i == j) {
					cost[i][j] = (int) Math.pow(maxChar - ip[i], 2);
					continue;
				}
				for (int k = i; k <= j; k++) {
					temp = temp - ip[k];
				}
				temp = temp - (j - i);
				if (temp < 0) {
					for (int k = j; k < ip.length; k++)
						cost[i][k] = Integer.MAX_VALUE;
					break;
				} else
					cost[i][j] = (int) Math.pow(temp, 2);
			}
		}

		/*
		 * for (int i = 0; i < ip.length; i++) { for (int j = 0; j < ip.length;
		 * j++) { System.out.print(cost[i][j] + " "); } System.out.println(); }
		 */

		//
		int[] eCost = new int[ip.length];
		int[] split = new int[ip.length];

		int i, j;
		i = j = ip.length - 1;

		while (i >= 0) {
			if (cost[i][j] != Integer.MAX_VALUE) {
				eCost[i] = cost[i][j];
				split[i] = j + 1;
				i--;
			} else {
				int splitAt = j;
				int splitCost = Integer.MAX_VALUE;
				for (int k = j; k > i; k--) {
					if (cost[i][k - 1] == Integer.MAX_VALUE)
						continue;
					int costV = cost[i][k - 1] + eCost[k];
					if (costV < splitCost) {
						splitCost = costV;
						splitAt = k;
					}
				}
				eCost[i] = splitCost;
				split[i] = splitAt;
				i--;
				j = ip.length - 1;
			}
		}

		for (i = 0; i < ip.length; i++) {
			System.out.println(eCost[i] + " " + split[i]);
		}

	}
}
