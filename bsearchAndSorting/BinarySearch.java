/**
* use binary search to find a target in a sorted array,
* return -1 if target doesn't exist in the array.
* public int search(int[] A, int target)
*/

public class BinarySearch{
	public static int search(int[] A, int target){
		if(A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		while(end - start > 1){
			int mid = start + (end - start)/2;
			if(A[mid] == target)
				return mid;
			else if(A[mid] < target)
				start = mid;
			else
				end = mid;
		}
		if (A[start] == target)
			return start;
		if (A[end] == target)
			return end;
		return -1;
	}
	public static void main(String[] args) {
		int[] array = {1,2,2,4,5,5};
		int t = 4;
		System.out.println("The position of " + t + " is " + search(array,4)+".");
	}
}