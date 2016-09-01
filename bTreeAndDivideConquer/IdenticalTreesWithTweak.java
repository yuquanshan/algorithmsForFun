/**
define a tweak of tree as
	A       A
   / \     / \
  B   C   C   B
determine whether two trees are identical or not, despite of tweaks.
assuming there is no two nodes with the same value in a tree.
*/

public class IdenticalTreesWithTweak{
	public static boolean isIdent(TreeNode a, TreeNode b){
		if(a == null && b == null)
			return true;
		else if(a == null || b == null)
			return false;
		if(a.val == b.val){
			return (isIdent(a.left,b.left) || isIdent(a.left,b.right)) && (isIdent(a.right,b.right) || isIdent(a.right,b.left));
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.left.left = new TreeNode(4);
		root1.right = new TreeNode(3);
		/*
				1
			   / \
			  2   3
			 /
			4
		*/
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(2);
		root2.right.left = new TreeNode(4);
		/*
				1
			   / \
			  3   2
			     /
			    4
		*/
		if(isIdent(root1,root2))
			System.out.println("Two trees are identical.");
		else
			System.out.println("Two trees are not identical.");
	}
}

