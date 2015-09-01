package study.dsa.linkedlist;

public class AlternateSwappingOfDoubleNodes {

	public class Node {
		public int data;
		public Node next;
		public Node prev;

		public Node(int data) {
			this.data = data;
		}
	}

	public Node createList() {
		Node curr, prev = null;
		Node head = curr = this.new Node(1);
		for (int i = 2; i < 10; i++) {
			curr.next = this.new Node(i);
			curr.prev = prev;
			prev = curr;
			curr = curr.next;
		}
		curr.prev = prev;
		curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}

		return head;
	}

	public static void main(String[] args) {

		AlternateSwappingOfDoubleNodes a = new AlternateSwappingOfDoubleNodes();
		Node first, second;
		Node head = a.createList();

		first = head;
		second = first.next;
		if (second != null)
			head = second;
		System.out.println();
		while (second != null) {
			Node third = second.next;
			Node fourth = second.next != null ? second.next.next : null;
			first.next = fourth == null ? third : fourth;
			second.next = first;
			first = third;
			second = fourth;
		}

		first = head;
		while (first != null) {
			System.out.print(first.data + " ");
			first = first.next;
		}

	}
}
