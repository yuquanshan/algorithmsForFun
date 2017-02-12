/** The count-and-say sequence is the sequence of integers beginning as follows:
* 1, 11, 21, 1211, 111221, ...
*
* 1 is read off as "one 1" or 11.
* 11 is read off as "two 1s" or 21.
* 21 is read off as "one 2, then one 1" or 1211.
* Given an integer n, generate the nth sequence.
*
* Note: The sequence of integers will be represented as a string.
*
* public String countAndSay(int n)
*/

public class CountAndSay {
    public static String countAndSay(int n) {
        if(n == 0)
            return null;
        return helper("1", n - 1);
    }
    private static String helper(String str, int n){
        if(n == 0)
            return str;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < str.length()){
            int count = 1;
            while(i < str.length() - 1 && str.charAt(i + 1) == str.charAt(i)){
                count++;
                i++;
            }
            sb.append(Integer.toString(count));
            sb.append(str.charAt(i));
            i++;
        }
        return helper(sb.toString(), n - 1);
    }
    public static void main(String[] args) {
    	System.out.println(countAndSay(4));
    }
}