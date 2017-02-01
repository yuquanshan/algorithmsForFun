/**
* given a binary tree, find the length of the longest consecutive 
* sequence path. for example, given 
*   1
*    \
*     3
*    / \
*   2   4
*        \
*         5
* return 3, for 3-4-5.
* public static int longestConsecutive(TreeNode root){}
*/
import java.util.*;

public class LongestConsecutivePathInBinaryTree{
	public static int longestConsecutive(TreeNode root){
		if(root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> state = new Stack<Integer>();
		Stack<Integer> streak = new Stack<Integer>();
		stack.push(root);
		state.push(0);
		streak.push(1);
		int longestSoFar = 1;
		while(!stack.isEmpty()){
			if(state.peek() == 2){
				stack.pop();
				state.pop();
				streak.pop();
			}else if(state.peek() == 0){
				state.pop();
				state.push(1);
				if(stack.peek().left != null){
					int tmp = stack.peek().val;
					stack.push(stack.peek().left);
					state.push(0);
					if(tmp+1 == stack.peek().val){
						streak.push(streak.peek()+1);
						longestSoFar = Math.max(longestSoFar,streak.peek());
					}else{
						streak.push(1);
					}
				}
			}else{
				state.pop();
				state.push(2);
				if(stack.peek().right != null){
					int tmp = stack.peek().val;
					stack.push(stack.peek().right);
					state.push(0);
					if(tmp+1 == stack.peek().val){
						streak.push(streak.peek()+1);
						longestSoFar = Math.max(longestSoFar,streak.peek());
					}else{
						streak.push(1);
					}
				}
			}
		}
		return longestSoFar;
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		node1.left = node2;
		node2.left = node3;
		node2.right = node4;
		node4.right = node5;
		System.out.println(longestConsecutive(node1));
	}
}