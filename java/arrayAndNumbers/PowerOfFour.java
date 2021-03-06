/** Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
* Example:
* Given num = 16, return true. Given num = 5, return false.
* Follow up: Could you solve it without loops/recursion?
* public boolean isPowerOfFour(int num)
*/

public class PowerOfFour{
	public boolean isPowerOfFour(int num){
		// num == num & (-num) means num's first binary 1 is the only 1 in num 
		return num > 0 && num == (num & (-num)) && (0x55555555 & num) != 0;
	}
}