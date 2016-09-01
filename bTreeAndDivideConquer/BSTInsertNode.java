/**
insert a node in BST.
*/

public class BSTInsertNode{
	public static TreeNode insertNode(TreeNode root, TreeNode node){
		if(root == null || node == null)
			return node;
		TreeNode currNode = root;
		TreeNode prevNode = root;
		while(currNode != null){
			prevNode = currNode;
			if(currNode.val > node.val)
				currNode = currNode.left;
			else if(currNode.val < node.val)
				currNode = currNode.right;
			else
				break;
		}
		if(currNode != null)
			return root;
		if(prevNode.val > node.val)
			prevNode.left = node;
		else if (prevNode.val < node.val)
			prevNode.right = node;
		return root;
	}
	public static void preorderPrint(TreeNode root){
		if(root != null){
			System.out.println(root.val);
			preorderPrint(root.left);
			preorderPrint(root.right);
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		System.out.println("The preordered print of new tree is: ");
		preorderPrint(insertNode(root,new TreeNode(6)));
	}
}