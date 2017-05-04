/** 
* find the last position of a target number of sorted array,
* return -1 if target doesn't exist.
* public int lastPosition(int[] A, int target)
*/

public class LastPositionOfTarget{
	public static int lastPosition(int[] A, int target){
		if(A == null || A.length == 0)
			return -1;
		int start = 0;
		int end = A.length - 1;
		while(end - start > 1){
			int mid = start + (end - start)/2;
			if (A[mid] <= target) {
				start = mid;
			}else{
				end = mid;
			}
		}
		if(A[start]!=target && A[end]!=target)
			return -1;
		else if(A[end] == target)
			return end;
		else
			return start;
	}

	public static void main(String[] args) {
		int[] array = {1,2,2,4,5,5};
		int t1 = 2;
		int t2 = 5;
		int t3 = 6;
		System.out.println("Last position of " + t1 + " is " + lastPosition(array,t1));
		System.out.println("Last position of " + t2 + " is " + lastPosition(array,t2));
		System.out.println("Last position of " + t3 + " is " + lastPosition(array,t3));
	}
}