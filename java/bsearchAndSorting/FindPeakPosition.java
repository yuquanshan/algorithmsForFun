/**
* find the position of one of the peak element(s) in an array A such that
*	1. elements are all adjacently identical;
*	2. A[0]<A[1] && A[A.length-2] > A[A.length-1].
* peak point with position p is the point that A[p-1] < A[p] > A[p+1].
* public int findPeakPos(int[] A)
*/

public class FindPeakPosition{
	public static int findPeakPos(int[] A){
		if(A.length < 3)
			return -1;
		int start = 0;
		int end = A.length-1;
		while(true){	// I'm sure the loop will always break...
			int mid = start + (end - start)/2;
			if (A[mid]>A[mid-1] && A[mid]>A[mid+1]) {
				return mid;
			}else if (A[mid]<A[mid-1]){
				end = mid;
			}else{
				start = mid;
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {1,2,1,3,4,5,7,6};
		System.out.println("One of the peak position is "+findPeakPos(array));		
	}
}