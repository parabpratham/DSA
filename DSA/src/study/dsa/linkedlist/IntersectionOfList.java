package study.dsa.linkedlist;

public class IntersectionOfList {

	public class Node<E> {
		Integer data;
		Node<Integer> next;

		public Node(Integer n) {
			data = n;
		}
	}

	public class LinkedList<E> {

		Node<Integer> head;

		public LinkedList() {

		}

		public Node<Integer> get(Integer n) {
			Node<Integer> node = head;
			while (node.data != n && node != null)
				node = node.next;

			return node;
		}

		public int getCount() {
			int count = 1;
			Node<Integer> temp = head;
			while (temp != null) {
				temp = temp.next;
				count++;
			}
			return count;
		}

		public boolean add(Integer n) {

			if (head == null)
				head = new Node<Integer>(n);
			else {
				Node<Integer> node = head;
				while (node.next != null) {
					node = node.next;
				}
				node.next = new Node<Integer>(n);
			}
			return true;
		}
	}

	/*
	 * Method 1(Simply use two loops) Use 2 nested for loops. Outer loop will be
	 * for each node of the 1st list and inner loop will be for 2nd list. In the
	 * inner loop, check if any of nodes of 2nd list is same as the current node
	 * of first linked list. Time complexity of this method will be O(mn) where
	 * m and n are the number of nodes in two lists.
	 */

	/*
	 * Method 2 (Mark Visited Nodes) This solution requires modifications to
	 * basic linked list data structure. Have a visited flag with each node.
	 * Traverse the first linked list and keep marking visited nodes. Now
	 * traverse second linked list, If you see a visited node again then there
	 * is an intersection point, return the intersecting node. This solution
	 * works in O(m+n) but requires additional information with each node. A
	 * variation of this solution that doesn’t require modification to basic
	 * data structure can be implemented using hash. Traverse the first linked
	 * list and store the addresses of visited nodes in a hash. Now traverse the
	 * second linked list and if you see an address that already exists in hash
	 * then return the intersecting node.
	 */

	/*
	 * Method 3(Using difference of node counts) 1) Get count of the nodes in
	 * first list, let count be c1. 2) Get count of the nodes in second list,
	 * let count be c2. 3) Get the difference of counts d = abs(c1 – c2) 4) Now
	 * traverse the bigger list from the first node till d nodes so that from
	 * here onwards both the lists have equal no of nodes. 5) Then we can
	 * traverse both the lists in parallel till we come across a common node.
	 * (Note that getting a common node is done by comparing the address of the
	 * nodes)
	 */

	public static void method3() {

		IntersectionOfList ofList = new IntersectionOfList();
		LinkedList<Integer> list1 = ofList.new LinkedList<Integer>();
		LinkedList<Integer> list2 = ofList.new LinkedList<Integer>();
		fillLists(list1, list2, ofList);

		int d = list1.getCount() - list2.getCount();
		if (d < 0) {
			d = -1 * d;
			Node<Integer> l2node = list2.head;
			while (d-- == 0)
				l2node = l2node.next;

			Node<Integer> l1node = list1.head;
			boolean isFound = false;
			while (l1node != null && l2node != null) {
				if (l1node.data == l2node.data) {
					isFound = true;
					break;
				}

				l1node = l1node.next;
				l2node = l2node.next;
			}

			if (isFound)
				System.out.println(l1node.data);

		} else {
			Node<Integer> l1node = list1.head;
			while (d-- == 0)
				l1node = l1node.next;

			Node<Integer> l2node = list2.head;
			boolean isFound = false;
			while (l1node != null && l2node != null) {
				if (l1node.data == l2node.data) {
					isFound = true;
					break;
				}

				l1node = l1node.next;
				l2node = l2node.next;
			}

			if (isFound)
				System.out.println(l1node.data);

		}

	}

	/*
	 * Method 4(Make circle in first list) Thanks to Saravanan Man for providing
	 * below solution. 1. Traverse the first linked list(count the elements) and
	 * make a circular linked list. (Remember last node so that we can break the
	 * circle later on). 2. Now view the problem as find the loop in the second
	 * linked list. So the problem is solved. 3. Since we already know the
	 * length of the loop(size of first linked list) we can traverse those many
	 * number of nodes in second list, and then start another pointer from the
	 * beginning of second list. we have to traverse until they are equal, and
	 * that is the required intersection point. 4. remove the circle from the
	 * linked list.
	 */

	/*
	 * Method 5 (Reverse the first list and make equations) Thanks to Saravanan
	 * Mani for providing this method.
	 * 
	 * 1) Let X be the length of the first linked list until intersection point.
	 * Let Y be the length of the second linked list until the intersection
	 * point. Let Z be the length of the linked list from intersection point to
	 * End of the linked list including the intersection node. We Have X + Z =
	 * C1; Y + Z = C2; 2) Reverse first linked list. 3) Traverse Second linked
	 * list. Let C3 be the length of second list - 1. Now we have X + Y = C3 We
	 * have 3 linear equations. By solving them, we get X = (C1 + C3 – C2)/2; Y
	 * = (C2 + C3 – C1)/2; Z = (C1 + C2 – C3)/2; WE GOT THE INTERSECTION POINT.
	 * 4) Reverse first linked list. Advantage: No Comparison of pointers.
	 * Disadvantage : Modifying linked list(Reversing list).
	 */

	/*
	 * Method 6 (Traverse both lists and compare addresses of last nodes) This
	 * method is only to detect if there is an intersection point or not.
	 * (Thanks to NeoTheSaviour for suggesting this)
	 * 
	 * 1) Traverse the list 1, store the last node address 2) Traverse the list
	 * 2, store the last node address. 3) If nodes stored in 1 and 2 are same
	 * then they are intersecting. Time complexity of this method is O(m+n) and
	 * used Auxiliary space is O(1)
	 */

	private static void fillLists(LinkedList<java.lang.Integer> list1,
			LinkedList<java.lang.Integer> list2, IntersectionOfList ofList) {

		list1.add(3);
		list1.add(6);
		list1.add(9);
		list2.add(10);
		Node<java.lang.Integer> node = list1.get(9);
		Node<Integer> temp = ofList.new Node<Integer>(15);
		node.next = temp;
		temp = ofList.new Node<Integer>(30);
		node.next = temp;

	}

	public static void main(String[] args) {
		method3();
	}

}
