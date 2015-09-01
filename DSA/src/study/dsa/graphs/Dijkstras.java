package study.dsa.graphs;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstras {

	public class Vertex implements Comparable<Vertex> {

		int vertexName;

		boolean isVisieted = false;
		BigInteger vertexValue = BigInteger.valueOf(Integer.MAX_VALUE);

		public Vertex(int n) {
			this.vertexName = n;
		}

		List<Edge> adjuncyList = null;

		public void addEdge(Edge edge) {
			if (adjuncyList == null)
				adjuncyList = new LinkedList<Dijkstras.Edge>();

			if (adjuncyList.contains(edge)) {
				for (Edge e : adjuncyList) {
					if (edge == e) {
						if (e.data > edge.data)
							e.data = edge.data;
					}
				}
			} else
				adjuncyList.add(edge);
		}

		public void fillNextVertices(PriorityQueue<Vertex> q) {

			if (adjuncyList == null)
				return;

			for (Edge e : adjuncyList) {

				if (!e.dest.isVisieted) {
					if (1 == e.dest.vertexValue.compareTo((BigInteger
							.valueOf(e.data).add(vertexValue)))) {
						e.dest.vertexValue = BigInteger.valueOf(e.data).add(
								vertexValue);
						q.remove(e.dest);
						q.add(e.dest);
					}
				}
			}
		}

		@Override
		public int compareTo(Vertex o) {
			return vertexValue.subtract(o.vertexValue).intValue();
		}

	}

	public class Edge {
		Vertex src;
		Vertex dest;
		int data;

		public Edge(Vertex src, Vertex dest, int data) {
			this.src = src;
			this.dest = dest;
			this.data = data;
		}

		@Override
		public boolean equals(Object obj) {
			Edge e = (Edge) obj;
			return e.dest == dest && e.src == src;
		}

		@Override
		public int hashCode() {
			return src.vertexName + dest.vertexName;
		}

	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 * 
		 * 1 4 4 1 2 24 1 4 20 3 1 3 4 3 12 1
		 */
		Dijkstras d = new Dijkstras();
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		for (int i = 0; i < no; i++) {

			int n = sc.nextInt();
			int m = sc.nextInt();

			Vertex[] graph = new Vertex[n];
			for (int j = 0; j < n; j++) {
				graph[j] = d.new Vertex(j);
			}

			for (int j = 0; j < m; j++) {
				int src = sc.nextInt() - 1;
				int dest = sc.nextInt() - 1;
				int data = sc.nextInt();
				Edge edge = d.new Edge(graph[src], graph[dest], data);
				graph[src].addEdge(edge);
				edge = d.new Edge(graph[dest], graph[src], data);
				graph[dest].addEdge(edge);
			}

			PriorityQueue<Vertex> q = new PriorityQueue<Dijkstras.Vertex>();
			int sr = sc.nextInt() - 1;
			graph[sr].vertexValue = BigInteger.valueOf(0);
			q.add(graph[sr]);
			while (!q.isEmpty()) {
				Vertex currentNode = q.remove();
				if (!currentNode.isVisieted)
					currentNode.fillNextVertices(q);
				currentNode.isVisieted = true;
			}

			for (Vertex x : graph) {
				if (x.vertexName != sr)
					System.out.println(x.vertexValue);
			}

			// currentNode = q.dequeue();
		}
	}
}
