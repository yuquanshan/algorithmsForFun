/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * public TreeNode sortedArrayToBST(int[] nums)
 */

 public class ArrayToBalancedBST {
 	public TreeNode sortedArrayToBST(int[] nums) {
 		if (nums == null || nums.length == 0) return null;
 		return helper(nums, 0, nums.length - 1);
 	}
 	public TreeNode helper(int[] nums, int start, int end) {
 		if (end < start) return null;
 		int mid = start + (end - start)/2;
 		TreeNode node = new TreeNode(nums[mid]);
 		node.left = helper(nums, start, mid - 1);
 		node.right = helper(nums, mid + 1, end);
 		return node;
 	}
 }