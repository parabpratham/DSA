package study.dsa.algo.dp;

public class MinJumpToReachEnd {

	// https://www.youtube.com/watch?v=cETfFsSTGJI&index=13&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr

	// Mimimum jump to reach end
	// {2,3,1,1,2,4,2,0,1,1} Ans: (pos) 0-->1-->4-->5-->9

	public static void main(String[] args) {

		int[] ip = { 2, 3, 1, 1, 2, 4, 2, 0, 1, 1 };

		int[] noOfJumps = new int[ip.length];
		int[] nextJump = new int[ip.length];

		for (int i = 1; i < ip.length; i++) {
			noOfJumps[i] = Integer.MAX_VALUE;
			nextJump[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i < ip.length; i++) {
			int j = 0;
			while (j < i) {
				if ((ip[j] + j) >= i) {
					if (noOfJumps[j] + 1 < noOfJumps[i]) {
						noOfJumps[i] = noOfJumps[j] + 1;
						nextJump[i] = j;
					}
				}
				j++;
			}
		}

		System.out.print(ip.length - 1 + " ");
		int i = ip.length - 1;
		int curr = nextJump[i];
		System.out.print(curr + " ");
		int j = i - 1;
		while (j >= 0) {
			if (nextJump[j] != curr) {
				System.out.print(nextJump[j] + " ");
				curr = nextJump[j];
			}
			j--;
		}

	}
}
