package study.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TreeWithInnerNode {

	public static final int LEFT_SUBTREE = -1;

	public static final int RIGHT_SUBTREE = 1;

	Node root;

	public TreeWithInnerNode() {

	}

	public TreeWithInnerNode(int data) {
		root = new Node(data);
	}

	public Node addNode(Node parent, int lr, int data) {
		Node node = new Node(data);
		if (lr < 1)
			parent.left = node;
		else
			parent.right = node;

		return node;
	}

	public class Output {

		int lt;
		int rt;
		int rd;
		int ld;
		int diameter;

		@Override
		public String toString() {
			return "( " + diameter + " " + lt + " " + rt + " " + ld + " " + rd
					+ " )";
		}
	}

	public class Node {
		public int data;
		public Node left;
		public Node right;
		public Output op; // This is for diameter of bt

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
			op = new Output();
		}
	}

	public static void main(String[] args) {
		TreeWithInnerNode t = new TreeWithInnerNode();
		// t.fiiledTreeForDiaWithOP();
		// t.createAndCheckNodesForSum();

		t.createAndConvertChildrenSumTree();

		// TreeWithInnerNode.Node head = t.new Node(1);
		// t.root = head;
		//
		// Node n2 = t.addNode(head, -1, 2);
		// Node n3 = t.addNode(head, 1, 3);
		//
		// Node n4 = t.addNode(n2, -1, 4);
		// Node n5 = t.addNode(n2, -1, 5);

		// Node n6 = t.addNode(n3, -1, 6);
		// Node n7 = t.addNode(n3, -1, 7);

	}

	public void orderLevelTraversal(Node root) {

		Queue<Node> q = new LinkedList<TreeWithInnerNode.Node>();

		q.add(root);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			System.out.print(curr.data + " ");
			if (curr.left != null)
				q.add(curr.left);
			if (curr.right != null)
				q.add(curr.right);
		}
	}

	public void fiiledTree() {
		TreeWithInnerNode.Node head = new Node(1);
		root = head;
		Node n2 = addNode(head, -1, 2);
		Node n3 = addNode(head, 1, 3);
		Node n4 = addNode(n2, -1, 4);
		Node n5 = addNode(n2, 1, 5);
		Node n6 = addNode(n3, -1, 6);
		Node n7 = addNode(n3, 1, 7);
	}

	public void fiiledTreeForDiaWithOP() {
		TreeWithInnerNode.Node head = new Node(0);
		root = head;
		Queue<Node> q = new LinkedList<Node>();
		q.add(head);
		Scanner sc = new Scanner(System.in);
		int nodeDetails = sc.nextInt();
		for (int i = 0; i < nodeDetails; i++) {

			Node next = q.remove();
			int left = sc.nextInt();
			int right = sc.nextInt();

			if (left != -1) {
				next.left = new Node(left);
				q.add(next.left);
			} else {
				next.left = null;
				// q.add(null);
			}

			if (right != -1) {
				next.right = new Node(right);
				q.add(next.right);
			} else {
				next.right = null;
				// q.add(null);
			}

		}
		// System.out.println();
		// t.orderLevelTraversal(head);
		// System.out.println();

		// System.out.println(sizeOfTree(root));
		// System.out.println(heightOfTree(root));

		//System.out.println(checkNodesForSum(root));
	}

	// Returns 1 if all the nodes have Node.data = node.left.data +
	// node.right.data
	// if node is null returns 0

	public int checkNodesForSum(Node node) {

		if (node == null)
			return 0;

		if ((node.left == null && node.right == null))
			return 0;

		int n = node.data - (node.left == null ? 0 : node.left.data)
				+ (node.right == null ? 0 : node.right.data);

		if (n != 0)
			return 1;

		int lVal = checkNodesForSum(node.left);
		int rVal = checkNodesForSum(node.right);

		if (lVal != 0 || rVal != 0)
			return 1;

		return 0;
	}

	// http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/

	// Convert an arbitrary Binary Tree to a tree that holds Children Sum
	// Property
	/*
	 * Question: Given an arbitrary binary tree, convert it to a binary tree
	 * that holds Children Sum Property. You can only increment data values in
	 * any node (You cannot change structure of tree and cannot decrement value
	 * of any node).
	 */

	public void createAndConvertChildrenSumTree() {

		// On site example
		// Node root = new Node(50);
		// root.left = new Node(7);
		// root.right = new Node(2);
		// root.left.left = new Node(3);
		// root.left.right = new Node(5);
		// root.right.left = new Node(1);
		// root.right.right = new Node(30);

		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.left.left = new Node(12);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		root.right.right.right = new Node(7);

		convertToChildrenSumTree(root);

		System.out.println(checkNodesForSum(root));
	}

	public void convertToChildrenSumTree(Node node) {

		// if child is leave return
		if (node == null || (node.left == null && node.right == null))
			return;

		// we move to check the bottom nodes
		convertToChildrenSumTree(node.left);
		convertToChildrenSumTree(node.right);

		int leftVal = 0, rightVal = 0;

		if (node.left != null)
			leftVal = node.left.data;

		if (node.right != null)
			rightVal = node.right.data;

		// We find Difference between parent node and the sum of its childs
		// If diff>0 -. Parent is greater and adjust its child
		// If diff<0 -. Parent is less adjust the children
		int diff = node.data - (leftVal + rightVal);
		if (diff > 0) {

			// if diff is less to adjust we always first choose to add data to
			// its left child
			// and then call to check if left child satisfies the property
			if (node.left != null) {
				node.left.data = node.left.data + diff;
				if (node.left != null)
					convertToChildrenSumTree(node.left);
			} else {

				node.right.data += diff;
				if (node.right != null)
					convertToChildrenSumTree(node.right);
			}
		} else if (diff < 0) {
			node.data = leftVal + rightVal;
		}
	}

	public int sizeOfTree(Node node) {

		if (node.left == null && node.right == null)
			return 1;

		return (node.left == null ? 0 : sizeOfTree(node.left))
				+ (node.right == null ? 0 : sizeOfTree(node.right)) + 1;
	}

	public int heightOfTree(Node node) {

		if (node.left == null && node.right == null)
			return 0;

		return Math.max((node.left == null ? 0 : sizeOfTree(node.left)),
				(node.right == null ? 0 : sizeOfTree(node.right))) + 1;
	}

	public void fiiledTreeForDia() {
		TreeWithInnerNode.Node head = new Node(25);
		root = head;
		Node n2 = addNode(head, -1, 18);
		Node n3 = addNode(head, 1, 50);
		Node n4 = addNode(n2, -1, 19);
		Node n5 = addNode(n2, 1, 20);
		Node n6 = addNode(n3, -1, 35);
		Node n7 = addNode(n3, 1, 60);
		addNode(n4, 1, 15);
		addNode(n5, -1, 18);
		addNode(n5, 1, 25);
		Node n11 = addNode(n6, -1, 20);
		addNode(n6, 1, 40);
		addNode(n7, -1, 55);
		addNode(n7, 1, 70);
		addNode(n11, 1, 25);
		// orderLevelTraversal(head);
	}

	public void fillDiameterInfo(Node node) {
		Output op = node.op;
		if (node.left != null) {
			fillDiameterInfo(node.left);
			op.lt = getHeight(node.left);
			op.ld = getDiameter(node.left);
		} else {
			op.lt = 0;
			op.ld = 0;
		}
		if (node.right != null) {
			fillDiameterInfo(node.right);
			op.rt = getHeight(node.right);
			op.rd = getDiameter(node.right);
		} else {
			op.rt = 0;
			op.rd = 0;
		}
		op.diameter = getDiameter(node);
		System.out.println(node.data + " " + node.op);
	}

	public int getDiameter(Node node) {
		Output op = node.op;
		return Math.max(op.lt + op.rt + 1, Math.max(op.ld, op.rd));
	}

	public int getHeight(Node node) {
		Output op = node.op;
		return Math.max(op.lt, op.rt) + 1;
	}

	public int checkIfLeaf(Node node, Node parent, int subtreeType,
			Stack<Node> sc) {
		if (node.left == null && node.right == null) {
			if (parent.left == node && parent.op.rd == node.op.diameter
					&& parent.op.ld == node.op.diameter)
				printOrStoreData(node, 1, subtreeType, sc);
			return 1;
		}

		return -1;
	}

	public int printDiameter(Node node, Node parent, int heightReq,
			Stack<Node> sc, int subtreeType) {
		int temp = -1;

		if ((temp = checkIfLeaf(node, parent, subtreeType, sc)) == 1)
			return temp;

		Output op = node.op;
		if (op.diameter == op.ld) {

			temp = printDiameter(node.left, node, op.ld, sc, subtreeType);
			printOrStoreData(node, temp + 1, subtreeType, sc);

		} else if (op.diameter == op.rd) {

			temp = printDiameter(node.right, node, op.rd, sc, subtreeType);
			printOrStoreData(node, temp + 1, subtreeType, sc);

		} else if ((op.lt + op.rt + 1) == op.diameter) {

			if (op.lt > op.rt) {

				temp = printDiameter(node.left, node, heightReq - 1, sc,
						subtreeType);
				printOrStoreData(node, temp + 1, subtreeType, sc);
			} else if (op.lt < op.rt) {

				temp = printDiameter(node.right, node, heightReq - 1, sc,
						subtreeType);
				printOrStoreData(node, temp + 1, subtreeType, sc);

			} else {

				temp = printDiameter(node.left, node, heightReq - op.ld, sc,
						LEFT_SUBTREE);

				if (op.diameter - temp == (heightReq - op.rt - 1))
					System.out.print(node.data + " ");

				int dir = LEFT_SUBTREE;
				if (root.op.diameter - temp == (heightReq - op.rt - 1))
					dir = RIGHT_SUBTREE;

				temp = printDiameter(node.right, node, heightReq - op.rt - 1,
						sc, dir);

				printStack(sc);
			}
		}

		return temp + 1;
	}

	public int printD(Node node, int htFromTop, int printStack, Stack<Node> sc) {

		if (node == null)
			return 0;

		if (node.left == null && node.right == null && htFromTop == 1) {
			printOrStoreData(node, printStack, sc);
			return 1;
		}

		int tempLeft = 0;
		int tempRight = 0;

		Output op = node.op;
		if (htFromTop == (op.lt + op.rt + 1)) {

			if (htFromTop - op.rt - 1 == op.lt)
				printOrStoreData(node, printStack, sc);
			tempLeft = printD(node.left, op.lt, printStack, sc);

			if (htFromTop != (tempLeft + 1)) {

				while (!sc.isEmpty())
					System.out.print(sc.pop().data + " ");

				tempRight = printD(node.right, op.rt, RIGHT_SUBTREE, sc);
			}

			return htFromTop;

		} else if (htFromTop == op.lt + 1) {

			if (op.lt + 1 == htFromTop) {
				printOrStoreData(node, printStack, sc);
			}
			return printD(node.left, op.lt, printStack, sc) + 1;

		} else if (htFromTop == op.rt + 1) {

			if (op.rt + 1 == htFromTop) {
				printOrStoreData(node, printStack, sc);
				htFromTop--;
			}
			return printD(node.right, op.rt, printStack, sc) + 1;

		} else if (htFromTop == op.ld) {
			return printD(node.left, htFromTop, printStack, sc);
		} else if (htFromTop == op.rd) {
			return printD(node.right, htFromTop, printStack, sc);
		}
		return Math.max(tempRight, tempLeft);

	}

	private void printOrStoreData(Node node, int subtreeType, Stack<Node> sc) {
		if (subtreeType == RIGHT_SUBTREE)
			System.out.print(node.data + " ");
		else {
			sc.push(node);
		}
	}

	private void printOrStoreData(Node node, int temp, int subtreeType,
			Stack<Node> sc) {
		if ((temp) == node.op.diameter)
			if (subtreeType == RIGHT_SUBTREE)
				System.out.print(node.data + " ");
			else {
				System.out.print(node.data + " stacked, ");
				sc.push(node);
			}
	}

	private void printStack(Stack<Node> sc) {
		for (Node node : sc) {
			System.out.print(node.data + " ");
		}
	}

}
