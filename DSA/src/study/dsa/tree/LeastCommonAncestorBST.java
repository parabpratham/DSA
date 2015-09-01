package study.dsa.tree;

public class LeastCommonAncestorBST {

	public static void main(String[] args) {
		BST bst = new BST();

		int[] ips = { 8, 4, 9, 1, 2, 3, 6, 5, 1, 2 };
		for (int ip : ips)
			bst.addNode(ip);

		System.out.println(bst.lca(1, 2));

	}

}
