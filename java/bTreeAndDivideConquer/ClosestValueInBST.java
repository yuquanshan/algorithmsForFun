/** Given a non-empty binary search tree and a target value, 
* find the value in the BST that is closest to the target.
* 
* Note:
* Given target value is a floating point.
* You are guaranteed to have only one unique value in the BST that is closest to the target.
*
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
* public int closestValue(TreeNode root, double target)
*/
import java.util.*;

public class ClosestValueInBST{
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
    public static int closestValue(TreeNode root, double target) {
        if(root.val == target)
        	return root.val;
        if(target > (double)root.val){
        	if(root.right == null)
        		return root.val;
        	int tmp = closestValue(root.right, target);
        	return (Math.abs(target - (double)root.val) < Math.abs(target - (double)tmp))? root.val: tmp;
        }
        if(target < (double)root.val){
        	if(root.left == null)
        		return root.val;
        	int tmp = closestValue(root.left, target);
        	return (Math.abs(target - (double)root.val) < Math.abs(target - (double)tmp))? root.val: tmp;
        }
        return -1;
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(2);
    	root.left = new TreeNode(1);
    	root.right = new TreeNode(3);
    	System.out.println(closestValue(root, 1.3));
    }
}