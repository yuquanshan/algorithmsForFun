/**
* given an array and list containing a set of intervals, return a list 
* containing the minimum numbers in those ranges.
* public static ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries)
*/

import java.util.*;

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SegmentTreeNode{
	public SegmentTreeNode left, right;
	public int start, end, min;
	public SegmentTreeNode(int start, int end, int min){
		this.start = start;
		this.end = end;
		this.min = min;
		this.left = null;
		this.right = null;
	}
}

public class IntervalMinQueries{
	public static ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries){
		if(A == null || A.length == 0 || queries == null || queries.size() == 0)
			return null;
		SegmentTreeNode root = buildMinSegTree(A,0,A.length-1);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(Interval itv: queries){
			res.add(query(root, itv.start, itv.end));
		}
		return res;
	}
	public static SegmentTreeNode buildMinSegTree(int[] A, int start, int end){
		if(start == end){
			return new SegmentTreeNode(start,end,A[start]);
		}
		SegmentTreeNode root = new SegmentTreeNode(start,end,0);
		int mid = start+(end-start)/2;
		SegmentTreeNode left = buildMinSegTree(A, start, mid);
		SegmentTreeNode right = buildMinSegTree(A, mid+1, end);
		root.left = left;
		root.right = right;
		root.min = Math.min(left.min,right.min);
		return root;
	}
	public static int query(SegmentTreeNode root, int start, int end){
		if(root.start > end || root.end < start)
			return Integer.MAX_VALUE;
		if(root.start == start && root.end == end)
			return root.min;
		int leftMin = Integer.MAX_VALUE;
		int rightMin = Integer.MAX_VALUE;
		if(root.left != null && root.left.end >= start)
			leftMin = query(root.left, Math.max(start,root.left.start), Math.min(end,root.left.end));
		if(root.right != null && root.right.start <= end)
			rightMin = query(root.right, Math.max(start,root.right.start), Math.min(end,root.right.end));
		return Math.min(leftMin,rightMin);
	}
	public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7};
		ArrayList<Interval> queries = new ArrayList<Interval>();
		queries.add(new Interval(0,0));
		queries.add(new Interval(1,5));
		System.out.format("The query results are %s\n",intervalMinNumber(A, queries).toString());
	}
}