/**
given a binary tree, return the values of nodes level by level.
*/

// BSF for sure
import java.util.*;

public class LevelOrderTraversal{
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){	// basic BFS
			int currLen = queue.size();
			ArrayList<Integer> newLevel = new ArrayList<Integer>();
			for(int i = 0; i < currLen; i++){
				TreeNode temp = queue.remove(0);	// work like a queue
				newLevel.add(temp.val);
				if(temp.left != null)
					queue.add(temp.left);
				if(temp.right != null)
					queue.add(temp.right);
			}
			res.add(newLevel);
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		ArrayList<ArrayList<Integer>> levelList = levelOrder(root);
		System.out.println("The level order lists are " + levelList);
	}
}