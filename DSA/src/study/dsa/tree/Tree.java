package study.dsa.tree;

public class Tree {

	TreeNode root;

	public void display(int order) {

		switch (order) {
		case 1:
			showInorder(root);
			break;
		case 2:
			showPreorder(root);
			break;
		case 3:
			showPostorder(root);
		}
		System.out.println();
	}

	private void showPostorder(TreeNode node) {
		if (node.left != null)
			showPostorder(node.left);
		if (node.right != null)
			showPostorder(node.right);
		System.out.print(node.data + " ");
	}

	private void showPreorder(TreeNode node) {
		System.out.print(node.data + " ");
		if (node.left != null)
			showPreorder(node.left);
		if (node.right != null)
			showPreorder(node.right);
	}

	private void showInorder(TreeNode node) {
		if (node.left != null)
			showInorder(node.left);
		System.out.print(node.data + " ");
		if (node.right != null)
			showInorder(node.right);
	}
	
	
	

}
