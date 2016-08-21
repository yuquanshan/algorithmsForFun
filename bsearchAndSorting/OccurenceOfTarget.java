/**
Given an sorted array, find the occurence of a target.
*/

public class OccurenceOfTarget{
	public static int totalOccurence(int[] A, int target){
		if (A == null || A.length == 0)
			return 0;
		// eww... that's SearchForRange...
		int start = 0;
		int end = A.length-1;
		int first = 0; 	// record first appearance
		int last = 0; 	// record last appearance
		while(end - start > 1){ // find first appearance
			int mid = start + (end-start)/2;
			if(A[mid]>=target)
				end = mid;
			else 
				start = mid;
		}
		if(A[start] != target && A[end] != target)
			return 0;
		else if(A[start] == target)
			first = start;
		else
			first = end;
		
		start = first; // find last appearance
		end = A.length-1;
		while(end - start > 1){
			int mid = start + (end-start)/2;
			if(A[mid]<=target)
				start = mid;
			else 
				end = mid;
		}
		if(A[end] == target){
			last = end;
		}else{
			last = start;
		}
		return last - first + 1;
	}
	public static void main(String[] args) {
		int[] array = {1,3,3,4,5};
		int t = 3;
		System.out.println("The occurence of " + t + " is " + totalOccurence(array,t));
		t = 6;
		System.out.println("The occurence of " + t + " is " + totalOccurence(array,t));
	}
}