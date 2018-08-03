/**
* find the minimum element in rotated identical sorted array
* public int findMin(int[] num)
*/

public class MinInRotSortedArray{
	public static int findMin(int[] num){
		if(num == null || num.length == 0){
			return -999999;
		}
		int start = 0;
		int end = num.length-1;
		if(num[end] >= num[start])	// if the array has only one element or no cliff at all
			return num[start];
		while(end - start > 1){		// else there is a cliff, find it!
			int mid = start+(end-start)/2;
			if (num[mid] > num[start]) {
				start = mid;
			}else{
				end = mid;
			}
		}
		if(num[end]>num[start])
			return num[start];
		else
			return num[end];
	}
	public static void main(String[] args) {
		int[] array1 = {0,1,2,3,4,5,6};
		System.out.println("The minimum number of array 1 is "+findMin(array1));
		int[] array2 = {4,5,6,7,0,1,2};
		System.out.println("The minimum number of array 2 is "+findMin(array2));
	}
}