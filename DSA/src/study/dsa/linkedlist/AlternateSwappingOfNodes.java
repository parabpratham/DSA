package study.dsa.linkedlist;

public class AlternateSwappingOfNodes {

	public class Node {
		public int data;
		public Node next;

		public Node(int data) {
			this.data = data;
		}
	}

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
