package study.math.problems;


public class NextGreaterNumber {

	/*
	 * 
	 * Next maximum number using the same digits of a given number
	 * 
	 * Logic: Parse from left , go till right till j where a[j]<a[j-1]
	 * 
	 * 128341 --> j == 5 (3-4) if j crosses 0 then not possible else swap j-1'th
	 * (3) with next smallest number from j to n
	 * 
	 * sort j to n ascending order
	 */

	public static void main(String[] args) {

		int number = 128341;
		int n = 6;
		int[] a = new int[6];

		int temp = number;
		int j = n - 1;
		while (temp != 0) {
			a[j] = temp % 10;
			temp = temp / 10;
			j--;
		}

		j = n - 1;
		while (j >= 1 && a[j] < a[j - 1]) {
			j--;
		}

		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = j; i < n; i++) {
			index = min > a[i] && a[j - 1] < a[i] ? i : index;
			min = min > a[i] && a[j - 1] < a[i] ? a[i] : min;
		}

		if (j == n) {
			System.out.println("Not Possible");
			return;
		}

		temp = a[j - 1];
		a[j - 1] = min;
		a[index] = temp;

		sort(a, j, n - 1);

		for (int i = 0; i < n; i++)
			System.out.print(a[i]);
	}

	public static void sort(int[] a, int n, int m) {

		int k = 1;
		for (int i = n; i <= m; i++) {
			boolean isSwapped = false;
			for (int j = n; j <= m - k; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					isSwapped = true;
				}
			}
			if (!isSwapped)
				break;
			k++;
		}
	}
}
