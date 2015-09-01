package study.dsa.tree;

public class SharesBuySell {

	// Design an algorithm to find the maximum profit. You may complete as many
	// transactions as you like (ie, buy one and sell one share of the stock
	// multiple times). However, you may not engage in multiple transactions at
	// the same time (ie, you must sell the stock before you buy again).

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr ={100, 180, 260, 310, 40, 535, 695};

		int j = 0;
		int k = 0, max = 0;
		int s = arr[0];
		int b = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max == 0 && i > 0 && arr[i] < arr[i - 1]) {
				b++;
				continue;
			}
			if (arr[i] >= max) {
				max = arr[i];
			} else {
				max = 0;
				s = i - 1;
				System.out.println("stock bought on " + (b + 1)
						+ " and stock sold on " + (s + 1));
				b = i;
			}
		}

		if (max > 0)
			System.out.println("stock bought on " + (b + 1)
					+ " and stock sold on " + arr.length);
	}
}
