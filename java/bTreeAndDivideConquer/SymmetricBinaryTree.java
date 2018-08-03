/**
* given a binary tree, check if the binary tree is symmetric.
*
* public boolean isSymmetric(TreeNode root)
*/

// can do BFS

public class SymmetricBinaryTree{
	public static boolean isSymmetric(TreeNode root){
		if(root == null)
			return true;
		return areSymmetric(root.left,root.right);
	}
	public static boolean areSymmetric(TreeNode a, TreeNode b){
		if(a == null && b == null)
			return true;
		if(a == null || b == null)
			return false;
		if(a.val == b.val)
			return areSymmetric(a.left,b.right) && areSymmetric(a.right,b.left);
		return false;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		/*
				1
			   / \
			  2   2
			 / \ / \
			3  4 4  3
		*/
		if (isSymmetric(root)) {
			System.out.println("The tree is symmetric.");
		}else{
			System.out.println("The tree is not symmetric.");
		}
	}
}