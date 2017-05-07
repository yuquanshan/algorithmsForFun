/**
* Given a binary tree, validate if it is a BST.
* public boolean isValidBST(TreeNode root)
*/

public class ValidateBST{
	public static boolean isValidBST(TreeNode root){
		Triple res = isValidPlus(root);
		return res.x;
	}

	public static Triple isValidPlus(TreeNode root){	// return if BST, return if valid, min & max val of this tree
		if(root == null)
			return new Triple(false, 0, 0);
		boolean ifLeftValid, ifRightValid,leftGood = true,rightGood = true;
		int myMax, myMin;
		if (root.left == null){
			ifLeftValid = true;
			myMin = root.val;
			leftGood = true;
		}else{
			Triple left = isValidPlus(root.left);
			ifLeftValid = left.x;
			myMin = left.y;
			int leftMax = left.z;
			leftGood = (root.val > leftMax);
		}
		if (root.right == null){
			ifRightValid = true;
			myMax = root.val;
			rightGood = true;
		}else{
			Triple right = isValidPlus(root.right);
			ifRightValid = right.x;
			myMax = right.z;
			int rightMin = right.y;
			rightGood = (root.val < rightMin);
		}
		return new Triple(ifLeftValid&&ifRightValid&&leftGood&&rightGood,myMin,myMax);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(5);
		if(isValidBST(root))
			System.out.println("The tree is a BST.");
		else
			System.out.println("The tree is not a BST");
	}
/*
	public static int digMin(TreeNode root){	// dig out min, given local BST: left < curr < right, i.e., keep left
		if(root == null)
			return null;
		TreeNode curr = root;
		while(curr.left == null){
			curr = curr.left;
		}
		return curr.val;
	}

	public static int digMax(TreeNode root){	// dig out max, given local BST: left < curr < right, i.e., keep right
		if(root == null)
			return null;
		TreeNode curr = root;
		while(curr.right == null){
			curr = curr.right;
		}
		return curr.val;
	}
*/
}