/** Given a sorted array, remove the duplicates in place such that 
* each element appear only once and return the new length.
*
* Do not allocate extra space for another array, you must do this 
* in place with constant memory.
*
* For example,
* Given input array nums = [1,1,2],
*
* Your function should return length = 2, with the first two elements 
* of nums being 1 and 2 respectively. It doesn't matter what you leave 
* beyond the new length.
*
* public int removeDuplicates(int[] nums)
* 
* follow up:
* Follow up for "Remove Duplicates":
* What if duplicates are allowed at most twice?
*
* For example,
* Given sorted array nums = [1,1,1,2,2,3],
* Your function should return length = 5, with the first five elements 
* of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond 
* the new length.
*
* public int removeDuplicatesII(int[] nums)
*/

public class RemoveDuplicates{
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int tmp = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(tmp != nums[i]) {
                tmp = nums[i];
                nums[len++] = tmp;
            }
        }
        return len;
    }
    public int removeDuplicatesII(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int tmp = nums[0];
        int repeat = 1;
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(tmp != nums[i]) {
                tmp = nums[i];
                nums[len++] = tmp;
                repeat = 1;
            }else if(repeat == 1) {
                repeat++;
                nums[len++] = tmp;
            }
        }
        return len;
    }
}


