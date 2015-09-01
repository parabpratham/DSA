package study.dsa.tree;

import javax.swing.JFrame;

import study.dsa.tree.TreeWithInnerNode.Node;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

@SuppressWarnings("serial")
public class TreeViewer<T extends Comparable<T>> extends JFrame {

	static private int CANVAS_HEIGHT = 600;
	static private int CANVAS_WIDTH = 1000;

	private int rootY = 10;
	private int NODE_SIZE = 25;
	private int ROW_HEIGHT = 50;
	mxGraph graph = new mxGraph();
	Object parent = graph.getDefaultParent();

	/**
	 * draws a tree starting from this root
	 * 
	 * @param root
	 * @param depth
	 *            number of nodes to the root (including root)
	 * @param index
	 *            index of node in this level (leftChildIndex = parentIndex * 2
	 *            - 1) and (rightChildIndex = parentIndex * 2)
	 * @return
	 */
	public Object drawTree(Node root, int depth, int index) {
		if (root == null) {
			return null;
		}

		// draw root

		/*
		 * leftChildIndex = parentIndex * 2 - 1 rightChildIndex = parentIndex *2
		 * 
		 * 
		 * x = index * canvasWidth / (2^depth + 1)
		 * 
		 * y = depth * canvasHeight / treeDepth
		 */

		int myX = (int) ((CANVAS_WIDTH * (index)) / (Math.pow(2, depth - 1) + 1));

		Object rootVertex = graph.insertVertex(parent, null, root.data, myX,
				depth * ROW_HEIGHT + rootY, NODE_SIZE, NODE_SIZE);

		// recurse for right child

		Object rightChildVertex = drawTree(root.right, depth + 1, index * 2);

		if (rightChildVertex != null) {// edge
			graph.insertEdge(parent, null, "R", rootVertex, rightChildVertex,
					"startArrow=none;endArrow=none;strokeWidth=1;strokeColor=green");
		}

		Object leftChildVertex = drawTree(root.left, depth + 1, index * 2 - 1);

		// recurse for right child

		if (leftChildVertex != null) { // edge
			graph.insertEdge(parent, null, "L", rootVertex, leftChildVertex,
					"startArrow=none;endArrow=none;strokeWidth=1;strokeColor=green");
		}

		return rootVertex;

	}

	/**
	 * Redraw the whole tree
	 * 
	 * @param root
	 *            the root of tree to be drawn
	 */

	public void update(Node root) {

		graph.getModel().beginUpdate();

		try {

			Object[] cells = graph.getChildCells(parent, true, false);
			graph.removeCells(cells, true);
			drawTree(root, 1, 1);

		} finally {
			graph.getModel().endUpdate();
		}
	}

	public TreeViewer(Node root) {
		// super("Hello, World!");

		this.update(root);

		mxGraphComponent graphComponent = new mxGraphComponent(graph);

		getContentPane().add(graphComponent);
	}

	public static void printTree(Node root) {
		TreeViewer<Integer> myTreeViewer = new TreeViewer<Integer>(root);
		JFrame frame = myTreeViewer;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		TreeWithInnerNode t = new TreeWithInnerNode();
		t.fiiledTreeForDiaWithOP();
		TreeViewer<Integer> myTreeViewer = new TreeViewer<Integer>(t.root);
		JFrame frame = myTreeViewer;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		frame.setVisible(true);

	}

}