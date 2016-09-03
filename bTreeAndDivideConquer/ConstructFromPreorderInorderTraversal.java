/**
build a binary tree from the in-order and pre-order traversals of the tree.
*/

public class ConstructFromPreorderInorderTraversal{
	public static TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder == null && inorder == null)
			return null;
		if(preorder.length == 0 && inorder.length == 0)
			return null;
		int value = preorder[0];
		int left = 0;
		while(inorder[left] != value)
			left++;
		int[] leftpreorder = new int[left];
		int[] leftinorder = new int[left];
		for(int i=1; i <= left; i++){
			leftpreorder[i-1] = preorder[i];
			leftinorder[i-1] = inorder[i-1];
		}
		TreeNode leftTree = buildTree(leftpreorder,leftinorder);
		int[] rightpreorder = new int[inorder.length-1-left];
		int[] rightinorder = new int[inorder.length-1-left];
		int j = 0;
		left++;
		while(left <= inorder.length-1){
			rightinorder[j] = inorder[left];
			rightpreorder[j] = preorder[left];
			left++;
			j++;
		}
		TreeNode rightTree = buildTree(rightpreorder,rightinorder);
		TreeNode res = new TreeNode(value);
		res.left = leftTree;
		res.right = rightTree;
		return res;
	}
	public static void main(String[] args) {
		int[] inorder = {1,2,3};
		int[] preorder = {2,1,3};
		TreeNode node = buildTree(preorder,inorder);
	}
}