/**
* given an sorted rotated array with all identical numbers, find the index of target value 
* public int search(int[] A, int target)
*/

public class SearchRotSortedArray{
	public static int search(int[] A, int target){
		if(A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		boolean lefty = (target > A[A.length-1]); 	// if the target is on the left side of the cliff or not
		while(end - start > 1){
			int mid = start + (end - start)/2;
			if (A[mid] == target)
				return mid;
			if(lefty){
				if(A[mid]>target || A[mid]<A[0])
					end = mid;
				else
					start = mid;
			}else{
				if(A[mid]<target || A[mid]>A[A.length-1])
					start = mid;
				else
					end = mid;
			}
		}
		if(A[start] == target){
			return start;
		}else if(A[end] == target){
			return end;
		}else{
			return -1;
		}

	}
	public static void main(String[] args) {
		int[] array = {4,5,1,2,3};
		int t = 1;
		int res = search(array, t);
		if(res >= 0){
			System.out.println("The position of " + t +" is " + res + ".");
		}else{
			System.out.println("Cannot find " + t +".");
		}
		t = 0;
		res = search(array,t);
		if(res >= 0){
			System.out.println("The position of " + t +" is " + res + ".");
		}else{
			System.out.println("Cannot find " + t +".");
		}
	}
}