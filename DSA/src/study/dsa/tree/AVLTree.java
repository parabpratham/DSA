package study.dsa.tree;

public class AVLTree {

	TreeNode head = null;
	int n = 0;

	public AVLTree() {
	}

	/*
	 * Diff for BST
	 */
	public TreeNode addNode(int data) {

		if (head == null) {
			head = new TreeNode(data, null, null);
			head.parent = null;
			return head;
		}
		TreeNode temp = head;
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

	public int setAVLTree(TreeNode node) {

		int noLe = 0;
		int noRt = 0;
		if (node.left == null && node.right == null) {
			node.value = 0;
			System.out.println(node.data + " -- " + node.value);
			return 1;
		}
		if (node.left != null)
			noLe = setAVLTree(node.left);
		if (node.right != null)
			noRt = setAVLTree(node.right);
		node.value = noLe - noRt;

		System.out.println(node.data + " -- " + node.value);

		return Math.max(noRt, noLe) + 1;

	}

	public boolean checkAVLTree() {
		setAVLTree(head);
		return checkNode(head);
	}

	private boolean checkNode(TreeNode node) {

		if (node == null)
			return true;

		if (node.value < -1 || node.value > 1)
			return false;

		if (checkNode(node.left))
			return checkNode(node.right);
		else
			return true;
	}

}
