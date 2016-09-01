/**
given a binary tree, find all paths starting from root whose sum equals the target.
*/
import java.util.*;

public class FindTargetPath{
	public static List<List<Integer>> findTargetPath(TreeNode root, int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root == null)
			return res;
		if(root.val == target){
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(root.val);
			res.add(list);
		}
		// first try left branch
		List<List<Integer>> branch = findTargetPath(root.left,target-root.val);
		int numPath = branch.size();
		if(numPath > 0){
			for(int i = 0; i < numPath; i++){
				List<Integer> temp = branch.get(i);
				temp.add(0,root.val);
				res.add(temp);
			}
		}
		branch = findTargetPath(root.right,target-root.val);
		numPath = branch.size();
		if(numPath > 0){
			for(int i = 0; i < numPath; i++){
				List<Integer> temp = branch.get(i);
				temp.add(0,root.val);
				res.add(temp);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		int target = 5;
		System.out.println("The paths whose sum equals " + target + " are " + findTargetPath(root,target));
	}
}