/**
* inorder traverse a binary tree
* public static ArrayList<Integer> inorderTraversal(TreeNode root)
*/

// do it without recursion

import java.util.*;

class StackNode{
	TreeNode node;
	int reapCount;
	StackNode(TreeNode node){
		this.node = node;
		reapCount = 0;
	}
}

public class InorderTraversal{
	public static ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		Stack<StackNode> stack = new Stack<StackNode>();
		stack.push(new StackNode(root));
		while(!stack.empty()){
			if(stack.peek().reapCount == 2){
				stack.pop();
				if(!stack.empty())
					stack.peek().reapCount++;
			}else if(stack.peek().reapCount == 1){
				res.add(stack.peek().node.val);
				if(stack.peek().node.right == null)
					stack.peek().reapCount++;
				else
					stack.push(new StackNode(stack.peek().node.right));
			}else{
				if(stack.peek().node.left == null)
					stack.peek().reapCount++;
				else
					stack.push(new StackNode(stack.peek().node.left));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println(inorderTraversal(root));
	}
}