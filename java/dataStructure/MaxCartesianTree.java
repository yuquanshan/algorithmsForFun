/**
* given an array, return a tree in which each subtree's root 
* contains the max value of that subtree. a.k.a, constructing
* a max-Cartesian tree from an array.
* public static TreeNode maxTree(int[] A){}
* (failed to give a linear algorithm until saw Wiki of Cartesian 
* tree for the first time)
*/

import java.util.*;

public class MaxCartesianTree{
	public static TreeNode maxTree(int[] A){
		if(A == null || A.length == 0)
			return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		for(int i = 0; i < A.length; i++){
			TreeNode node = new TreeNode(A[i]);
			TreeNode mid = null;
			while(!stack.isEmpty()&&stack.peek().val<A[i]){
				if(mid == null)
					mid = stack.pop();
				else{
					TreeNode tmp = stack.pop();
					tmp.right = mid;
					mid = tmp;
				}
			}
			node.left = mid;
			stack.push(node);
		}
		TreeNode root = stack.pop();
		while(!stack.isEmpty()){
			TreeNode tmp = stack.pop();
			tmp.right = root;
			root = tmp;
		}
		return root;
	}
	public static void preprint(TreeNode root){
		if(root != null){
			System.out.format("%d ",root.val);
			preprint(root.left);
			preprint(root.right);
		}
	}
	public static void main(String[] args) {
		int[] A = {2,5,6,0,3,1};
		TreeNode root = maxTree(A);
		System.out.format("The array is %s\n",Arrays.toString(A));
		System.out.format("The preorder print of tree is: ");
		preprint(root);
		System.out.println();
	}
}