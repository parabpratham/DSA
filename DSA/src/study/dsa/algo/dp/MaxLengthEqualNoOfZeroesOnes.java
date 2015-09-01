package study.dsa.algo.dp;

public class MaxLengthEqualNoOfZeroesOnes {

	public static void main(String[] args) {

		/*
		 * int[] ip = { 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1,
		 * 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 };
		 */

		//int[] ip = { 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 };
		
		int[] ip = { 1,0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

		int[] countZero = new int[ip.length];
		int[] countOnes = new int[ip.length];

		int countZ = 0, countO = 0;
		for (int i = 0; i < ip.length; i++) {
			if (ip[i] == 0) {
				countZero[i] = ++countZ;
				countOnes[i] = countO;
			} else {
				countOnes[i] = ++countO;
				countZero[i] = countZ;
			}
		}

		if (countZ == 0 || countO == 0) {
			System.out.println("-1");
			return;
		}

		for (int i = 0; i < ip.length; i++) {
			if (i <= 9) {
				System.out.print(i + "   ");
			} else
				System.out.print(i + "  ");
		}
		System.out.println();
		System.out
				.println("----------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < ip.length; i++) {
			System.out.print(ip[i] + "   ");
		}
		System.out.println();
		System.out
				.println("----------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < ip.length; i++) {
			if (countZero[i] <= 9) {
				System.out.print(countZero[i] + "   ");
			} else
				System.out.print(countZero[i] + "  ");
		}
		System.out.println();
		for (int i = 0; i < ip.length; i++) {
			if (countOnes[i] <= 9) {
				System.out.print(countOnes[i] + "   ");
			} else
				System.out.print(countOnes[i] + "  ");
		}
		System.out.println();
		System.out
				.println("----------------------------------------------------------------------------------------------------------------------");

		int maxLength = -Integer.MAX_VALUE;
		int startIndex = -Integer.MAX_VALUE;
		int noOfT = 0;

		for (int i = 0; i < ip.length; i++) {

			int count = 0;

			for (int j = ip.length - 1; j >= i; ) {


				int onesFromI = countOnes[j] - (i == 0 ? 0 : countOnes[i - 1]);
				int zeroesFromI = countZero[j]
						- (i == 0 ? 0 : countZero[i - 1]);


				noOfT++;
				if (zeroesFromI == onesFromI && (j - i) > count) {
					count = j - i + 1;
					break;
				}
				else
					j = j-Math.abs(zeroesFromI-onesFromI);

				if ( Math.max(onesFromI, zeroesFromI) <= maxLength )
					break;

			}

			if (count > maxLength) {
				maxLength = count;
				startIndex = i;
			}
		}

		System.out.println(maxLength + " " + startIndex + " " + noOfT);
	}
}
