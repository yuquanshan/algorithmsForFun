/**
* find the Kth Largest element in N array.
* public static int KthInArrays(int[][] arrays, int k)
*/

import java.util.*;

public class KthLargestInNArrays{
	public static int KthInArrays(int[][] arrays, int k){
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
		for(int i = 0; i<arrays.length; i++){
			for(int j = 0; j<arrays[i].length; j++){
				if(heap.size() < k){
					heap.add(arrays[i][j]);
				}else{
					if(heap.peek()<arrays[i][j]){
						heap.poll();
						heap.add(arrays[i][j]);
					}
				}
			}
		}
		return heap.poll();
	}
	public static void main(String[] args) {
		int k = 4;
		int[][] arrays = {{2,4,5,1,9},{3,0,7}};
		System.out.format("The %dth largest number is %d.\n",k,KthInArrays(arrays,k));
	}
}