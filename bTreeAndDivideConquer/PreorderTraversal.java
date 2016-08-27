/**
preorder traversal of a binary tree.
*/
import java.util.*;

public class PreorderTraversal{
	public static ArrayList<Integer> preorder(TreeNode root){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;
		result.add(root.val);
		result.addAll(preorder(root.left));
		result.addAll(preorder(root.right));
		return result;
	}
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		/*
				1
			   / \
			  2   3
			 / \
			4   5
		*/
		System.out.println(preorder(root1));
	}
}