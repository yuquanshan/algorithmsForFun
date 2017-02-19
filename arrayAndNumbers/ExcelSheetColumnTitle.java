/** Given a positive integer, return its corresponding column 
* title as appear in an Excel sheet.
*
* For example:
*
*    1 -> A
*    2 -> B
*    3 -> C
*    ...
*    26 -> Z
*    27 -> AA
*    28 -> AB
* public String convertToTitle(int n)
*/
import java.util.*;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if(n == 0) return "";
        StringBuilder sb = new StringBuilder();
        while(n != 0){
        	n -= 1;
        	int rem = n % 26;
        	sb.insert(0, (char)('A' + rem));
        	n = n / 26;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
    	int n = 28;
    	System.out.println(convertToTitle(n));
    }
} 