package study.dsa.tree;

import study.dsa.tree.TreeWithInnerNode.Node;

//http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/

public class CheckIfTwoTreesAreIdentical {

	public static void main(String[] args) {

		TreeWithInnerNode t1 = new TreeWithInnerNode();
		t1.fiiledTreeForDiaWithOP();

		TreeWithInnerNode t2 = new TreeWithInnerNode();
		t2.fiiledTreeForDiaWithOP();

		System.out.println(matchTrees(t1.root, t2.root) ? " Matching "
				: "Not matching");
	}

	private static boolean matchTrees(Node t1, Node t2) {

		if (t1 == null && t2 == null)
			return true;

		if (t1 == null && t2 != null)
			return false;

		if (t1 != null && t2 == null)
			return false;

		if (t1.data != t2.data)
			return false;

		boolean isMatching = matchTrees(t1.left, t2.left);

		if (!isMatching)
			return false;

		return matchTrees(t1.right, t2.right);

	}

}
