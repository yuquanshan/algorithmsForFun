/**
 * Given a binary tree, count the number of uni-value subtrees.
 *
 * A Uni-value subtree means all nodes of the subtree have the same value.
 *
 * For example:
 * Given binary tree,
 *             5
 *            / \
 *           1   5
 *          / \   \
 *         5   5   5
 * return 4.
 *
 * public int countUnivalSubtrees(TreeNode root)
 */

public class CountUnivalueSubtrees {
	class Pod {
		public int num;
		public boolean univalue;
	}
	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) return 0;
		Pod res = helper(root);
		return res.num;
	}
	// returns 1. how many unival subtrees under this root; 
	// 2. whether this subtree itself is a unival tree
	private Pod helper(TreeNode root) {	 
		Pod res = new Pod();
		res.univalue = false;
		if (root == null) {
			res.num = 0;
			res.univalue = true;
			return res;
		}
		Pod left = helper(root.left);
		Pod right = helper(root.right);
		res.num = left.num + right.num;
		if (left.univalue && (root.left == null || root.left.val == root.val)
			&& right.univalue && (root.right == null 
				|| root.right.val == root.val)) {
			res.num++;
			res.univalue = true;
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(5);
		CountUnivalueSubtrees test = new CountUnivalueSubtrees();
		System.out.println(test.countUnivalSubtrees(root));
	}
}