package study.dsa.algo;

import java.util.Scanner;

public class SherlocProblem {

	/*
	 * A Decent Number has the following properties: 3, 5, or both as its
	 * digits. No other digit is allowed. Number of times 3 appears is divisible
	 * by 5. Number of times 5 appears is divisible by 3. Sample Input 4 1 3 5
	 * 11 Sample Output -1 555 33333 55555533333
	 * 
	 * If the number(say 66317) is not divisible by 3, it will leave a modulo of
	 * either 0,1 or 2. If I decrease the number by 5, I am basically making it
	 * a multiple of 3, and the remaining digits will be a multiple of 5 as I am
	 * subtracting it from the number. modulo 0 implies number divisible modulo
	 * 1 implies 5 needs to be subtracted twice. modulo 2 implies 5 needs to be
	 * subtracted once
	 */

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int no = sc.nextInt();

		for (int j = 0; j < no; j++) {

			int y = sc.nextInt();
			int z = y;
			while (z % 3 != 0) {
				z -= 5;
			}
			if (z < 0)
				System.out.println("-1");
			else {
				StringBuilder buff = new StringBuilder("");
				for (int i = 0; i < z; i++)
					buff.append("5");
				for (int i = 0; i < (y - z); i++)
					buff.append("3");
				System.out.println(buff);
			}

		}

	}
}
