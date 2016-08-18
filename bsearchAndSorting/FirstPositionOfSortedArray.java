/**
given a sorted array with non-identical elements, find the first position of a target
*/

public class FirstPositionOfSortedArray{
	public static int binarySearch(int[] nums, int target){
		if(nums == null || nums.length == 0)
			return -1;
		int start = 0;
		int end = nums.length-1;
		while(end-start > 1){	// find any position with that target
			int mid = start + (end - start)/2;
			System.out.println("start="+start+" end="+end);
			if (nums[mid] >= target){	// not stop when find the target, we are going to find the first one!
				end = mid;
			}else{
				start = mid;
			}
		}
		System.out.println("start="+start+" end="+end);
		if(nums[start] == target){
			return start;
		}else if(nums[end] == target){
			return end;
		}else{
			return -1;
		}
	}
	public static void main(String[] args) {
		int[] testarray = {2,6,8,13,15,17,18,19,20};
		int target = 15;
		int res = binarySearch(testarray,target);
		if(res == -1){
			System.out.println("Cannot find it!");
		}else{
			System.out.println("First position is "+res);
		}
	}
}