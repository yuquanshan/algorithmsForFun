/**
* given a string of numbers from 1 to n, with a number missing 
* find that number.
* public static int findMissing2(int n, String str)
* (failed to finish it on time for the first time due to many tiny bugs)
*/

import java.util.*;

public class FindMissingNumber{
    public static int findMissing2(int n, String str) {
        // Write your code here
        ArrayList<Integer> stack = new ArrayList<Integer>();
        ArrayList<Integer> capacity = new ArrayList<Integer>();
        ArrayList<Integer> pt = new ArrayList<Integer>();
        ArrayList<Integer> bp = new ArrayList<Integer>();   // breakpoint
        stack.add(9999);
        if(Integer.parseInt(str.substring(0,2))>n)
            capacity.add(1);
        else
            capacity.add(2);
        pt.add(0);
        bp.add(-1);
        HashSet<Integer> visited = new HashSet<Integer>();
        while(stack.size()!=n || bp.get(bp.size()-1) != str.length()-1){
            if(pt.get(pt.size()-1)==capacity.get(capacity.size()-1) || bp.get(bp.size()-1)==str.length()-1){
                int num = stack.remove(stack.size()-1);
                pt.remove(pt.size()-1);
                capacity.remove(capacity.size()-1);
                bp.remove(bp.size()-1);
                visited.remove(num);
            }else{
                int tmp = pt.remove(pt.size()-1);
                pt.add(tmp+1);
                int num = Integer.parseInt(str.substring(bp.get(bp.size()-1)+1,bp.get(bp.size()-1)+1+pt.get(pt.size()-1)));
                if(!(num < 10 && pt.get(pt.size()-1)==2) && num > 0 && !visited.contains(num)){
                    visited.add(num);
                    int cut = bp.get(bp.size()-1)+pt.get(pt.size()-1);
                    stack.add(num);
                    bp.add(cut);
                    pt.add(0);
                    if(cut == str.length()-1)
                        capacity.add(0);
                    else if(cut == str.length()-2 || Integer.parseInt(str.substring(bp.get(bp.size()-1)+1,bp.get(bp.size()-1)+3))>n)
                        capacity.add(1);
                    else
                        capacity.add(2);
                }
            }
        }
        for(int i = 1; i<=n; i++){
            if(!visited.contains(i))
                return i;
        }
        return 0;
    }
    public static void main(String[] args) {
        int n = 13;
        String str = "1110987654321213";
        System.out.format("The missing number is %d\n",findMissing2(n,str));
    }
}