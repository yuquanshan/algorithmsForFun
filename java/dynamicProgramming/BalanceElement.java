/**
* given an array, find the index of a balance element
* such that the sum of elements on its left equals the 
* sum of elements on its right.
* public static int balanceElement(int[] array)
*/

public class BalanceElement{
	public static int balanceElement(int[] array){
		if(array == null || array.length == 0)
			return -1;
		int[] leftSum = new int[array.length];
		int[] rightSum = new int[array.length];
		leftSum[0] = 0;
		rightSum[array.length-1] = 0;
		for(int i = 1; i<array.length-1; i++)
			leftSum[i] = leftSum[i-1]+array[i-1];
		for(int i = array.length-2; i>=0; i--)
			rightSum[i] = rightSum[i+1]+array[i+1];
		for(int i = 0; i<array.length; i++){
			if(leftSum[i] == rightSum[i]){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,5,1,2,3};
		System.out.format("The position of one balance element is %d\n",balanceElement(array));
	}
}