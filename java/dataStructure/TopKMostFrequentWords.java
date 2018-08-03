/**
* given a list of words, return k most frequent words.
* public static String[] topKFrequentWords(String[] words, int k)
* (this is O(n) algorithm, which i failed to give for the first time)
*/
import java.util.*;

public class TopKMostFrequentWords{
	public static String[] topKFrequentWords(String[] words, int k){
		if(k <= 0)
			return new String[0];
		if(words == null || words.length <= k)
			return words;
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		for(String str: words){
			if(map.containsKey(str)){
				int val = map.get(str);
				map.put(str,val+1);
			}else{
				map.put(str,1);
			}
		}
		int maxSoFar = -1;
		for(Map.Entry<String,Integer> entry: map.entrySet()){
			if(entry.getValue()>maxSoFar)
				maxSoFar = entry.getValue();
		}
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for(int i = 0; i <= maxSoFar; i++){
			list.add(new ArrayList<String>());
		}
		for(Map.Entry<String,Integer> entry: map.entrySet()){
			int value = entry.getValue();
			String key = entry.getKey();
			list.get(value).add(key);
		}
		String[] res = new String[k];
		int counter = 0;
		for(int i = maxSoFar; i > 0; i--){
			while(list.get(i).size() != 0){
				res[counter] = list.get(i).remove(0);
				counter++;
				if(counter == k){
					return res;
				}
			}	
		}
		return res;
	}
	public static void main(String[] args) {
        String[] words = {"yes","code","code","yes","yes","no","haha","haha","haha"};
        int k = 3;
        String[] res = topKFrequentWords(words,k);
        System.out.format("The top %d most frequent words are %s\n", k, Arrays.toString(res));
    }
}