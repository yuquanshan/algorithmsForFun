/**
* given a binary tree, find a path from root with max sum, return the max sum.
* public int maxPathSum(TreeNode root)
*/

public class MaxPathSum{
	public static int maxPathSum(TreeNode root){
		if(root == null)
			return 0;
		int sumOFLeftSubtree = maxPathSum(root.left);
		int sumOfRightSubtree = maxPathSum(root.right);
		return Math.max(root.val,Math.max(sumOFLeftSubtree+root.val,sumOfRightSubtree+root.val));
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		/*
				1*
			   / \
			  2*   3
			 / \
			4   5*
		*/
		System.out.println("The max sum is " + maxPathSum(root1)+".");
	}
}