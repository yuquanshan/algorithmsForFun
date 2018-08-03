/**
* Write a function to generate the generalized abbreviations of a word.
* 
* Example:
*
* Given word = "word", return the following list (order does not matter):
*
* ["word", "1ord";, "w1rd";, "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1",
* "1o2", "2r1", "3d", "w3", "4"]
*/
import java.util.*;

public class GeneralizedAbbreviations{
	public static List<String> allAbbrev(String word){
		if(word == null || word.length() == 0){
			List<String> res = new ArrayList<String>();
			res.add("");
			return res;
        }
		List<List<String>> array = new ArrayList<List<String>>(word.length()+1);
		for(int i = 0; i<=word.length(); i++)
			array.add(new ArrayList<String>());
		array.get(word.length()).add("");
		for(int i = word.length()-1; i>=0; i--){
			List<String> tmp = array.get(i);
			String digit = ""+word.charAt(i);
			List<String> anc = array.get(i+1);
			for(String s: anc)
				tmp.add(digit+s);
			for(int j = i; j < word.length()-1; j++){
				digit = Integer.toString(j-i+1)+word.charAt(j+1);
				anc = array.get(j+2);
				for(String s: anc)
					tmp.add(digit+s);
			}
			tmp.add(Integer.toString(word.length()-i));
		}
		return array.get(0);
	}
	public static void main(String[] args) {
		String word = "word";
		List<String> res = allAbbrev(word);
		System.out.format("given %s, we have %s\n",word,res.toString());
	}
}