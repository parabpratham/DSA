package study.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThreadedBinaryTree {

	Node root;

	public class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
		}

		boolean rightThread;
		boolean isTraversedLeft = false;
		boolean isTraversedRight = false;
	}

	private void convertToThreaded(Node root) {

		Queue<Node> inorder = new LinkedList<ThreadedBinaryTree.Node>();
		fillInorderQueue(root, inorder);
		convertNodes(root, inorder);
	}

	private void convertNodes(Node node, Queue<Node> inorder) {

		if (node == null)
			return;

		if (node.left != null)
			convertNodes(node.left, inorder);

		inorder.remove();

		if (node.right != null)
			convertNodes(node.right, inorder);
		else {
			if (!inorder.isEmpty()) {
				node.right = inorder.peek();
				node.rightThread = true;
				System.out.println(node.data + " -- " + node.right.data);
			}
		}

	}

	private void fillInorderQueue(Node node, Queue<Node> inorder) {

		if (node == null)
			return;
		fillInorderQueue(node.left, inorder);
		inorder.add(node);
		fillInorderQueue(node.right, inorder);
	}

	public static void main(String[] args) {
		ThreadedBinaryTree t = new ThreadedBinaryTree();
		t.fiiledTreeForDiaWithOP();
		System.out.println();
		t.inorderTraversal(t.root);
	}

	private Node leftMostNode(Node node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	private void inorderTraversal(Node root) {
		Node node = leftMostNode(root);

		while (node != null && !(node.right == null)) {
			System.out.print(node.data+" ");
			if (node.rightThread)
				node = node.right;
			else
				node = leftMostNode(node.right);
		}

	}

	public void fiiledTreeForDiaWithOP() {
		root = new Node(0);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
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
			}

		}
		convertToThreaded(root);
	}
}
