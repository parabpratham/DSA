package study.dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirroredKTimes {

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
		MirroredKTimes s = new MirroredKTimes();
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

		int k = sc.nextInt();
		System.out.println();
		inorder(head);
		System.out.println();

		for (int j = 0; j < k; j++) {
			int noTimes = sc.nextInt();
			for (int i = 0; i < noTimes; i++) {
				swap(head);
			}
			inorder(head);
			System.out.println();
		}

	}

	private static void inorder(Node node) {

		if (node.left != null)
			inorder(node.left);

		System.out.print(node.data + " ");

		if (node.right != null)
			inorder(node.right);
	}

	public static void swap(Node head) {

		Queue<Node> q = new LinkedList<MirroredKTimes.Node>();
		q.add(head);
		while (!q.isEmpty()) {
			Node next = q.remove();

			if (next == null)
				continue;

			Node temp = next.right;
			next.right = next.left;
			next.left = temp;

			q.add(next.left);
			q.add(next.right);

		}
	}

}
