/**
given a binary search tree and a node, find the inorder successor of that node.
definition of inorder successor see http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
*/

public class BSTInOrderSuccessor{
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p){
		if(root == null || p == null)
			return null;
		TreeNode candidateSoFar = null;	// candidate on upstream
		TreeNode curr = root;
		while(curr != p){
			if(curr.val > p.val){
				candidateSoFar = curr;
				curr = curr.left;
			}else{
				curr = curr.right;
			}
		}
		curr = p.right;
		while(curr != null){
			candidateSoFar = curr;
			curr = curr.left;
		}
		return candidateSoFar;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		/*
			2
		   / \
		  1   3
		*/
		TreeNode res1 = inorderSuccessor(root,node1);
		TreeNode res2 = inorderSuccessor(root,root);
		System.out.println("The successor of "+node1.val+" is "+res1.val+"; the successor of "+root.val+" is "+res2.val+".");
	}
}