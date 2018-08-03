/** Given a binary search tree and a node in it, 
* find the in-order successor of that node in the BST.
*
* Note: If the given node has no in-order successor in the tree, return null.
*
* public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
*/

public class BSTInorderSuccessor{
	static class TreeNode {
 		int val;
 		TreeNode left;
 		TreeNode right;
 		TreeNode(int x) { val = x; }
 	}
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		if(root == null || p == null)
			return null;
		TreeNode child = findLeftest(p.right);
		if(child != null)
			return child;
		TreeNode ancestor = null;
		TreeNode tmp = root;
		while(tmp != p){
			if(tmp.val > p.val){
	            ancestor = tmp;
				tmp = tmp.left;
			}else{
				tmp = tmp.right;
			}
		}
		return ancestor;
	}
	private TreeNode findLeftest(TreeNode root){
		if(root == null)
			return null;
		TreeNode tmp = root;
		while(tmp.left != null) tmp = tmp.left;
		return tmp;
	}
}