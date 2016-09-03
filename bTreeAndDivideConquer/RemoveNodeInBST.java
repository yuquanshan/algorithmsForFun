/**
remove a node in binary search tree while keeping the property of BST.
*/

public class RemoveNodeInBST{
	public static TreeNode remove(TreeNode root, int value){
		if(root == null)
			return null;
		if(root.val == value){
			TreeNode rep = findMin(root.right);	// find one to replace root
			if(rep == null)	// equivalent to no right branch
				return root.left;
			TreeNode newRightTree = remove(root.right,rep.val);
			rep.left = root.left;
			rep.right = newRightTree;
			return rep;
		}
		TreeNode parent = root;
		boolean isLeft = true; 	// indicate if the target node is on the left side of parent or not
		boolean found = false;
		while(parent!=null && !found){
			if(parent.val > value){
				if(parent.left != null && parent.left.val == value){
					isLeft = true;
					found = true;
				}else{
					parent = parent.left;
				}
			}else{
				if(parent.right != null && parent.right.val == value){
					isLeft = false;
					found = true;
				}else{
					parent = parent.right;
				}
			}
		}
		TreeNode node = null;
		if(!found)
			return root;
		if(isLeft){
			node = parent.left;
			parent.left = remove(node,node.val);
		}else{
			node = parent.right;
			parent.right = remove(node,node.val);
		}
		return root;
	}
	public static TreeNode findMin(TreeNode root){
		if(root == null)
			return null;
		TreeNode tmp = root;
		while(tmp.left != null)
			tmp = tmp.left;
		return tmp;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		System.out.println("The tree is: "+LevelOrderTraversal.levelOrder(root));
		int value = 3;
		System.out.println("Value to be removed: "+value);
		System.out.println("The new tree is: "+LevelOrderTraversal.levelOrder(remove(root, value)));
	}
}