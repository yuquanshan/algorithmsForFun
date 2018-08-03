/**
* given a segment tree with max value built in BuildSegTreeOnArray.java,
* find the max value in a index interval [start,end].
* Definition of SegmentTreeNode:
* public class SegmentTreeNode {
*     public int start, end, max;
*     public SegmentTreeNode left, right;
*     public SegmentTreeNode(int start, int end, int max) {
*         this.start = start;
*         this.end = end;
*         this.max = max;
*         this.left = this.right = null;
*     }
* }
* public static int query(SegmentTreeNode root, int start, int end)
*/
import java.util.*;

class SegmentTreeNode {
	public int start, end, max;
	public SegmentTreeNode left, right;
	public SegmentTreeNode(int start, int end, int max) {
	 this.start = start;
	 this.end = end;
	 this.max = max;
	 this.left = this.right = null;
	}
}

public class QuerySegTree{
	public static int query(SegmentTreeNode root, int start, int end){
		if(root == null || start > end || start > root.end || end < root.start )
			return Integer.MIN_VALUE;
		if(start <= root.start && end >= root.end)
			return root.max;
		int leftMax = Integer.MIN_VALUE;
		int rightMax = Integer.MIN_VALUE;
		if(start <= root.left.end){
			leftMax = query(root.left,Math.max(start,root.left.start),Math.min(end,root.left.end));
		}
		if(end >= root.right.start){
			rightMax = query(root.right,Math.max(start,root.right.start),Math.min(end,root.right.end));
		}
		return Math.max(leftMax,rightMax);
	}
}