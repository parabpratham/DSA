package study.dsa.algo.dp;

import java.util.HashMap;

public class MaxLengthEqualNoOfZeroesOnesON {

	public static void main(String[] args) {

		/*
		 * int[] ip = { 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1,
		 * 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 };
		 */

		// int[] ip = { 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 };

		int[] ip = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };

		int[] sumLeft = new int[ip.length];

		int max = ip[0], min = ip[0];

		sumLeft[0] = (ip[0] == 0 ? -1 : 1);

		// For all zeroes treat as -1
		// We calculate the difference from zero till index j and save it in the
		// sumLeft array.
		// We also maintain max and min as the max diff and min difference
		// | 1 --> -2 | 2 --> -3 | 3 --> -4 | 4 --> -5 | 5 --> -4 | 6 --> -3
		// | 7 --> -2 | 8 --> -3 | 9 --> -2 | 10 --> -3 | 11 --> -4 | 12 --> -5
		// | 13 --> -4 |

		for (int i = 1; i < ip.length; i++) {
			sumLeft[i] = (ip[i] == 0 ? -1 : 1) + sumLeft[i - 1];
			if (max < sumLeft[i])
				max = sumLeft[i];
			if (min > sumLeft[i])
				min = sumLeft[i];

			System.out.print(i + " --> " + sumLeft[i] + " | ");

		}
		System.out.println();

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(max - min
				+ 1);
		for (int i = 0; i < max - min + 1; i++)
			map.put(i, -1);

		int maxSize = -1;
		int startIndex = 0;

		// Now there are two possibilities
		// 1. The maximum sequence starts from 0
		// Then the startIndex will be zero and sumArray[j] =0
		// 2. Doesn't start from 0
		// we have to find the point i such that sumArray[i] = sumArray[j]
		// in above case sumArray[4] = -5 and sumArray[10] = -5
		// So max will be 10
		// To find such lengths we maintain a hashmap of the diff against index
		// 2.1 Initialize the map with the value -1
		// 2.2 If sumLeft[i] -min is not present add to the map (sumLeft[i] -min
		// is done only to take care of the positive indexes)
		// 2.3 if sumLeft[i] = sumLeft[j] then check if j-i is of max dist

		for (int i = 0; i < ip.length; i++) {

			// case 1
			if (sumLeft[i] == 0) {
				maxSize = i + 1;
				startIndex = 0;
			}

			// case 2.2
			else if (map.get(sumLeft[i]-min) == -1)
				map.put(sumLeft[i] - min, i);

			// case 2.3
			else {
				if (i - map.get(sumLeft[i] - min) > maxSize) {
					maxSize = i - map.get(sumLeft[i] - min);
					startIndex = map.get(sumLeft[i] - min) + 1;

				}
			}
		}

		if (maxSize == -1)
			System.out.println("No Subarray");
		else
			System.out.println(maxSize + " " + startIndex);

	}
}
