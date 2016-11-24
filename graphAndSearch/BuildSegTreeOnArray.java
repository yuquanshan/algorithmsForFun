/**
* given an array, build a segment tree segmenting according to 
* the indices of the array, each node should also contain the 
* max number within that index interval.
*
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
* public static SegmentTreeNode build(int[] A)
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

public class BuildSegTreeOnArray{
	public static SegmentTreeNode build(int[] A){
		if(A == null || A.length == 0)
			return null;
		return buildSub(A,0,A.length-1);
	}
	public static SegmentTreeNode buildSub(int[] A, int start, int end){
		if(start > end)
			return null;
		if(start == end)
			return new SegmentTreeNode(start,end,A[start]);
		int mid = start+(end-start)/2;
		SegmentTreeNode left = buildSub(A,start,mid);
		SegmentTreeNode right = buildSub(A,mid+1,end);
		SegmentTreeNode res = new SegmentTreeNode(start,end,Math.max(left.max,right.max));
		res.left = left;
		res.right = right;
		return res;
	}
}
