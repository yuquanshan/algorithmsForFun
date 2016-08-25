/**
Given a balanced tree, determine if it's balanced or not.
For every node, if the depths of its two subtrees never differ by more than 1. 
*/
// TreeNode is defined in MaxDepthOfBTree.java

public class BalancedBinaryTree{
	public static boolean isBalanced(TreeNode root){
		if(root == null)
			return true;
		return (Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right));
	}

	public static int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		int leftSideLen = (root.left==null)?1:(1 + maxDepth(root.left));
		int rightSideLen = (root.right==null)?1:(1 + maxDepth(root.right));
		if(leftSideLen>rightSideLen)
			return leftSideLen;
		else
			return rightSideLen;
	}

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);
		/*
				3 (root1)
			   / \
			  9  20
			     / \
			    15  7
		*/
		if(isBalanced(root1))
			System.out.println("Tree 1 is a balanced tree.");
		else
			System.out.println("Tree 1 is not a balanced tree."); 

		TreeNode root2 = new TreeNode(3);
		root2.right = new TreeNode(20);
		root2.right.right = new TreeNode(7);
		root2.right.left = new TreeNode(15);
		/*
				3 (root2)
				 \
				 20
				 / \
				15  7
		*/
		if(isBalanced(root2))
			System.out.println("Tree 2 is a balanced tree.");
		else
			System.out.println("Tree 2 is not a balanced tree.");

		TreeNode root3 = new TreeNode(3);
		root3.left = new TreeNode(9);
		root3.left.left = new TreeNode(15);
		root3.left.left.left = new TreeNode(4);
		root3.right = new TreeNode(20);
		root3.right.right = new TreeNode(7);
		root3.right.right.right = new TreeNode(5);
		/*
				3 (root3)
			   / \
			  9  20
			 / 	   \
			15      7
			/        \
		   4 		  5
		*/
		if(isBalanced(root3))
			System.out.println("Tree 3 is a balanced tree.");
		else
			System.out.println("Tree 3 is not a balanced tree.");

	}
}