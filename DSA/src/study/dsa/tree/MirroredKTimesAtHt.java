package study.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirroredKTimesAtHt {

	public class Node {
		int data;
		int level;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		MirroredKTimesAtHt s = new MirroredKTimesAtHt();
		Scanner sc = new Scanner(System.in);

		int nodeDetails = sc.nextInt();

		Queue<Node> q = new LinkedList<Node>();

		Node head = s.new Node(1);
		q.add(head);

		for (int i = 0; i < nodeDetails; i++) {

			Node next = q.remove();
			int left = sc.nextInt();
			int right = sc.nextInt();

			if (left != -1) {
				next.left = s.new Node(left);
				q.add(next.left);
			} else {
				next.left = null;
				// q.add(null);
			}

			if (right != -1) {
				next.right = s.new Node(right);
				q.add(next.right);
			} else {
				next.right = null;
				// q.add(null);
			}

		}

		int noTimes = sc.nextInt();
		System.out.println();
		setLevel(head, 1);
		System.out.println();

		int[] levels = new int[noTimes];
		for (int i = 0; i < noTimes; i++) {
			levels[i] = sc.nextInt();
			swap(head, levels[i]);
			inorder(head);
			System.out.println();
		}
		System.out.println();
	}

	private static void setLevel(Node node, int level) {

		if (node != null) {
			node.level = level;
			setLevel(node.left, level + 1);
			setLevel(node.right, level + 1);
		}

	}

	private static void inorder(Node node) {

		if (node.left != null)
			inorder(node.left);

		System.out.print(node.data + " ");

		if (node.right != null)
			inorder(node.right);
	}

	public static void swap(Node head, int level) {

		Queue<Node> q = new LinkedList<MirroredKTimesAtHt.Node>();
		q.add(head);
		while (!q.isEmpty()) {
			Node next = q.remove();
			if (next == null)
				continue;

			if (next.level % level == 0) {
				Node temp = next.right;
				next.right = next.left;
				next.left = temp;
			}
			q.add(next.left);
			q.add(next.right);
		}
	}

}
