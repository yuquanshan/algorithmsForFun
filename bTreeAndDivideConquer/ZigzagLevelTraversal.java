/**
given a binary tree, return the result of its zigzag level traversal,
first left to right then right to left and so on. 
*/
import java.util.*;

public class ZigzagLevelTraversal{
	public static ArrayList<ArrayList<Integer>> zigzag(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return res;
		ArrayList<TreeNode> doublestack = new ArrayList<TreeNode>();
		doublestack.add(root);
		boolean toggle = true; 	// true means right to left, false means left to right
		while(doublestack.size() != 0){
			ArrayList<Integer> list = new ArrayList<Integer>();
			if(toggle){
				int len = doublestack.size();
				for(int i=0; i<len; i++){
					TreeNode tmp = doublestack.remove(len-1-i);
					if(tmp.right != null)
						doublestack.add(tmp.right);
					if(tmp.left != null)
						doublestack.add(tmp.left);
					list.add(0,tmp.val);
				}
				toggle = false;
			}else{
				int len = doublestack.size();
				for(int i=0; i<len; i++){
					TreeNode tmp = doublestack.remove(len-1-i);
					if(tmp.left != null)
						doublestack.add(tmp.left);
					if(tmp.right != null)
						doublestack.add(tmp.right);
					list.add(0,tmp.val);
				}
				toggle = true;
			}
			res.add(list);
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("The Zigzag level traversal is " + zigzag(root));
	}
}