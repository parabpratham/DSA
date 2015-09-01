package study.dsa.algo;

public class MedianOfStreamNumbers {

	public static void main(String[] args) {
		int countLeft = 0, countRight = 0;
		double currentMedian = 0.0;
		int ip[] = { 5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4 };
		// Scanner sc = new Scanner(System.in);
		int n = ip.length;// = sc.nextInt();
		int[] minHeap = new int[n];
		int[] maxHeap = new int[n];
		for (int i = 0; i < n; i++) {
			// int temp = sc.nextInt();
			int temp = ip[i];
			if ((countLeft - countRight) == 0) {
				if (temp <= currentMedian) {

					currentMedian = addMaxHeap(maxHeap, temp, countLeft);
					countLeft++;
				} else {
					currentMedian = addMinHeap(minHeap, temp, countRight);
					countRight++;
				}
			} else if ((countLeft - countRight) < 0) {
				if (temp <= currentMedian) {
					addMaxHeap(maxHeap, temp, countLeft);
					currentMedian = (minHeap[0] + maxHeap[0] * 1.0) / 2.0;
					countLeft++;
				} else {
					currentMedian = processRightHeap(minHeap, maxHeap, temp,
							currentMedian, countLeft, countRight);
					countLeft++;
					// countRight--;
				}
			} else if ((countLeft - countRight) > 0) {

				if (temp > currentMedian) {
					addMinHeap(minHeap, temp, countRight);
					currentMedian = (minHeap[0] + maxHeap[0] * 1.0) / 2.0;
					countRight++;
				} else {
					currentMedian = processLeftHeap(minHeap, maxHeap, temp,
							currentMedian, countLeft, countRight);
					countRight++;
				}
			}
			System.out.println(currentMedian);
		}

	}

	private static double processLeftHeap(int[] minHeap, int[] maxHeap, int ip,
			double currentMedian, int countLeft, int countRight) {

		// temp into root of left heap and place new at the root of the node
		// and heapify
		int root = maxHeap[0];
		maxHeap[0] = ip;

		// heapify right by adding smallest of each level as child
		buildMaxHeap(maxHeap, countLeft);

		// add currentMedian to right minHeap;
		addMinHeap(minHeap, root, countRight);
		currentMedian = ((minHeap[0] + maxHeap[0]) * 1.0) / 2.0;

		return currentMedian;

	}

	public static void buildMaxHeap(int[] arr, int n) {
		for (int i = (int) Math.floor(n / 2) - 1; i >= 0; i--)
			maxHeapify(arr, n, i);
	}

	public static void buildMinHeap(int[] arr, int n) {
		for (int i = (int) Math.floor(n / 2) - 1; i >= 0; i--)
			minHeapify(arr, n, i);
	}

	private static double processRightHeap(int[] minHeap, int[] maxHeap,
			int ip, double currentMedian, int countLeft, int countRight) {

		// temp into root of left heap and place new at the root of the node
		// and heapify
		int root = minHeap[0];
		minHeap[0] = ip;

		// heapify right by adding smallest of each level as child
		buildMinHeap(minHeap, countRight);

		// add currentMedian to left maxHeap;
		addMaxHeap(maxHeap, root, countLeft);
		currentMedian = ((minHeap[0] + maxHeap[0]) * 1.0) / 2.0;
		return currentMedian;

	}

	private static void minHeapify(int[] arr, int n, int i) {
		/*
		 * int pos = 0; while (countRight >= pos * 2 + 1) { if ((pos * 2 + 1) ==
		 * countRight && !(minHeap[pos * 2 + 1] == 0)) { int temp =
		 * minHeap[pos]; minHeap[pos] = minHeap[pos * 2 + 1]; minHeap[pos * 2 +
		 * 1] = temp; pos = pos * 2 + 1; } else if (minHeap[pos * 2 + 1] <
		 * minHeap[pos * 2 + 2]) { int temp = minHeap[pos]; minHeap[pos] =
		 * minHeap[pos * 2 + 1]; minHeap[pos * 2 + 1] = temp; pos = pos * 2 + 1;
		 * } else { int temp = minHeap[pos]; minHeap[pos] = minHeap[pos * 2 +
		 * 2]; minHeap[pos * 2 + 2] = temp; pos = pos * 2 + 2; } }
		 */

		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int smallest = i;
		if (l < n && arr[l] < arr[i])
			smallest = l;
		if (r < n && arr[r] < arr[smallest])
			smallest = r;

		if (arr[i] != arr[smallest]) {
			swap(arr, i, smallest);
			i = smallest;
			minHeapify(arr, n, i);
		}

	}

	private static double addMinHeap(int[] minHeap, int ip, int countRight) {

		minHeap[countRight++] = ip;
		buildMinHeap(minHeap, countRight);
		return minHeap[0];
	}

	private static void maxHeapify(int[] arr, int n, int i) {
		/*
		 * int pos = 0; while (countLeft >= pos * 2 + 1) { if ((pos * 2 + 1) ==
		 * countLeft) { int temp = maxHeap[pos]; maxHeap[pos] = maxHeap[pos * 2
		 * + 1]; maxHeap[pos * 2 + 1] = temp; pos = pos * 2 + 1; } if
		 * (maxHeap[pos * 2 + 1] > maxHeap[pos * 2 + 2]) { int temp =
		 * maxHeap[pos]; maxHeap[pos] = maxHeap[pos * 2 + 1]; maxHeap[pos * 2 +
		 * 1] = temp; pos = pos * 2 + 1; } else { int temp = maxHeap[pos];
		 * maxHeap[pos] = maxHeap[pos * 2 + 2]; maxHeap[pos * 2 + 2] = temp; pos
		 * = pos * 2 + 2; } }
		 */

		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int largest = i;
		if (l < n && arr[l] > arr[i])
			largest = l;
		if (r < n && arr[r] > arr[largest])
			largest = r;

		if (arr[i] != arr[largest]) {
			swap(arr, i, largest);
			i = largest;
			maxHeapify(arr, n, i);
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
	

	private static double addMaxHeap(int[] maxHeap, int ip, int countLeft) {
		maxHeap[countLeft++] = ip;
		buildMaxHeap(maxHeap, countLeft);
		return maxHeap[0];
	}
}