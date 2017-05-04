/**
* search a range of a number in a sorted array (there may exit 
* consecutive positions with the same value)
* public int[] searchRange(int[] A, int target)
*/

import java.util.*;

public class SearchForRange{
	public static int[] searchRange(int[] A, int target){
		int[] res = new int[2];
		if(A == null || A.length == 0){
			res[0] = -1;
			res[1] = -1;
			return res;
		} 
		// first find such a target
		int start = 0;
		int end = A.length - 1;
		int mid=0;
		while(end - start > 1){
			mid = start + (end - start)/2;
			if(A[mid]==target){
				break;
			}else if(A[mid]>target){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(A[mid] == target){
			res[0] = findLeft(A,start,mid,target);
			res[1] = findRight(A,mid,end,target);
			return res;
		}else if(A[start] == target){
			res[0] = start;
			res[1] = start;
			return res;
		}else if(A[end] == target){
			res[0] = end;
			res[1] = end;
			return res;
		}else{
			res[0] = -1;
			res[1] = -1;
			return res;
		}
	}
	public static int findLeft(int[] A, int start, int end, int target){	// try to find the first position
		while(end-start>1){
			int mid = start + (end-start)/2;
			if (A[mid]< target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(A[start]==target)
			return start;
		else 
			return end; 
	}
	public static int findRight(int[] A, int start, int end, int target){ 	// try to find the last position
		while(end-start>1){
			int mid = start + (end - start)/2;
			if (A[mid] > target){
				end = mid;
			}else{
				start = mid;
			}
		}
		if(A[end]==target)
			return end;
		else
			return start;
	}

	public static void main(String[] args) {
		int[] array = {5,7,7,8,8,10};
		int t = 8;
		int[] result = searchRange(array,t);
		System.out.println("The range of " + t + " is (" + result[0] + "," + result[1]+").");
	}
}