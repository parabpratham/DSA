package study.dsa.tree;

import java.util.ArrayList;

import study.dsa.tree.TreeWithInnerNode.Node;

public class TreeFromTraversal {

	public static void main(String[] args) {
		TreeFromTraversal tree = new TreeFromTraversal();
		TreeWithInnerNode treeFromPreIn = tree.getTreeFromPreIn(
				"0 1 3 6 7 10 13 14 4 8 11 12 15 2 5 9",
				"6 3 13 10 14 7 1 4 11 8 12 15 0 2 5 9");
		TreeViewer.printTree(treeFromPreIn.root);
	}

	public TreeWithInnerNode getTreeFromPreIn(String preArray, String inoArray) {
		TreeWithInnerNode t = new TreeWithInnerNode();
		String[] inoSplit = inoArray.split(" ");
		String[] preSplit = preArray.split(" ");

		java.util.List<String> inoList = new ArrayList<String>(inoSplit.length);
		java.util.List<String> preList = new ArrayList<String>(inoSplit.length);
		for (int i = 0; i < inoSplit.length; i++) {
			inoList.add(inoSplit[i]);
			preList.add(preSplit[i]);
		}

		t.root = getTreeFromPreIn(t, t.root, inoList, preList);
		return t;
	}

	private Node getTreeFromPreIn(TreeWithInnerNode t, Node node,
			java.util.List<String> inoList, java.util.List<String> preList) {

		if (inoList.size() == 0)
			return null;
		
		node = t.new Node(Integer.parseInt(preList.get(0) + ""));
		if (inoList.size() == 1)
			return node;

		int indexPre = -1, indexIno = -1;
		indexIno = inoList.indexOf(preList.get(0));
		indexPre = indexIno + 1;

		Node left = getTreeFromPreIn(t, node, inoList.subList(0, indexIno),
				preList.subList(1, indexPre));
		Node right = getTreeFromPreIn(t, node,
				inoList.subList(indexIno + 1, inoList.size()),
				preList.subList(indexPre, preList.size()));
		node.left = left;
		node.right = right;
		return node;
	}
}
