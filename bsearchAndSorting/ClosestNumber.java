/**
* given a sorted arrary and a target number, find the index of a number which is closest 
* to the target. return -1 if target doesn't exist.
* public int closestNumber(int[] A, int target)
*/

public class ClosestNumber{
	public static int closestNumber(int[] A, int target){
		if(A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length-1;
		while(end - start > 1){
			int mid = start + (end - start)/2;
			if(A[mid] == target){
				start = mid;
				break;
			}
			else if(A[mid] < target)
				start = mid;
			else
				end = mid;
		}
		int res = (target-A[start]<A[end]-target)?start:end;
		return res;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3};
		int t = 2;
		System.out.println("Array1's closest position to " + t +" is " + closestNumber(array,t));
		int[] array2 = {1,4,6};
		t = 3;
		System.out.println("Array2's closest position to " + t +" is " + closestNumber(array2,t));
	}
}