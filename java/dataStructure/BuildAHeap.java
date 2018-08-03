/**
* given an array, turn it into a min heap.
* public static void heapify(int[] A)
*/
import java.util.*;

public class BuildAHeap{
	public static void heapify(int[] A){
		if(A != null && A.length > 1){
			for(int i = (A.length-2)/2; i>=0; i--){
				heapDown(A,i);
			}
		}
	} 
	public static void heapDown(int[] A, int i){
		if(A.length > 1 && i*2+1 < A.length){
			int left = i*2+1;
			if(i*2+2 < A.length){
				int right = i*2+2;
				if(A[i] > Math.min(A[left],A[right])){
					if(A[left]<=A[right]){
						int mid = A[left];
						A[left] = A[i];
						A[i] = mid;
						heapDown(A,left);
					}else{
						int mid = A[right];
						A[right] = A[i];
						A[i] = mid;
						heapDown(A,right);
					}
				}
			}else{
				if(A[left] < A[i]){
					int mid = A[left];
					A[left] = A[i];
					A[i] = mid;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {3,2,1,4,5};
		System.out.format("The array is %s.\n",Arrays.toString(nums));
		heapify(nums);
		System.out.format("The heapified array is %s.\n",Arrays.toString(nums));
	}
}