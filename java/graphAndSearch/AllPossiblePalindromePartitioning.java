/**
* given a string, find all possible palindrome partitioning of 
* the string. 
*  public static List<List<String>> partition(String s) 
*/
import java.util.*;

public class AllPossiblePalindromePartitioning{
    public static List<List<String>> partition(String s){
        if(s == null || s.length() == 0)
            return new ArrayList<List<String>>();
        List<List<String>> res = new ArrayList<List<String>>();
        if(s.length() == 1){
            List<String> list = new ArrayList<String>();
            list.add(s);
            res.add(list);
            return res;
        }
        for(int i = 0; i<s.length(); i++){
            if(palindrome(s,0,i)){
                String substr = s.substring(0,i+1);
                List<List<String>> tmp = partition(s.substring(i+1,s.length()));
                if(tmp.size() == 0){
                    List<String> list = new ArrayList<String>();
                    list.add(substr);
                    tmp.add(list);
                }else{
                    for(int j = 0; j < tmp.size(); j++){
                        tmp.get(j).add(0,substr);
                    }   

                }
                res.addAll(tmp);
            }
        }
        return res;
    }
    public static boolean palindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "aa";
        List<List<String>> res = partition(s);
        System.out.format("All possible Palindrome partitioning of %s are: \n",s);
        for(int i = 0; i<res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}