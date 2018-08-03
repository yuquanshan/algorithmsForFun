/**
* given a binary tree, return the max path sum. the path can start and end in any node.
* public Tuple maxPathSumPlus(TreeNode root)
*/

public class UndirectedMaxSum{
	private static int currMax = 0;
	public static int maxPathSum(TreeNode root){
		if(root == null)
			return 0;
		currMax = root.val;
		maxPathSumPlus(root);
		return currMax;
	}
	public static Tuple maxPathSumPlus(TreeNode root){	// if root is the pivot node (/'\) of the path, return the maximum left and right path (starting from itself)
		Tuple res = new Tuple(0,0);
		if(root == null)
			return res;
		Tuple leftTuple = maxPathSumPlus(root.left);
		Tuple rightTuple = maxPathSumPlus(root.right); 
		int maxRight = Math.max(0,Math.max(rightTuple.x,rightTuple.y));	// the outer Max.max determine whether include root's right node to the path
		int maxLeft = Math.max(0,Math.max(leftTuple.x,leftTuple.y));
		if(root.val + maxRight + maxLeft > currMax)
			currMax = root.val + maxRight + maxLeft;
		res.x = maxLeft + root.val;
		res.y = maxRight + root.val;
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println("The maximum path sum is " + maxPathSum(root));
	}
}