package study.dsa.algo;

public class MinHeap
{

	int	arr[];
	int	n;

	public MinHeap()
	{
		arr = new int[100];
		n = 100;
	}

	public MinHeap(int[] arr)
	{
		this.arr = arr;
		n = arr.length;
	}

	public void buildHeap(int n)
	{
		for (int i = (int) Math.floor(n / 2) - 1; i >= 0; i--)
			minHeapify(i, n);
	}

	public void minHeapify(int i, int n)
	{
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int smallest = i;
		if (l < n && arr[l] < arr[i])
			smallest = l;

		if (r < n && arr[r] < arr[smallest])
			smallest = r;

		if (arr[smallest] != arr[i])
		{
			swap(i, smallest);
			i = smallest;
			minHeapify(i, n);
		}

		// display();
	}

	private void swap(int i, int smallest)
	{
		int temp = arr[i];
		arr[i] = arr[smallest];
		arr[smallest] = temp;
	}

	public void heapSort(int n)
	{
		System.out.print(arr[0] + " ");
		if (n == 1)
			return;
		arr[0] = arr[n - 1];
		arr[n - 1] = -1;
		n = n - 1;
		buildHeap(n);
		heapSort(n);
	}

	public void display()
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args)
	{

		int[] ip =
		{ 10, 5, 2, 6, 12, 15, 1 };
		MinHeap heap = new MinHeap(ip);
		heap.buildHeap(ip.length);
		heap.heapSort(ip.length);

	}
}
