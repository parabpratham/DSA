package study.dsa.tree;

import study.dsa.tree.TreeWithInnerNode.Node;

public class NodeSumAsSumOfChildren {

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
		TreeWithInnerNode t = new TreeWithInnerNode();
		Node root = t.new Node(10);
		root.left = t.new Node(8);
		root.right = t.new Node(2);
		root.left.left = t.new Node(3);
		root.left.left.left = t.new Node(12);
		root.left.right = t.new Node(5);
		root.right.right = t.new Node(6);
		root.right.right.right = t.new Node(7);
		convertToChildrenSumTree(root);

		System.out.println(checkNodesForSum(root));
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

	public static void main(String[] args) {
		NodeSumAsSumOfChildren s = new NodeSumAsSumOfChildren();
		s.createAndConvertChildrenSumTree();
	}
}
