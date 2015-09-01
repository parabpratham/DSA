package study.dsa.tree;

public class TreeNode {

	int data;

	TreeNode left;

	TreeNode right;

	TreeNode parent;

	int value;// for avltree

	public TreeNode() {
	}

	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

}
