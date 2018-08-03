/**
* given an integer array, the elements range from 0 to 10000, 
* for each element A[i] in the array, 
* return the number of elements before A[i] smaller than it.
* public static ArrayList<Integer> countOfSmallerNumberII(int[] A)
* (accidentally saw the hint for the first time, time's up)
*/
import java.util.*;

public class CountOfSmallerBefore{
	static class SegTreeNode{
		int left;
		int right;
		int count;	// the count of elements in the range [left,right] so far
		SegTreeNode leftRoot, rightRoot;
		SegTreeNode(int left, int right){
			this.left = left;
			this.right = right;
			this.count = 0;
			this.leftRoot = null;
			this.rightRoot = null;
		}
	}
	public static ArrayList<Integer> countOfSmallerNumberII(int[] A){
		if(A == null || A.length == 0)
			return new ArrayList<Integer>();
		SegTreeNode root = buildSegTree(0,10000);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 0; i<A.length; i++){
			seepDown(root,A[i]);
			int tmp = query(root,0,A[i]-1);
			res.add(tmp);
		}
		return res;
	}
	public static void seepDown(SegTreeNode root, int num){	// seep the number down to its range
		if(root == null || root.left > num || root.right < num)
			return;
		root.count++;
		int mid = (root.left+root.right)/2;
		if(num <= mid)
			seepDown(root.leftRoot,num);
		else
			seepDown(root.rightRoot,num);
	}
	public static int query(SegTreeNode root, int start, int end){	// query the count in the range [start,end]
		if(root == null || start > root.right || root.left > end)
			return 0;
		if(root.left == start && root.right == end)
			return root.count;
		int mid = (root.left+root.right)/2;
		if(start > mid)
			return query(root.rightRoot,start,Math.min(root.right,end));
		if(end <= mid)
			return query(root.leftRoot,Math.max(start,root.left),end);
		else
			return query(root.leftRoot,Math.max(start,root.left),mid)+query(root.rightRoot,mid+1,Math.min(root.right,end));
	}
	public static SegTreeNode buildSegTree(int left, int right){
		if(left == right){
			SegTreeNode res = new SegTreeNode(left,right);
			return res;
		}else{
			SegTreeNode res = new SegTreeNode(left,right);
			int mid = (left+right)/2;
			SegTreeNode lroot = buildSegTree(left,mid);
			SegTreeNode rroot = buildSegTree(mid+1,right);
			res.leftRoot = lroot;
			res.rightRoot = rroot;
			return res;
		}
	}
	public static void main(String[] args) {
		int[] A = {1,2,7,8,5};
		ArrayList<Integer> res = countOfSmallerNumberII(A);
		System.out.format("Given %s, the result is %s\n", Arrays.toString(A), res.toString());
	}
}