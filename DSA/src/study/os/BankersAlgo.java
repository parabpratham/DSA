package study.os;

public class BankersAlgo {

	public static void main(String[] args) {

		int[][] allocation = { { 0, 1, 0 }, { 2, 0, 0 }, { 3, 0, 2 },
				{ 2, 1, 1 }, { 0, 0, 2 } };
		// n processes m resources

		int n = allocation.length;
		int m = allocation[0].length;

		int[][] max = { { 7, 5, 3 }, { 3, 2, 2 }, { 9, 0, 2 }, { 2, 2, 2 },
				{ 4, 3, 3 } };

		int[] available = { 3, 3, 2 };
		int[][] need = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				need[i][j] = max[i][j] - allocation[i][j];
		String safeState = "";
		int process = 0;
		boolean[] isComplete = new boolean[n];
		boolean processDone = true;
		while (processDone) {
			processDone = false;
			for (int i = 0; i < n; i++)
				if (!isComplete[i] && satisfied(need[i], available)) {
					performProcess(allocation[i], need[i], available);
					isComplete[i] = true;
					processDone = true;
					safeState += i+"--";
				}
			process = (process + 1) % n;
		}

		processDone = true;
		for (int i = 0; i < n; i++)
			processDone = isComplete[i];

		if (!processDone)
			System.out.println("No safe state");
		else
			System.out.println("Safe state " + safeState);
	}

	public static boolean satisfied(int[] need, int[] available) {
		for (int i = 0; i < need.length; i++)
			if (need[i] > available[i])
				return false;

		return true;
	}

	public static void performProcess(int[] allocation, int[] need,
			int[] available) {
		for (int i = 0; i < need.length; i++) {
			allocation[i] = allocation[i] + need[i];
			available[i] = available[i] - need[i];
			need[i] = 0;
			available[i] = allocation[i] + available[i];
		}
	}
}
