/**
* ser and deser a list of strings.
* public String encode(List<String> strs)
* public List<String> decode(String s)
*/

import java.util.*;

public class SerDeserListOfStrings{
	public static String encode(List<String> strs){
		if(strs == null || strs.size() == 0)
			return "";
		String lenStr = "";
		String content = "";
		for(String s: strs){
			lenStr = lenStr+"("+Integer.toString(s.length())+")";
			content += s;
		}
		lenStr += "%";
		return lenStr+content;
	}	
	public static List<String> decode(String s){
		if(s == "")
			return new ArrayList<String>();
		int numend = s.indexOf('%');
		String lenStr = s.substring(0,numend);
		String content = s.substring(numend+1,s.length());
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0;
		while(i<lenStr.length()){
			if(lenStr.charAt(0) == '('){
				String str = "";
				i++;
				while(lenStr.charAt(i) != ')')
					str+=lenStr.charAt(i++);
				i++;
				list.add(Integer.parseInt(str));
			}
		}
		List<String> res = new ArrayList<String>();
		i = 0;
		for(int len: list){
			res.add(content.substring(i,i+len));
			i+=len;
		}
		return res;
	}
	public static void main(String[] args) {
		ArrayList<String> strs =  new ArrayList<String>();
		strs.add(""); strs.add(""); strs.add("");
		System.out.format("Original list: %s\n", strs.toString());
		System.out.format("Decoded list: %s\n", decode(encode(strs)).toString());
	}
}