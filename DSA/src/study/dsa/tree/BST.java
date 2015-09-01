package study.dsa.tree;

import java.util.HashMap;
import java.util.Stack;

/*
 * Implementation of BST
 */

public class BST extends Tree {

	public BST() {
	}

	public TreeNode successor(TreeNode node) {

		if (root == null || (root.left == null && root.right == null))
			return null;

		TreeNode temp = node;
		if (temp.right != null) {
			return treeMinimum(temp.right);
		} else {
			Stack<TreeNode> parents = new Stack<TreeNode>();
			parents.push(root);
			TreeNode temp1 = node.data > root.data ? root.right : root.left;
			while (temp1 != null) {
				parents.push(temp1);
				if (temp1.data == node.data)
					break;
				temp1 = node.data > temp1.data ? temp1.right : temp1.left;
			}

			TreeNode parent = parents.pop();
			TreeNode gparent = parents.pop();
			if (gparent.left != null && gparent.left.data == parent.data) {
				System.out.println(gparent.data);
				return parent;
			}
			while (!parents.empty()) {
				parent = gparent;
				gparent = parents.pop();
				if (gparent.left != null && gparent.left.data == parent.data)
					System.out.println(gparent.data);

			}
			return parent;
		}
	}

	public void deleteNode(TreeNode node) {
		TreeNode temp = root;
		TreeNode parent = null;
		int leftRt = 0; // 0-> Left 1->Right
		while (node.data != temp.data) {
			parent = temp;
			if (node.data < temp.data) {
				temp = temp.left;
				leftRt = 0;
			}

			else {
				temp = temp.right;
				leftRt = 1;
			}
		}

		if (temp.left == null && temp.right == null) {
			if (parent.left.data == temp.data)
				parent.left = null;
			else
				parent.right = null;

			return;
		}

		if (node.left != null && node.right == null) {
			parent.left = (leftRt != 0 ? node.left : node.right);
			return;
		} else if (node.left == null && node.right != null) {
			parent.right = (leftRt != 0 ? node.left : node.right);
			return;
		}

		// TreeNode succNode = successor(node);

	}

	public TreeNode treeMinimum(TreeNode head) {

		TreeNode node = head;
		while (node.left != null)
			node = node.left;

		System.out.println(node.data);
		return node;
	}

	/*
	 * Diff for BST
	 */
	public TreeNode addNode(int data) {

		if (root == null) {
			root = new TreeNode(data, null, null);
			root.parent = null;
			return root;
		}
		TreeNode temp = root;
		while (temp.left != null || temp.right != null) {
			if (temp.left != null) {
				if (data <= temp.data) {
					temp = temp.left;
					continue;
				} else if (temp.right == null)
					break;
			}
			if (temp.right != null && data <= temp.data) {
				break;
			}
			temp = temp.right;
		}
		TreeNode node = new TreeNode(data, null, null);
		if (data <= temp.data)
			temp.left = node;
		else
			temp.right = node;

		return node;
	}

	public int lca(int v1, int v2) {

		if (root == null)
			return -1;

		// search the v1, put the nodes on track in map
		TreeNode node = root;
		HashMap<Integer, TreeNode> nodes = new HashMap<Integer, TreeNode>();

		while (node != null && node.data != v1) {
			nodes.put(node.data, node);
			if (v1 > node.data)
				node = node.right;
			else
				node = node.left;

		}

		TreeNode ancestor = null;
		node = root;

		// search the v2, check if the nodes on track are in map
		// update ancestor as latest
		while (node != null && node.data != v2) {
			if (nodes.get(node.data) != null)
				ancestor = nodes.get(node.data);

			if (v2 > node.data)
				node = node.right;
			else
				node = node.left;

		}

		return ancestor.data;

	}

}
