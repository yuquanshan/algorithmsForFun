/**
* suppose we abbreviate the words as <first letter><number><last letter>, for example
* 	it 	---> 	it
* 	dog --->	d1g
* given a dictionary, and a word, find whether the word has a unique abbreviation in 
* the dictionary.
*	public class DuplicatedAbbreviation {
*	    public DuplicatedAbbreviation(String[] dictionary) {}
*	    public boolean isUnique(String word){}
*	}
*/

import java.util.*;

public class DuplicatedAbbreviation{
	HashMap<String, HashMap<Integer,Integer>> sidemap;
	HashSet<String> set; 
	public DuplicatedAbbreviation(String[] dictionary){
		sidemap = new HashMap<String, HashMap<Integer,Integer>>();
		set = new HashSet<String>();
		for(String s: dictionary){
			if(s != null && s.length()!=0 && !set.contains(s)){
				String str = "";
				str += s.charAt(0); str += s.charAt(s.length()-1);
				set.add(s);
				if(!sidemap.containsKey(str)){
					sidemap.put(str,new HashMap<Integer,Integer>());
				}
				if(!sidemap.get(str).containsKey((s.length()-2))){
					sidemap.get(str).put(s.length()-2,1);
				}else{
					int tmp = sidemap.get(str).get(s.length()-2);
					sidemap.get(str).put(s.length()-2,tmp+1);
				}
			}
		}
	}
	public boolean isUnique(String word){
		if(word == null || word.length() == 0)
			return true;
		String str = "";
		str += word.charAt(0); str += word.charAt(word.length()-1);
		int num = word.length()-2;
		if(set.contains(word)){
			return sidemap.get(str).get(num) == 1;
		}else if(sidemap.containsKey(str)){
			return !sidemap.get(str).containsKey(num);
		}else{
			return true;
		}
	}
	public static void main(String[] args) {
		String[] dict = {};
		DuplicatedAbbreviation dup  = new DuplicatedAbbreviation(dict);
		if(dup.isUnique("dig"))
			System.out.println("oops");
		else
			System.out.println("good");
	}
}