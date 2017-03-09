/**
* You need to find the largest value in each row of a binary tree.
*
* Example:
* Input: 
*
*          1
*         / \
*        3   2
*       / \   \  
*      5   3   9 
*
* Output: [1, 3, 9]
*
* public List<Integer> largestValues(TreeNode root) 
*/
import java.util.*;

public class LargestValueInEachTreeRow {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			int largest = Integer.MIN_VALUE;
			for(int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				largest = largest>tmp.val?largest:tmp.val;
				if(tmp.left != null) queue.add(tmp.left);
				if(tmp.right != null) queue.add(tmp.right);
			}
			res.add(largest);
		}
		return res;
	}
}