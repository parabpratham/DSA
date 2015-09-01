package study.math.problems;

public class SalaryQuestion {

	/*
	 * ' There are n employees in a company, each having some ratings. The
	 * employees are given a hike in their salary based on their ratings, i.e
	 * employee with higher rating will get the higher raise. An employee can
	 * only know the hike and rating of two of his neighbours, one on the left
	 * and other on the right. Given an array of size n, specifying the ratings
	 * of n employees, find the minimum hike that should be raised for each
	 * employee, such that no employee feels unfair. Example: 1 3 5 4 (ratings
	 * for 4 employees) Output: 1+2+3+2 = 7 Example: 5 3 4 2 1 6 Output:
	 * 2+1+3+2+1+2 = 11.
	 */

	public static void main(String[] args) {

		// int[] ratings = { 1, 3, 5, 4 };

		int[] ratings = { 5, 3, 4, 2, 1, 6 };

		int[] hike = new int[ratings.length];

		int curr = 0, rt = curr + 1, lt = 0;

		hike[0] = ratings[0];
		while (curr < ratings.length) {

			if (rt < ratings.length && ratings[curr] < ratings[rt]
					&& ratings[curr] < ratings[lt]) {
				hike[lt]++;
				hike[rt]++;
			} else if (rt < ratings.length && ratings[rt] < ratings[curr]
					&& ratings[curr] < ratings[lt]) {
				hike[rt] = 1;
				if (ratings[curr] < ratings[lt]) {
					hike[curr]++;
					hike[lt]++;
				}
			}

			lt = curr;
			curr = rt;
			rt++;
		}

		for (int i = 0; i < hike.length; i++)
			System.out.print(hike[i] + " ");
	}
}
