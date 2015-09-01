package study.dsa.algo.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int[] ip = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		int[] op = new int[ip.length];
		// https://www.youtube.com/watch?v=CE2b_-XfVDk&src_vid=9mod_xRB-O0&feature=cards&annotation_id=0136f9ce-ee79-4123-8fdb-055b78178eab
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

		System.out.println(op[ip.length - 1]);

	}

}
