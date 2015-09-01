package study.dsa.linkedlist;

import study.dsa.linkedlist.AlternateSwappingOfNodes.Node;

public class SwapList {

	public static void main(String[] args) {
		AlternateSwappingOfNodes a = new AlternateSwappingOfNodes();
		Node first;
		Node head = first = a.new Node(1);
		for (int i = 2; i < 10; i++) {
			first.next = a.new Node(i);
			first = first.next;
		}

		first = head;
		while (first != null) {
			System.out.print(first.data + " ");
			first = first.next;
		}

		first = head;
		Node second = first.next;
		first.next = null;

		while (second != null) {
			Node third = second.next;
			second.next = first;
			first = second;
			second = third;
		}

		System.out.println();
		head = first;

		first = head;
		while (first != null) {
			System.out.print(first.data + " ");
			first = first.next;
		}
	}

}
