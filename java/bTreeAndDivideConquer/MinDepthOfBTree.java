/**
* get the min depth of binary tree.
* public int minDepth(TreeNode root)
*/

public class MinDepthOfBTree{
	public static int minDepth(TreeNode root){
		if(root == null)
			return 0;
		int leftMinDepth = minDepth(root.left);
		int rightMinDepth = minDepth(root.right);
		return Math.min(leftMinDepth+1,rightMinDepth+1);
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		/*
			1
		   / \
		  2	  3
		  	 / \
		  	4   5
		*/
		System.out.println("The min depth of the binary tree is "+minDepth(root));
	}
}