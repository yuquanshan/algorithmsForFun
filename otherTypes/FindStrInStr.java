/**
find target string(arg[0]) from source string(arg[1])
return first position if found o.w. return -1.
*/
import java.util.*;

public class FindStrInStr{
	public static int findIt(String t, String s){
		if (s==null || t==null || t.length()>s.length())
			return -1;
		if (t.length()==0)
			return 0;
			
		for(int i=0; i <= s.length()-t.length(); i++){
			int tracker = 0; // the moving tracker of s in t
			while(t.charAt(tracker)==s.charAt(i+tracker) && tracker < t.length()){
				if(tracker == t.length()-1){
					return i;
				}else{
					tracker ++;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		if (args.length != 2) {
			throw new Error("usage: java FindStrInStr <target> <source>");
		}
		int pos = findIt(args[0],args[1]);
		//System.out.println(args[0]+" "+args[1]);
		if (pos != -1){
			System.out.println("Find target, first position is "+new Integer(pos).toString()+".");
		}else{
			System.out.println("Unable to find target.");
		}
	}
}