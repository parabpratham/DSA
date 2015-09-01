package study.dsa.tree;

import java.util.Stack;

/**
 * @author hp
 *
 */
public class DiameterinBT {

	public static void main(String[] args) {
		TreeWithInnerNode t = new TreeWithInnerNode();
		t.fiiledTreeForDiaWithOP();
		t.fillDiameterInfo(t.root);
		System.out.println();
		t.printD(t.root, t.root.op.diameter, TreeWithInnerNode.LEFT_SUBTREE,
				new Stack<TreeWithInnerNode.Node>());

	}
}