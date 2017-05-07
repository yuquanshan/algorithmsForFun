/**
* find all elements x such that k1<=x<=k2 in binary search tree.
*
* public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2)
*/
import java.util.*;
public class SearchRangeInBST{
	public static ArrayList<Integer> searchRange(TreeNode root, int k1, int k2){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		if(root.val > k2)
			return searchRange(root.left, k1, k2);
		if(root.val < k1)
			return searchRange(root.right, k1, k2);
		// k1 <= root.val <= k2
		ArrayList<Integer> leftRange = searchRange(root.left,k1,k2);
		ArrayList<Integer> rightRange = searchRange(root.right,k1,k2);
		res.addAll(leftRange);
		res.add(root.val);
		res.addAll(rightRange);
		return res;
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.right = new TreeNode(22);
		int k1 = 10;
		int k2 = 22;
		System.out.println("The elements in range ["+k1+","+k2+"] is (are) " + searchRange(root,k1,k2));
	}
}