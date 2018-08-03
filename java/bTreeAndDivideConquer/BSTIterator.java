/**
* given a BST, invent an iterator (BSTIterator) which visits nodes in-order 
* and has two methods, 
* next() 		-	return the next node to be visited;
* hasNext()	- 	return if there is next node to be visited.
*/
import java.util.*;

public class BSTIterator{
	private Stack<TreeNode> stack = new Stack<TreeNode>();	// the top of the stack is the result of next()
	BSTIterator(TreeNode root){
		// initiate the stack
		stack.push(root);
		while(stack.peek().left != null){
			stack.push(stack.peek().left);
		}
	}
	public TreeNode next(){
		if(this.hasNext()){
			TreeNode res = stack.pop();	// result is just the top of the stack
			// the tricky thing is how to update the stack
			if(res.right != null){
				stack.push(res.right);
				while(stack.peek().left!=null) // keep left
					stack.push(stack.peek().left);
			}
			return res;
		}
		return null;
	}
	public boolean hasNext(){
		return !stack.empty()&&stack.peek()!=null;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(6);
		root.right = new TreeNode(11);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(12);
		/*
					8
				   / \
				  5   11
				 / \  / \
				1  7 10  12
				  /
				 6
		*/
		BSTIterator iter = new BSTIterator(root);
		while(iter.hasNext()){
			System.out.println("Visit: " + iter.next().val);
		}
	}
}