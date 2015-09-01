package study.math.problems;

public class MaxLessTwoMin
{

	/**
	 * Given an array of integers, find count of minimum number of elements to
	 * be removed from the array such that the maximum element of the new array
	 * is at most twice of the minimum.
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int[] a =
		{ 4, 5, 100, 9, 10, 11, 12, 15, 200 };

		int longestStart = 0, longestEnd = 0, longestVal = 0;
		int comp = 0;
		for (int start = 0; start < a.length; start++)
		{
			int max = a[start];
			int min = a[start];

			for (int end = start; end < a.length; end++)
			{
				max = Math.max(a[end], max);
				min = Math.min(a[end], min);
				comp += 2;
				if (max > 2 * min)
					break;
				comp++;
				if (end - start > longestVal)
				{
					longestEnd = end;
					longestStart = start;
					longestVal = end - start;
				}

			}
		}
		System.out.println(longestStart + "," + longestEnd + " --> " + longestVal + " in " + comp);
	}
}
