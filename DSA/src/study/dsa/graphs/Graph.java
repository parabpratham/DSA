package study.dsa.graphs;

import study.dsa.advancedatastructures.QueueUsingStacks;

public class Graph {

	public int[][] graph = null;

	int diamension;

	String[] vertex = null;

	public Graph(int n) {
		diamension = n;
		graph = new int[n][n];
	}

	public Graph(String[] vertex, int[][] graph, int diamension) {
		this.graph = graph;
		this.diamension = diamension;
		this.vertex = vertex;
	}

	public void BFS(String ipVertex) {
		int vertexIndex = getVertexIndex(ipVertex);
		int[] visited = new int[diamension];
		visited[vertexIndex] = 1;
		QueueUsingStacks queue = new QueueUsingStacks();
		int totalVisited = diamension - 1;
		//queue.insert(vertexIndex);
		while (totalVisited > 0) {
			for (int i = 0; i < diamension; i++)
				if (graph[vertexIndex][i] != 0) {
					if (visited[graph[vertexIndex][i]] != 1) {
						queue.insert(i);
					}
				}
			System.out.print(vertex[vertexIndex] + " ");
			if (queue.isEmpty()) {
				for (int vertexId : visited)
					if (vertexId == 0) {
						queue.insert(vertexId);
						break;
					}
			}
			totalVisited--;
			if (totalVisited > 0 && !queue.isEmpty())
				vertexIndex = queue.delete();
		}

	}

	private int getVertexIndex(String vertex) {
		int id = -1;
		for (int i = 0; i < diamension; i++) {
			if (vertex.equalsIgnoreCase(this.vertex[i])) {
				id = i;
				break;
			}
		}
		return id;
	}

}
