package study.dsa.tree;

public class SubtreeOrNot {

	public class Node {
		public char data;
		Node left;
		Node right;

		public Node(char data) {
			this.data = data;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubtreeOrNot s = new SubtreeOrNot();
		Node T = s.new Node('a');
		T.left = s.new Node('b');
		T.right = s.new Node('d');
		T.left.left = s.new Node('c');
		T.right.right = s.new Node('e');

		Node S = s.new Node('a');
		S.left = s.new Node('b');
		S.left.left = s.new Node('c');
		S.right = s.new Node('d');

		String inorderT = inorder(T);
		String inorderS = inorder(S);

		String preorderT = preorder(T);
		String preorderS = preorder(S);

		System.out.println(isSubString(
				preorderT.substring(0, preorderT.length() - 1),
				preorderS.substring(0, preorderS.length() - 1)));

	}

	private static boolean isSubString(String T, String S) {

		String[] sSplit = S.split(",");
		String[] tSplit = T.split(",");

		int[][] op = new int[sSplit.length + 1][tSplit.length + 1];

		for (int i = 0; i < op.length; i++)
			for (int j = i; j < op[0].length; j++) {
				if (j == 0 || i == 0)
					op[i][j] = 0;

				else if (sSplit[i - 1].equalsIgnoreCase(tSplit[j - 1])) {
					op[i][j] = op[i - 1][j - 1] + 1;
					continue;
				} else
					op[i][j] = op[i - 1][j - 1];

			}

		return op[sSplit.length][tSplit.length] > sSplit.length;
	}

	public static String inorder(Node node) {

		if (node == null)
			return "";

		if (node.left == null && node.right == null)
			return node.data + ",";

		String left = inorder(node.left);
		String right = inorder(node.right);
		return left + node.data + "," + right;

	}

	public static String preorder(Node node) {

		if (node == null)
			return "";

		if (node.left == null && node.right == null)
			return node.data + ",";

		String left = preorder(node.left);
		String right = preorder(node.right);
		return node.data + "," + left + right;

	}

}
