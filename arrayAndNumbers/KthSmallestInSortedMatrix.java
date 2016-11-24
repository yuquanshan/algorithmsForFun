/**
* given a both row-wise and column-wise sorted matrix,
* find the K th smallest number in it.
* public static int kthSmallest(int[][] matrix, int k)
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

public class KthSmallestInSortedMatrix{
	public static int kthSmallest(int[][] matrix, int k){
		int n = matrix.length;
		int m = matrix[0].length;	/* to achieve optiamlity you should also 
									compare n and m to determine whether you
									want to work on row or column */
		PriorityQueue<HeapBag> heap = new PriorityQueue<HeapBag>(n,new Comparator<HeapBag>(){
			public int compare(HeapBag b1, HeapBag b2){
				return b1.val - b2.val;
			}
		});
		int count = 0;
		int[] heads = new int[n];
		for(int i = 0; i<n; i++){
			heads[0] = 0;
			heap.add(new HeapBag(matrix[i][0],i));
		}
		int num=0;
		while(count<k){
			HeapBag tmp = heap.poll();
			num = tmp.val;
			int index = tmp.ind;
			if(heads[index] < m-1){
				heads[index] = heads[index]+1;
				heap.add(new HeapBag(matrix[index][heads[index]],index));
			}
			count++;
		}
		return num;
	}
	public static void main(String[] args) {
		int[][] matrix = {{1 ,5 ,7},{3 ,7 ,8},{4 ,8 ,9}};
		int k = 4;
		System.out.format("The %dth smallest element in the matrix is %d.\n",k,kthSmallest(matrix,k));
	}
}