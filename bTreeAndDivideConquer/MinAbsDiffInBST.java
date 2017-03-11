/** Given a binary search tree with non-negative values, find the 
* minimum absolute difference between values of any two nodes.
*
* Example:
*
* Input:
*
*   1
*    \
*     3
*    /
*   2
* 
* Output:
* 1
*
* Explanation:
* The minimum absolute difference is 1, which is the difference 
* between 2 and 1 (or between 2 and 3).
*
* public int getMinimumDifference(TreeNode root)
*/
import java.util.*;

public class MinAbsDiffInBST {
    public int getMinimumDifference(TreeNode root) {
        int res = Integer.MAX_VALUE;
        if(root == null) return res;
        if(root.left != null) res = Math.min(res, helper(root.left, root.val, Integer.MIN_VALUE/2));
        if(root.right != null) res = Math.min(res, helper(root.right, Integer.MAX_VALUE, root.val));
        return res;
    }
    private int helper(TreeNode root, int max, int min) {
    	int res = Math.min(max - root.val, root.val - min);
    	if(root.left != null) res = Math.min(res, helper(root.left, root.val, min));
        if(root.right != null) res = Math.min(res, helper(root.right, max, root.val));
        return res;
    }
}