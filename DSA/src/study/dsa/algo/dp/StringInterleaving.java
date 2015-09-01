package study.dsa.algo.dp;

public class StringInterleaving {

	// https://www.youtube.com/watch?v=ih2OZ9-M3OM&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=10

	// Given three strings, return true if third string is interleaving of first
	// and second string.

	public static void main(String[] args) {

		char[] ip1 = { 'a', 'a', 'b' };
		char[] ip2 = { 'a', 'x', 'y' };

		char[] ip3 = { 'a', 'a', 'x', 'a', 'b', 'y' };

		boolean op[][] = new boolean[ip2.length+1][ip1.length+1];
		op[0][0] = true;
		for (int i = 0; i < ip1.length; i++) {
			op[0][i + 1] = (ip1[i] == ip3[i]) && op[0][i];
		}

		for (int j = 0; j < ip2.length; j++) {
			op[j + 1][0] = (ip2[j] == ip3[j]) && op[j][0];
		}
		for (int i = 0; i < ip2.length; i++)
			for (int j = 0; j < ip1.length; j++) {

				int index = i + j + 1;
				op[i + 1][j + 1] = (ip2[i] == ip3[index] && (i > 0 ? op[i][j]
						: true))
						|| (ip1[j] == ip3[index] && (j > 0 ? op[i][j]
								: true));

			}

		for (int i = 0; i <= ip2.length; i++) {
			System.out.print("|");
			for (int j = 0; j <= ip1.length; j++) {
				System.out.print(" " + op[i][j] + " |");
			}

			System.out.println();
			System.out.println("-------------------------------------");
		}

	}
}
