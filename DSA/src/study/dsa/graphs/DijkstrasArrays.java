package study.dsa.graphs;

import java.util.Scanner;

public class DijkstrasArrays {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		for (int i = 0; i < no; i++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			int[][] graph = new int[n][n];

			for (int src = 0; src < n; src++)
				for (int dest = 0; dest < n; dest++) {
					if (src == dest)
						graph[src][dest] = 0;
					else
						graph[src][dest] = Integer.MAX_VALUE;
				}

			for (int j = 0; j < m; j++) {
				int src = sc.nextInt() - 1;
				int dest = sc.nextInt() - 1;
				int data = sc.nextInt();
				if (graph[src][dest] > data) {
					graph[src][dest] = data;
				}
				if (graph[dest][src] > data) {
					graph[dest][src] = data;
				}
			}

			int sr = sc.nextInt() - 1;

			boolean[] isVisted = new boolean[n];
			int[] dist = new int[n];
			for (int k = 0; k < n; k++)
				dist[k] = Integer.MAX_VALUE;

			dist[sr] = 0;
			int next = sr;
			while (next != -1) {
				int minVal = Integer.MAX_VALUE;
				int nextNode = -1;
				for (int dest = 0; dest < n; dest++) {
					if (!isVisted[dest] && next != dest) {
						if (graph[next][dest] != Integer.MAX_VALUE
								&& dist[dest] > (graph[next][dest] + dist[next]))
							dist[dest] = (graph[next][dest] + dist[next]);
						if (minVal > dist[dest]) {
							minVal = dist[dest];
							nextNode = dest;
						}
					}
				}
				isVisted[next] = true;
				next = nextNode;
			}

			for (int j = 0; j < n; j++) {
				if (j == sr)
					continue;

				System.out.print((dist[j] == Integer.MAX_VALUE ? -1 : dist[j])
						+ " ");
			}
			System.out.println();
		}
	}
}
