package study.dsa.tree;

public class LargestBSTinBT {

	// https://www.youtube.com/watch?v=4fiDs7CCxkc&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu

	public class Output {

		boolean isTree;
		int left;
		int right;
		int numberOfElemnts;

		@Override
		public String toString() {
			return isTree + " " + left + " " + right + " " + numberOfElemnts;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeWithInnerNode t = new TreeWithInnerNode();
		t.fiiledTreeForDia();
		Output o = postTraversal(t.root);
		System.out.println(o);
	}

	/**
	 * @param node
	 * @return
	 */
	private static Output postTraversal(TreeWithInnerNode.Node node) {

		if (node.left == null && node.right == null) {
			Output o = new LargestBSTinBT().new Output();
			o.isTree = true;
			o.left = node.data;
			o.right = node.data;
			o.numberOfElemnts = 1;
			System.out.println(node.data + " -- " + o);
			return o;
		}

		Output leftNode = null, rightNode = null;
		if (node.left != null)
			leftNode = postTraversal(node.left);

		if (node.right != null)
			rightNode = postTraversal(node.right);

		Output output = new LargestBSTinBT().new Output();
		int count = 1;
		output.left = node.data;
		output.right = node.data;
		output.isTree = true;
		if (leftNode != null && leftNode.isTree) {
			if (leftNode.right < node.data) {
				output.left = leftNode.left;
				count += leftNode.numberOfElemnts;
			} else {
				output.left = 0;
				output.right = 0;
				output.numberOfElemnts = Math.max(leftNode.numberOfElemnts,
						rightNode != null ? rightNode.numberOfElemnts : 1);
				output.isTree = false;
				System.out.println(node.data + " -- " + output);
				return output;
			}

		}

		if (rightNode != null && rightNode.isTree) {
			if (rightNode.left > node.data) {
				output.right = rightNode.right;
				count += rightNode.numberOfElemnts;
			} else {
				output.left = 0;
				output.right = 0;
				output.numberOfElemnts = Math.max(rightNode.numberOfElemnts,
						leftNode != null ? leftNode.numberOfElemnts : 1);
				output.isTree = false;
				System.out.println(node.data + " -- " + output);
				return output;
			}
		}
		output.numberOfElemnts = count;
		System.out.println(node.data + " -- " + output);
		return output;
	}
}
