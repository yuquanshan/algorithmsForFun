/**
* given an array of digits representing a integer, e.g.,
* [1,2,3] represents 123. return an array of digits representing 
* the input number plus one.
* public static int[] plusOne(int[] digits)
*/
import java.util.*;

public class PlusOne{
	public static int[] plusOne(int[] digits) {
        // Write your code here
        if(digits == null)
            return null;
        int[] res = new int[digits.length+1];
        int pass = 1;
        int pt = 0;
        while(pt < digits.length){
            res[res.length-1-pt] = (digits[digits.length-1-pt]+pass)%10;
            pass = (digits[digits.length-1-pt]+pass)/10;
            pt++;
        }
        if(pass == 0)
            return Arrays.copyOfRange(res,1,res.length);
        else{
            res[0] = pass;
            return res;
        }
    }
    public static void main(String[] args) {
    	int[] input = {9,9,9};
    	System.out.format("%s plus one is %s\n", Arrays.toString(input), Arrays.toString(plusOne(input)));
    }
}