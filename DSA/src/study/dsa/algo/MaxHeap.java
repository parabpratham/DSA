package study.dsa.algo;

public class MaxHeap
{

	int	arr[];
	int	n;

	public MaxHeap()
	{
		arr = new int[100];
		n = 100;
	}

	public MaxHeap(int[] arr)
	{
		this.arr = arr;
		n = arr.length;
	}

	public void buildHeap(int n)
	{
		for (int i = (int) Math.floor(n / 2) - 1; i >= 0; i--)
			maxHeapify(i, n);
	}

	public void maxHeapify(int i, int n)
	{
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		int largest = i;
		if (l < n && arr[l] > arr[i])
			largest = l;

		if (r < n && arr[r] > arr[largest])
			largest = r;

		if (arr[largest] != arr[i])
		{
			swap(i, largest);
			i = largest;
			maxHeapify(i, n);
		}

		// display();
	}

	private void swap(int i, int smallest)
	{
		int temp = arr[i];
		arr[i] = arr[smallest];
		arr[smallest] = temp;
	}

	public void display()
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public void heapSort(int n)
	{
		System.out.print(arr[0] + " ");
		if (n == 1)
			return;
		swap(0, n - 1);
		n = n - 1;
		buildHeap(n);
		heapSort(n);
	}

	public int[] sortedArray(int[] ip)
	{
		arr = ip;
		heapSort(ip.length);
		return arr;
	}

	public static void main(String[] args)
	{

		int[] ip =
		{ 10, 5, 2, 6, 12, 15, 1 };
		MaxHeap heap = new MaxHeap(ip);
		heap.buildHeap(ip.length);
		System.out.println();
		heap.heapSort(ip.length);
		System.out.println();
		heap.display();

	}

}
