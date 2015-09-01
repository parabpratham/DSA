package study.dsa.algo.dp;

import java.util.Stack;

public class MaximumAreaIn2DBinary {

	public static void main(String[] args) {

		int[][] ip = { { 1, 0, 0, 1, 1, 1 }, { 1, 0, 1, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 1 } };

		int[] au = new int[ip[0].length];
		for (int j = 0; j < ip[0].length; j++) {
			au[j] = 0;
		}
		int maxArea = -Integer.MAX_VALUE;
		for (int i = 0; i < ip.length; i++) {

			for (int j = 0; j < ip[0].length; j++) {
				if (ip[i][j] == 0)
					au[j] = 0;
				else
					au[j] += ip[i][j];
				System.out.print(au[j] + " ");
			}
			int area = calculateArea(au);
			System.out.println(area);
			if (area > maxArea)
				maxArea = area;
		}

		System.out.println(maxArea);

	}

	public static int calculateArea(int[] ip) {
		int no = ip.length;

		Stack<Integer> st = new Stack<Integer>();
		int maxArea = 0;
		int i = 0;
		while (i < no) {
			// If this bar is higher than the bar on top stack, push it to stack
			if (st.isEmpty() || ip[i] > ip[st.peek()]) {
				st.push(i++);
				continue;
			}

			// If this bar is lower than top of stack, then calculate area of
			// rectangle
			// with stack top as the smallest (or minimum height) bar. 'i' is
			// 'right index' for the top and element before top in stack is
			// 'left index'
			int temp = st.pop();
			// Calculate the area with hist[tp] stack as smallest bar
			int area = ip[temp] * (st.isEmpty() ? i : i - st.peek() - 1);
			// update max area, if needed
			maxArea = area > maxArea ? area : maxArea;

		}

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (!st.isEmpty()) {
			int temp = st.pop();
			// Calculate the area with hist[tp] stack as smallest bar
			int area = ip[temp] * (st.isEmpty() ? i : i - st.peek() - 1);
			// update max area, if needed
			maxArea = area > maxArea ? area : maxArea;
		}
		return maxArea;
	}
}
