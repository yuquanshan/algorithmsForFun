/** Given an integer, write a function to determine if it is a power of two.
* public boolean isPowerOfTwo(int n)
*/

public class PowerOfTwo{
	public static boolean isPowerOfTwo(int n){
		for(int i = 0; i<31; i++){
			if(n == 1<<i)
				return true;
		}
		return false;
	}
}