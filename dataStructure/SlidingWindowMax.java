/** Given an array nums, there is a sliding window of size k which is moving 
* from the very left of the array to the very right. You can only see the 
* k numbers in the window. Each time the sliding window moves right by one position.
*
* For example,
* Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
* 
* Window position                Max
* ---------------               -----
* [1  3  -1] -3  5  3  6  7       3
*  1 [3  -1  -3] 5  3  6  7       3
*  1  3 [-1  -3  5] 3  6  7       5
*  1  3  -1 [-3  5  3] 6  7       5
*  1  3  -1  -3 [5  3  6] 7       6
*  1  3  -1  -3  5 [3  6  7]      7
* Therefore, return the max sliding window as [3,3,5,5,6,7].
*
* Note: 
* You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
* 
* Follow up:
* Could you solve it in linear time?
*/

import java.util.*;

public class SlidingWindowMax{
	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0)
            return new int[0];
    	Deque<Integer> nqueue = new LinkedList<Integer>();
    	Deque<Integer> pqueue = new LinkedList<Integer>();
    	int[] res = new int[nums.length-k+1];
    	for(int i = 0; i<nums.length; i++){
    		while(!nqueue.isEmpty() && nqueue.peekLast() <= nums[i]){
    			nqueue.removeLast();
    			pqueue.removeLast();
    		}
			if(!pqueue.isEmpty() && pqueue.peekFirst() < i - k +1){
				nqueue.removeFirst();
				pqueue.removeFirst();
			}
			nqueue.addLast(nums[i]);
    		pqueue.addLast(i);
    		if(i+1-k>=0)
    			res[i+1-k] = nqueue.peekFirst();
    	}
    	return res;
    }
    public static void main(String[] args) {
    	int[] nums = {1,3,-1,-3,5,3,6,7};
    	int k = 3;
    	int[] res = maxSlidingWindow(nums,k);
    	System.out.println(Arrays.toString(res));
    }
}