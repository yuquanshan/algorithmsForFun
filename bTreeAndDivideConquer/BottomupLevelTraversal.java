/**
* return the bottom-up level order traversal of a binary tree.
* public static ArrayList<ArrayList<Integer>> bottomupLevel(TreeNode root)
*/

import java.util.*;

public class BottomupLevelTraversal{
	public static ArrayList<ArrayList<Integer>> bottomupLevel(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(root == null)
			return res;
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while(queue.size() != 0){
			int len = queue.size();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i = 0; i < len; i++){
				TreeNode tmp = queue.remove(0);
				list.add(tmp.val);
				if(tmp.left != null)
					queue.add(tmp.left);
				if(tmp.right != null)
					queue.add(tmp.right);
			}
			res.add(0,list);
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("The bottom-up level traversal is " + bottomupLevel(root));
	}
	
}