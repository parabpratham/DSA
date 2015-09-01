package study.dsa.tree;

import java.util.Stack;

import study.dsa.tree.TreeWithInnerNode.Node;

public class TraversalNonRecursion {

	TreeWithInnerNode t = new TreeWithInnerNode();

	public static void main(String[] args) {

		TraversalNonRecursion tra = new TraversalNonRecursion();

		// System.out.println(tra.createTreeForSumEquals());
		tra.t.fiiledTreeForDiaWithOP();
		System.out.println("\nInorder Using stack");
		tra.inorder(tra.t.root);
		System.out.println("\nInorder Using Morris Threaded Tree");
		tra.inorderUsingMorrisThreadedTree(tra.t.root);
		System.out.println("\nPreorder");
		tra.preorder(tra.t.root);
		System.out.println("\nPreorder Using Morris Threaded Tree");
		tra.preorderUsingMorrisThreadedTree(tra.t.root);
		System.out.println("\nPostorder");
		tra.postorder(tra.t.root);
		System.out.println();
		// tra.printPathsRecur(tra.t.root, "");

	}

	private void postorder(Node root) {
		// Check for empty tree
		if (root == null)
			return;

		Stack<Node> stack = new Stack<TreeWithInnerNode.Node>();
		do {
			// Move to leftmost node
			while (root != null) {
				// Push root's right child and then root to stack.
				if (root.right != null)
					stack.push(root.right);

				stack.push(root);

				// Set root as root's left child
				root = root.left;
			}

			// Pop an item from stack and set it as root
			root = stack.pop();

			// If the popped item has a right child and the right child is not
			// processed yet, then make sure right child is processed before
			// root
			if (root.right != null && !stack.isEmpty()
					&& stack.peek() == root.right) {
				stack.pop(); // remove right child from stack
				stack.push(root); // push root back to stack
				root = root.right; // change root so that the right
									// child is processed next
			} else // Else print root's data and set root as NULL
			{
				System.out.print(root.data + " ");
				root = null;
			}
		} while (!stack.isEmpty());
	}

	// Print all the paths from root to leaf
	public void printPathsRecur(Node node, String path) {

		if (node == null) {
			System.out.println(path);
			return;
		}
		path = path + "" + node.data;

		if (node.left == null && node.right == null) {
			System.out.println(path);
		} else {
			printPathsRecur(node.left, path);
			printPathsRecur(node.right, path);
		}

	}

	// http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
	public boolean createTreeForSumEquals() {
		TreeWithInnerNode t = new TreeWithInnerNode();
		Node root = t.new Node(10);
		root.left = t.new Node(8);
		root.right = t.new Node(2);
		root.left.left = t.new Node(3);
		root.left.right = t.new Node(5);
		root.right.left = t.new Node(2);

		return pathsSumEqulsRecur(root, 18, 0);
	}

	// return true if the sum of nodes from root to leaf is given data
	public boolean pathsSumEqulsRecur(Node node, int data, int fromParent) {

		if (node == null)
			return false;

		if (node.left == null && node.right == null) {
			return fromParent + node.data == data;
		}

		fromParent += node.data;

		if (!pathsSumEqulsRecur(node.left, data, fromParent))
			return pathsSumEqulsRecur(node.right, data, fromParent);

		return true;
	}

	// Preorder iterative
	public void preorder(Node root) {
		Stack<Node> sc = new Stack<TreeWithInnerNode.Node>();
		sc.add(root);
		while (!sc.isEmpty()) {
			Node node = sc.pop();
			System.out.print(node.data + " ");
			if (node.right != null)
				sc.push(node.right);
			if (node.left != null)
				sc.push(node.left);
		}

	}

	// http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
	public void inorder(Node root) {
		Stack<Node> sc = new Stack<TreeWithInnerNode.Node>();
		Node node = root;
		while (!sc.isEmpty() || node != null) {
			// Traverse till left node is null
			// push the nodes in between
			while (node != null) {
				sc.add(node);
				node = node.left;
			}
			// pop and print
			System.out.print((node = sc.pop()).data + " ");

			// set next node as right of current
			node = node.right;
		}

	}

	// http://www.geeksforgeeks.org/morris-traversal-for-preorder/
	public void preorderUsingMorrisThreadedTree(Node root) {
		Stack<Node> sc = new Stack<TreeWithInnerNode.Node>();
		sc.push(root);
		Node current = root;
		Node pre;
		while (current != null) {

			// If left child is null, print the current node data. Move to
			// right child.
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				// If the right child of inorder predecessor already points to
				// this node
				if (pre.right == current) {
					pre.right = null;
					current = current.right;
				}

				// If right child doesn't point to this node, then print this
				// node and make right child point to this node
				else {
					System.out.print(current.data + " ");
					pre.right = current;
					current = current.left;
				}
			}
		}
	}

	public void inorderUsingMorrisThreadedTree(Node root) {
		Stack<Node> sc = new Stack<TreeWithInnerNode.Node>();
		sc.push(root);
		Node current = root;
		Node pre;
		while (current != null) {
			if (current.left == null) {
				System.out.print(current.data + " ");
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original
				 * tree i.e., fix the right child of predecssor
				 */
				else {
					pre.right = null;
					System.out.print(current.data + " ");
					current = current.right;
				} /* End of if condition pre.right == NULL */
			} /* End of if condition current.left == NULL */
		}
	}
}
