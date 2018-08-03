/** Given a string, we can "shift" each of its letter to its successive letter, 
* for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
*
* "abc" -> "bcd" -> ... -> "xyz"
* Given a list of strings which contains only lowercase alphabets, group all 
* strings that belong to the same shifting sequence.
*
* For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
* A solution is:
* [
*  ["abc","bcd","xyz"],
*  ["az","ba"],
*  ["acef"],
*  ["a","z"]
* ]
* public List<List<String>> groupStrings(String[] strings)
*/
import java.util.*;

public class GroupShiftStrings{
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0)
            return res;
       	List<String> tmp = new ArrayList<String>();
       	Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s: strings){
        	StringBuilder sb = new StringBuilder();
        	for(int i = 0; i<s.length(); i++){
        		sb.append('a'+((s.charAt(i)-s.charAt(0))+26)%26);
        	}
        	tmp.add(sb.toString());
        }
        for(int i = 0; i<tmp.size(); i++){
        	if(!map.containsKey(tmp.get(i))){
        		List<String> list = new ArrayList<String>();
        		res.add(list);
        		map.put(tmp.get(i),list);
        	}
        	map.get(tmp.get(i)).add(strings[i]);
        }
        return res;
    }
    public static void main(String[] args) {
    	String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    	System.out.println(groupStrings(strings).toString());
    }
}