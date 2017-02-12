/** Given a roman numeral, convert it to an integer.
* Input is guaranteed to be within the range from 1 to 3999.
* public int romanToInt(String s)
*/
import java.util.*;

public class RomanToInt {
    public static int romanToInt(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        int res = 0;
        int work = 0;
        for(int i = 0; i < s.length(); i++) {
        	int tmp = singleToInt(s.charAt(i));
        	if(work == 0){
        		work = tmp;
        	}else if(work < tmp) {
        		res += tmp - work;
        		work = 0;
        	}else if(work > tmp){
        		res += work;
        		work = tmp;
        	}else{
        		work += work;
        	}
        }
        return res + work;
    }
    private static int singleToInt(char c){
    	if(c == 'I')
        	return 1;
        else if(c == 'V')
        	return 5;
        else if(c == 'X')
        	return 10;
        else if(c == 'L')
        	return 50;
        else if(c == 'C')
        	return 100;
        else if(c == 'D')
        	return 500;
        else if(c == 'M')
        	return 1000;
        return 0;
    }
    public static void main(String[] args) {
    	String str = "MCMXCVI";
    	System.out.println(romanToInt(str));
    }
}