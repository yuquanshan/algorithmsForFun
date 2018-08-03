/* Given n non-negative integers representing an elevation map where 
* the width of each bar is 1, compute how much water it is able to trap after raining.
* 
* For example, 
* Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

public class TrapWater1D{
	public static int trapwater(int[] height){
		if(height == null || height.length == 0)
            return 0;
		int left = 0;
		int lefthighest = height[left];
		int leftlen = 0;
		int leftsum = 0;
		int right = height.length-1;
		int righthighest = height[right];
		int rightlen = 0;
		int rightsum = 0;
		int water = 0;
		while(left < right){
			if(lefthighest <= righthighest){
				if(lefthighest <= height[left+1]){
					water += lefthighest*leftlen - leftsum;
					leftlen = 0;
					leftsum = 0;
					lefthighest = height[left+1];
				}else{
					leftlen++;
					leftsum += height[left+1];
				}
				left++;
			}else{
				if(righthighest <= height[right-1]){
					water += righthighest*rightlen-rightsum;
					rightlen = 0;
					rightsum = 0;
					righthighest = height[right-1];
				}else{
					rightlen++;
					rightsum += height[right-1];
				}
				right--;
			}
		}
		return water;
	} 
	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trapwater(height));
	}
}