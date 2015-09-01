package study.dsa.algo.dp;

public class Knapsack01 {

	public class Sack {
		int weight;
		int value;

		public Sack(int wt, int va) {
			weight = wt;
			value = va;

		}
	}

	public static void main(String[] args) {

		Knapsack01 k = new Knapsack01();

		Sack[] sacks = new Sack[4];

		sacks[0] = k.new Sack(2, 5);
		sacks[1] = k.new Sack(3, 4);
		sacks[2] = k.new Sack(4, 3);
		sacks[3] = k.new Sack(5, 7);
		sacks[3] = k.new Sack(1, 7);

		int totalWeight = 10;

		int[][] calc = new int[sacks.length][totalWeight + 1];

		for (int sackNo = 0; sackNo < sacks.length; sackNo++) {
			Sack current = sacks[sackNo];
			for (int wt = 0; wt <= totalWeight; wt++) {
				if (wt < current.weight) {
					if (sackNo == 0) {
						calc[sackNo][wt] = 0;
					} else
						calc[sackNo][wt] = calc[sackNo - 1][wt];
				} else {
					/*
					 * Two choices 1. add current sack 2. Not include current
					 * sack
					 * 
					 * Decision is based upon who is maximum between the
					 * current's val + value of sack after removing currents
					 * weight or continuing with the previous val calculated
					 */

					if (sackNo == 0) {
						calc[sackNo][wt] = current.value;
					} else {
						int valueAfterAdding = current.value
								+ calc[sackNo - 1][wt - current.weight];
						calc[sackNo][wt] = Math.max(calc[sackNo - 1][wt],
								valueAfterAdding);
					}
				}
			}
		}

		System.out.println("Weight " + calc[sacks.length - 1][totalWeight - 1]);

		int row = sacks.length - 1;
		int col = totalWeight;

		int max = calc[row][col];
		while (max > 0) {
			if (row == 0) {
				max = max - sacks[row].value;
				System.out.print("(" + sacks[row].weight + ","
						+ sacks[row].value + ") -- ");
				break;

			} else if (calc[row][col] == calc[row - 1][col]) {
				row = row - 1;
			} else {
				System.out.print("(" + sacks[row].weight + ","
						+ sacks[row].value + ") -- ");
				max = max - sacks[row].value;
				row = row - 1;
				col = col - sacks[row].weight;
			}
		}
	}
}
