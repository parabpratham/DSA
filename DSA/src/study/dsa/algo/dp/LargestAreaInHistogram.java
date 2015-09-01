package study.dsa.algo.dp;

import java.util.Stack;

public class LargestAreaInHistogram {

	/*
	 * 
	 * Find the largest rectangular area possible in a given histogram where the
	 * largest rectangle can be made of a number of contiguous bars. For
	 * simplicity, assume that all bars have same width and the width is 1 unit.
	 * 
	 * For example, consider the following histogram with 7 bars of heights {6,
	 * 2, 5, 4, 5, 2, 6}. The largest possible rectangle possible is 12
	 */

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5};
		int no = a.length;

		Stack<Integer> st = new Stack<Integer>();
		int maxArea = 0;
		int i = 0;
		while (i < no) {
			// If this bar is higher than the bar on top stack, push it to stack
			if (st.isEmpty() || a[i] > a[st.peek()]) {
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
			int area = a[temp] * (st.isEmpty() ? i : i - st.peek() - 1);
			// update max area, if needed
			maxArea = area > maxArea ? area : maxArea;

		}

		// Now pop the remaining bars from stack and calculate area with every
		// popped bar as the smallest bar
		while (!st.isEmpty()) {
			int temp = st.pop();
			// Calculate the area with hist[tp] stack as smallest bar
			int area = a[temp] * (st.isEmpty() ? i : i - st.peek() - 1);
			// update max area, if needed
			maxArea = area > maxArea ? area : maxArea;
		}

		System.out.println(maxArea);
	}
}
