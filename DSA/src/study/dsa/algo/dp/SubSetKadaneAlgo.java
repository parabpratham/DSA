package study.dsa.algo.dp;

public class SubSetKadaneAlgo {

	//
	// Input 	|   -1 	  |   6    | 	3   | 	-2   | 	-3    | 	6   |
	// ------------------------------------------------------------------------
	// max_curr | -1(0,0) | 6(1,1) | 9(1,2) | 7(1,3) | 4(1,4) | 10(1,5) |
	// ------------------------------------------------------------------------
	// max 		| -1(0,0) | 6(1,1) | 9(1,2) | 9(1,2) | 9(1,2) | 10(1,5) |
	// ------------------------------------------------------------------------
	// result 	| -1(0,0) | 6(1,1) | 9(1,2) | 9(1,2) | 9(1,2) | 10(1,5) |
	// ------------------------------------------------------------------------
	//

	public class Outcome {
		int sum = -Integer.MAX_VALUE;
		int left;
		int right;
	}

	public static void main(String[] args) {
		SubSetKadaneAlgo s = new SubSetKadaneAlgo();
		// int[] ip = { -1, -2, 3, 4, -5, 6 };
		int[] ip = { -6, 13, 1, 4 };

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

		System.out.println(maxsum.sum + " " + maxsum.left + " " + maxsum.right);

	}

}
