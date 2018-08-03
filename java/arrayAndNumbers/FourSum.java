/**
* given an array, find all unique quadruplets in the array 
* which gives the sum of a target, must arrange the output in ascending order.
* public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target)
* (failed to reach this in the first time)
*/

import java.util.*;

public class FourSum{
	public static ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target){
		if(numbers == null || numbers.length < 4)
			return new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);
		int start = 0;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		while(start < numbers.length-3){
			int start1 = start+1;
			while(start1 < numbers.length-2){
				int left = start1+1;
				int right = numbers.length-1;
				while(left < right){
					if(numbers[start]+numbers[start1]+numbers[left]+numbers[right]==target){
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(numbers[start]);
						list.add(numbers[start1]);
						list.add(numbers[left]);
						list.add(numbers[right]);
						res.add(list);
						int mid = numbers[right];
						while(left < right && numbers[right]==mid)
							right--;
					}else if(numbers[start]+numbers[start1]+numbers[left]+numbers[right]<target){
						int mid = numbers[left];
						while(left < right && numbers[left]==mid)
							left++;
					}else{
						int mid = numbers[right];
						while(left < right && numbers[right]==mid)
							right--;
					}
				}
				int mid = numbers[start1];
				while(start1 < numbers.length-2 && numbers[start1]==mid)
					start1++;
			}
			int mid = numbers[start];
			while(start < numbers.length-3 && numbers[start]==mid)
				start++;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] numbers = {1,0,-1,0,2,2};
		int target = 0;
		ArrayList<ArrayList<Integer>> res = fourSum(numbers,target);
		for(ArrayList<Integer> l: res){
			System.out.println(l.toString());
		}
	}
}