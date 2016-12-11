/**
* given an integer array, implement two methods: 
* query(start,end)		-	return the sum in the range [start,end] 
* modify(index,value) 	-	replace array[index] with a new value  
*	class IntervalSum{	
*		public IntervalSum(int[] A){}
*   	public long query(int start, int end){}
*   	public void modify(int index, int value){}
* 	}
*/
import java.util.*;

public class IntervalSum{
	static class SegTreeNode{
		int start, end, sum;
		SegTreeNode left, right;
		SegTreeNode(int start, int end){
			this.start = start;
			this.end = end;
			this.sum = 0;
			this.left = null;
			this.right = null;
		}
	}
	SegTreeNode root;
	int[] array;	
	public IntervalSum(int[] A){
		root = buildTree(0,A.length-1,A);
		array = A;
	}
	private SegTreeNode buildTree(int start, int end, int[] A){
		SegTreeNode res = new SegTreeNode(start,end);
		if(start == end){
			res.sum = A[start];
			return res;
		}
		int mid = start+(end-start)/2;
		SegTreeNode left = buildTree(start,mid,A);
		SegTreeNode right = buildTree(mid+1,end,A);
		res.left = left;
		res.right = right;
		res.sum = left.sum+right.sum;
		return res;
	}
	public long query(int start, int end){
		return queryHelper(start,end,root);
	}
	private long queryHelper(int start, int end, SegTreeNode node){
		if(start > node.end || end < node.start)
			return 0;
		long res;
		int mid = node.start+(node.end-node.start)/2;
		if(end == node.end && start == node.start)
			return node.sum;
		if(end <= mid)
			return queryHelper(Math.max(start,node.start),Math.min(mid,end),node.left);
		if(start > mid)
			return queryHelper(Math.max(mid+1,start),Math.min(end,node.end),node.right);
		return queryHelper(Math.max(start,node.start),mid,node.left)+queryHelper(mid+1,Math.min(node.end,end),node.right);
	}
	public void modify(int index, int value){
		modifyHelper(index, value, root);
		if(index >= root.start && index <= root.end){
			array[index] = value;
		}
	}
	private void modifyHelper(int index, int value, SegTreeNode node){
		if(node != null && index >= node.start && index <= node.end){
			node.sum = node.sum+value-array[index];
			int mid = node.start+(node.end-node.start)/2;
			if(index <= mid)
				modifyHelper(index,value,node.left);
			else
				modifyHelper(index,value,node.right);
		}
	}
	public static void main(String[] args) {
		int[] A = {1,2,7,8,5};
		IntervalSum is = new IntervalSum(A);
		if(is.query(0,2)==10)
			System.out.println("Test1 passed!");
		is.modify(0,4);
		if(is.query(0,1)==6)
			System.out.println("Test2 passed!");
		is.modify(2,1);
		if(is.query(2,4)==14)
			System.out.println("Test3 passed!");
	}
}