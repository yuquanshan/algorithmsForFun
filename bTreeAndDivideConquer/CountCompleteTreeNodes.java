/**
 * Given a complete binary tree, count the number of nodes.
 *
 * public int countNodes(TreeNode root)
 */

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if (root == null) return 0;
		int height = height(root);
		if (height == 0) return 1;
		int start = 0;
		int end = (1 << height) - 1;
		while(end - start > 1) {
			int mid = start + (end - start)/2;
			if (hasleaf(root, mid, height)) start = mid;
			else end = mid;
		}
		if (hasleaf(root, end, height)) return (1 << height) + end;
		else return (1 << height) + start;
	}

	private int height(TreeNode root) {
		if (root.left == null) return 0;
		return 1 + height(root.left);
	}

	private boolean hasleaf(TreeNode root, int code, int depth) {
		if (depth == 0) return true;
		int mask = 1 << (depth - 1);
		if ((code&mask) == 0) {
			if (root.left == null) return false;
			return hasleaf(root.left, code, depth - 1);
		} else {
			if (root.right == null) return false;
			return hasleaf(root.right, code, depth - 1);
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		CountCompleteTreeNodes test = new CountCompleteTreeNodes();
		System.out.println(test.countNodes(root));
	}
}