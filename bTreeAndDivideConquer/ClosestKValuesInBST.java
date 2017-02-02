/** Given a non-empty binary search tree and a target value, 
* find k values in the BST that are closest to the target.
* Note:
* Given target value is a floating point.
* You may assume k is always valid, that is: k ≤ total nodes.
* You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
* Follow up:
* Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
* public List<Integer> closestKValues(TreeNode root, double target, int k)
*/
import java.util.*;

public class ClosestKValuesInBST{
	public static List<Integer> closestKValues(TreeNode root, double target, int k){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		inorder(root, target, stack1);	// get all element smaller than target
		reverseinorder(root, target, stack2);	// get all element larger than or equal to target
		int count = 0;
		while(count < k && !(stack1.isEmpty() && stack2.isEmpty())){
			if(stack1.isEmpty()){
				res.add(stack2.pop());
			}else if(stack2.isEmpty()){
				res.add(stack1.pop());
			}else{
				int tmp = (target - stack1.peek() < stack2.peek() - target)?stack1.pop():stack2.pop();
				res.add(tmp);
			}
			count++;
		}
		return res;
 	}
	public static void inorder(TreeNode root, double target, Stack<Integer> stack){
		if(root == null)
			return;
		inorder(root.left, target, stack);
		if(root.val >= target)
			return;
		stack.push(root.val);
		inorder(root.right, target, stack);
	}
	public static void reverseinorder(TreeNode root, double target, Stack<Integer> stack){
		if(root == null)
			return;
		reverseinorder(root.right, target, stack);
		if(root.val < target)
			return;
		stack.push(root.val);
		reverseinorder(root.left, target, stack);
	}
	public static void main(String[] args) {
		double target = 12.8;
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		TreeNode node1 = new TreeNode(13); TreeNode node2 = new TreeNode(10);
		root.right = node1;
		node1.left = node2;
		node2.right = new TreeNode(12);
		node1.right = new TreeNode(20);
		/*
				5
			   / \
			  1   13
			      / \
			    10  20
			      \
			      12
		*/
		int k = 3;
		List<Integer> res = closestKValues(root, target, k);
		System.out.println(res.toString());
	}
}