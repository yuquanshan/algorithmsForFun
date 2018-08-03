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
	// the evicted root cannot be larger than the current node (definitely on
	// the right tree of the evicted root), e.g., the pattern like 5...9...3 
	// cannot happen
	public boolean verifyPreorder(int[] preorder) {	// stack, O(lgn) space
		if (preorder == null || preorder.length == 0) return true;
		// the top of the stack is the first root whose left tree is what the 
		// current node resides
		Stack<Integer> stack = new Stack<Integer>();
		int largestexpelled = Integer.MIN_VALUE;
		for (int i = 0; i < preorder.length; i++) {
			while (!stack.isEmpty() && stack.peek() < preorder[i]) {
				int tmp = stack.pop();
				if (tmp > largestexpelled) largestexpelled = tmp;
			}
			if (preorder[i] < largestexpelled) return false;
			stack.push(preorder[i]);
		}
		return true;
	}
	// similar to first solution, but use the array's space as stack
	public boolean verifyPreorder2(int[] preorder) {
		if (preorder == null || preorder.length == 0) return true;
		int top = -1;	// top of the slides
		int largestexpelled = Integer.MIN_VALUE;
		for (int i: preorder) {
			while (top >= 0 && preorder[top] < i) 
				largestexpelled = preorder[top--];
			if (i < largestexpelled) return false;
			preorder[++top] = i;
		}
		return true;
	}
}
