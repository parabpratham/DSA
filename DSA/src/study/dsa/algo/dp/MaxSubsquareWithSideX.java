package study.dsa.algo.dp;

public class MaxSubsquareWithSideX {

	// Maximum Subsquare With Sides as X

	// https://www.youtube.com/watch?v=vi_1eHCsR9A&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=9

	public class Detail {
		int x;
		int y;

		@Override
		public String toString() {
			return "( " + x + "," + y + " )";
		}
	}

	public static void main(String[] args) {

		MaxSubsquareWithSideX x = new MaxSubsquareWithSideX();

		int[][] ip = /*
					 * { { 1, 1, 1, 0, 1 }, { 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1
					 * }, { 1, 1, 1, 0, 1 }, { 0, 0, 1, 1, 1 } };
					 */
		{ { 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1 } };

		Detail[][] op = new Detail[ip.length][ip[0].length];

		for (int i = 0; i < ip.length; i++) {
			Detail d = x.new Detail();
			d.x = ip[i][0] == 0 ? 0 : i == 0 ? 1 : op[i - 1][0].x + 1;
			d.y = ip[i][0];
			op[i][0] = d;
		}

		for (int i = 0; i < ip[0].length; i++) {
			Detail d = x.new Detail();
			d.x = ip[0][i];
			d.y = ip[0][i] == 0 ? 0 : i == 0 ? 1 : op[0][i - 1].y + 1;
			op[0][i] = d;
		}

		for (int i = 1; i < ip.length; i++)
			for (int j = 1; j < ip[0].length; j++) {
				Detail curr = x.new Detail();

				if (ip[i][j] == 1) {
					curr.x = (op[i - 1][j]).x + 1;
					curr.y = (op[i][j - 1]).y + 1;

				} else {
					curr.x = 0;
					curr.y = 0;
				}

				op[i][j] = curr;
			}

		for (int i = 0; i < ip.length; i++) {
			System.out.print("|");
			for (int j = 0; j < ip[0].length; j++) {
				System.out.print(" " + op[i][j].x + "," + op[i][j].y + " |");
			}

			System.out.println();
			System.out.println("-------------------------------------");
		}

		int maxSubSquare = 0;
		Detail topLeft = null;
		Detail downRight = null;
		for (int i = ip.length - 1; i >= 0; i--) {
			for (int j = ip[0].length - 1; j >= 0; j--) {
				Detail curr = op[i][j];

				if (curr.x == 0 && curr.y == 0)
					continue;

				int minSize = Math.min(curr.x, curr.y);
				while (minSize > maxSubSquare) {

					if (i - minSize + 1 < 0 || j - minSize + 1 < 0) {
						minSize--;
						continue;
					}

					Detail up = op[i - minSize + 1][j];
					Detail left = op[i][j - minSize + 1];

					if (up.y >= minSize && left.x >= minSize) {
						if (maxSubSquare < minSize) {
							maxSubSquare = minSize;
							downRight = x.new Detail();
							downRight.x = i;
							downRight.y = j;
							topLeft = x.new Detail();
							topLeft.x = i - minSize + 1;
							topLeft.y = j - minSize + 1;
						}
						break;
					} else
						minSize--;
				}
			}

		}

		System.out.println(maxSubSquare + " " + topLeft + " " + downRight);
	}
}
