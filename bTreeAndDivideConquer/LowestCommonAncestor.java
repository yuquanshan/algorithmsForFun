/**
* given a root and two nodes in a Binary tree, find the lowest common ancester of the two nodes.
* public TreeNode lca(TreeNode root, TreeNode A, TreeNode B)
*/

public class LowestCommonAncestor{
	public static TreeNode lca(TreeNode root, TreeNode A, TreeNode B){
		if (root == null)
			return null;
		if(root == A || root == B)
			return root;
		TreeNode left = lca(root.left,A,B);
		TreeNode right = lca(root.right,A,B);
		if(left == null && right == null)
			return null;
		if(left == null)
			return right;
		if(right == null)
			return left;
		return root;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node2.left = node3;
		node2.right = node4;
		TreeNode lca = lca(root,node1,node3);
		System.out.println("The LCA of " + node1.val + " and " + node3.val + " is "+lca.val+".");
	}
}