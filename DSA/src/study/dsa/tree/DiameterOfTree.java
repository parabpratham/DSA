package study.dsa.tree;

public class DiameterOfTree {

	/*
	 * Diameter of tree is defined as A longest path or route between any two
	 * nodes in a tree. The path may or may not for through the root.
	 * 
	 * @Diameter(T) = max( Diameter(T.left), Diameter(T.right),
	 * Height(T.left)+Height(T.right)+1 )
	 */

	private static class Data {
		public int height;
		public int diameter;
	}

	private static void diameter(TreeWithInnerNode.Node root, Data d) {
		if (root == null) {
			d.height = 0;
			d.diameter = 0;
			return;
		}
		// get data in left subtree
		diameter(root.left, d);
		int hLeft = d.height + 1;
		int dLeft = d.diameter;

		// get data in right subtree
		diameter(root.right, d);
		int hRight = d.height + 1;
		int dRight = d.diameter;

		// diameter = max(lt+rt+1,max(dl,rl))
		d.diameter = Math.max(hLeft + hRight + 1, Math.max(dLeft, dRight));
		d.height = Math.max(hLeft, hRight);
	}

	public static void main(String[] args) {

		DiameterOfTree.Data data = new DiameterOfTree.Data();
		TreeWithInnerNode t = new TreeWithInnerNode();
		t.fiiledTreeForDia();
		diameter(t.root, data);
		System.out.println();
		System.out.println(data.diameter);

	}
}
