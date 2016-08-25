/**
Given a binary tree, find its maximum depth.
*/

public class MaxDepthOfBTree{
	public static int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		int leftSideLen = (root.left==null)?1:(1 + maxDepth(root.left));
		int rightSideLen = (root.right==null)?1:(1+maxDepth(root.right));
		if(leftSideLen>rightSideLen)
			return leftSideLen;
		else
			return rightSideLen;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println("The max depth of the binary tree is " + maxDepth(root));
	}
}