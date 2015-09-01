package study.dsa.graphs;

import study.dsa.advancedatastructures.CircularQueue;

/**
 * @author GeeksForGeeks.com
 */

public class MaxFlow {

	public static int[][] ipGraph = { { 0, 16, 13, 0, 0, 0 },
			{ 0, 0, 10, 12, 0, 0 }, { 0, 4, 0, 0, 14, 0 },
			{ 0, 0, 9, 0, 0, 20 }, { 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };

	public static int maxFlow = 0;

	public static void main(String[] args) {

		int n = ipGraph.length;
		int m = ipGraph[0].length;
		int[][] rGraph = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				rGraph[i][j] = ipGraph[i][j];
		int path[] = new int[m];
		while (isPathPresent(rGraph, 0, n - 1, path)) {

			int pathValue = Integer.MAX_VALUE;
			for (int v = n - 1; v != 0; v = path[v]) {
				int u = path[v];
				pathValue = (pathValue > rGraph[u][v]) ? rGraph[u][v]
						: pathValue;
			}

			for (int v = n - 1; v != 0; v = path[v]) {
				int u = path[v];
				rGraph[u][v] -= pathValue;
				rGraph[v][u] += pathValue;
			}
			display(rGraph);
			maxFlow += pathValue;
		}
		System.out.println(maxFlow);
	}

	public static void display(int[][] rGraph) {
		for (int i = 0; i < rGraph.length; i++) {
			for (int j = 0; j < rGraph[0].length; j++) {

				System.out.print(rGraph[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("------------------------");
	}

	/* returns path value if present else -1 */
	public static boolean isPathPresent(int[][] rGraph, int source,
			int destination, int[] path) {

		boolean[] visited = new boolean[ipGraph.length];
		visited[source] = true;

		int currentNode;
		path[source] = -1;

		CircularQueue q = new CircularQueue();
		q.insert(source);

		while (!q.isEmpty()) {
			currentNode = q.delete();
			if (currentNode == destination)
				break;
			for (int i = 0; i < ipGraph[0].length; i++) {
				if (rGraph[currentNode][i] > 0 && !visited[i]) {
					path[i] = currentNode;
					q.insert(i);
					visited[i] = true;
				}
			}
		}
		return visited[destination];
	}

}
