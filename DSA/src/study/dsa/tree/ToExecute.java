package study.dsa.tree;

import study.dsa.graphs.Graph;

public class ToExecute {

	public static void main(String[] args) {
		// callAvl();

		callBFS();
	}

	private static void callBFS() {

		int[][] graphArray = { { 0, 1, 0, 0, 0, 0, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 0, 0, 1, 0 },
				{ 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
				{ 1, 0, 0, 1, 0, 0, 0, 1, 0, 0 },
				{ 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 } };
		int diamension = 10;
		String[] vertex = { "0","1", "2", "3", "4", "5", "6", "7", "8", "9" };

		Graph graph = new Graph(vertex, graphArray, diamension);
		graph.BFS("0");
	}

	private static void callAvl() {
		AVLTree avlt = new AVLTree();
		avlt.addNode(15);
		avlt.addNode(6);
		avlt.addNode(18);
		avlt.addNode(3);
		avlt.addNode(2);
		avlt.addNode(4);
		avlt.addNode(5);
		avlt.addNode(7);
		avlt.addNode(13);
		avlt.addNode(9);
		avlt.addNode(18);
		avlt.addNode(17);
		avlt.addNode(20);
		System.out.println(avlt.checkAVLTree());
	}
}
