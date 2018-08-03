/**
* given two sorted integer arrays, find the kth smallest sum out of all possible sums.
* public static int kthSmallestSum(int[] A, int[] B, int k)
* (failed to give an efficient algorihtm for the first time)
*/

import java.util.*;

class HeapBag{
	public int val;
	public int ind;
	public HeapBag(int val, int ind){
		this.val = val;
		this.ind = ind;
	}
}

public class KthSmallestTwoSumInTwoSortedArrays{	// can reduce to kth elements in sorted matrix
	public static int kthSmallestSum(int[] A, int[] B, int k){
		int cap = Math.min(A.length,B.length);
		PriorityQueue<HeapBag> heap = new PriorityQueue<HeapBag>(cap,new Comparator<HeapBag>(){
			public int compare(HeapBag b1, HeapBag b2){
				return b1.val - b2.val;
			}
		});
		if(A.length <= B.length){
			int[] heads = new int[A.length];
			for(int i = 0; i < A.length; i++){
				heads[i] = 0;
				heap.add(new HeapBag(B[0]+A[i],i));
			}
			int count = 0;
			int res = 0;
			while(count < k){
				HeapBag tmp = heap.poll();
				res = tmp.val;
				count++;
				if(heads[tmp.ind] < B.length-1){
					heads[tmp.ind] = heads[tmp.ind]+1;
					heap.add(new HeapBag(B[heads[tmp.ind]]+A[tmp.ind],tmp.ind));
				}
			}
			return res;
		}else{
			int[] heads = new int[B.length];
			for(int i = 0; i < B.length; i++){
				heads[i] = 0;
				heap.add(new HeapBag(A[0]+B[i],i));
			}
			int count = 0;
			int res = 0;
			while(count < k){
				HeapBag tmp = heap.poll();
				res = tmp.val;
				count++;
				if(heads[tmp.ind] < A.length-1){
					heads[tmp.ind] = heads[tmp.ind]+1;
					heap.add(new HeapBag(A[heads[tmp.ind]]+B[tmp.ind],tmp.ind));
				}
			}
			return res;
		}
	}
	public static void main(String[] args) {
		int[] A = {1,7,11};
		int[] B = {2,4,6};
		int k = 7;
		System.out.format("The %dth smallest two-sum in %s and %s is %d.\n",k,Arrays.toString(A),Arrays.toString(B),kthSmallestSum(A,B,k));
	}
}