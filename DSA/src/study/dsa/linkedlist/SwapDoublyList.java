package study.dsa.linkedlist;

import study.dsa.linkedlist.AlternateSwappingOfDoubleNodes.Node;

public class SwapDoublyList {

	public static void main(String[] args) {
		AlternateSwappingOfDoubleNodes a = new AlternateSwappingOfDoubleNodes();

		Node first;
		Node head = a.createList();

		first = head;
		while (first.next != null) {
			Node temp = first.next;
			first.next = first.prev;
			first.prev = temp;
			first = temp;
		}

		first.next = first.prev;
		first.prev = null;

		System.out.println();
		head = first;

		first = head;
		Node temp = head;
		while (first != null) {
			System.out.print(first.data + " ");
			temp = first;
			first = first.next;
		}
		System.out.println();
		first = temp;
		while (first != null) {
			System.out.print(first.data + " ");
			first = first.prev;
		}
	}

}
