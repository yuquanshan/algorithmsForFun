/** 
 * Given an array of numbers, verify whether it is the 
 * correct preorder traversal sequence of a binary search tree.
 * 
 * You may assume each number in the sequence is unique.
 * 
 * Follow up:
 * Could you do it using only constant space complexity?
 *
 * public boolean verifyPreorder(int[] preorder)
 */

import java.util.*;

public class VerifyPreorderSeqBST {
	public boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0) return true;
		Stack<Integer> stack = new Stack<Integer>();
		int largestexpelled = Integer.MIN_VALUE;
		for (int i = 0; i < preorder.length; i++) {
			while (!stack.isEmpty() && stack.peek() < preorder[i]) {
				int tmp = stack.pop();
				if (tmp > largestexpelled) largestexpelled = tmp;
			}
			if (preorder[i] < largestexpelled[i]) return false;
			stack.push(preorder[i]);
		}
		return true;
	}
}