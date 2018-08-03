/**
* construct a binary tree from inorder and postorder traversals of the tree.
* public TreeNode buildTree(int[] inorder, int[] postorder)
*/

public class ConstructFromInorderPostorderTraversal{
	public static TreeNode buildTree(int[] inorder, int[] postorder){
		if(inorder == null || postorder == null)
			return null;
		if(inorder.length == 0 || postorder.length == 0)
			return null;
		int value = postorder[postorder.length-1];
		TreeNode res = new TreeNode(value);
		int left = 0;
		while(inorder[left] != value)
			left++;
		int[] leftinorder = new int[left];
		int[] leftpostorder = new int[left];
		for(int i = 0; i < left; i++){
			leftinorder[i] = inorder[i];
			leftpostorder[i] = postorder[i];
		}
		left++;
		int[] rightinorder = new int[inorder.length-left];
		int[] rightpostorder = new int[postorder.length-left];
		int j = 0;
		while(left < inorder.length){
			rightinorder[j] = inorder[left];
			rightpostorder[j] = postorder[left-1];
			left++;
			j++;
		}
		res.left = buildTree(leftinorder,leftpostorder);
		res.right = buildTree(rightinorder,rightpostorder);
		return res;
	}
	public static void main(String[] args) {
		int[] inorder = {1,2};
		int[] preorder = {2,1};
		TreeNode node = buildTree(preorder,inorder);
	}
}