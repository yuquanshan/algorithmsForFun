/**
* given two words (start and end), and a dictionary, find all shortest 
* transformation from start to end, s.t,
* 1. only one letter can be changed at a time
* 2. each intermediate word must exist in the dictionary.
* public static List<List<String>> findLadders(String start, String end, Set<String> dict)
* (pretty complecated algorithm which took me three days to pass the test for the first time)
*/

import java.util.*;

public class AllWordLadders{
	public static List<List<String>> findLadders(String start, String end, Set<String> dict){
		HashMap<String,Integer> distance = new HashMap<String,Integer>(); 	// the shortest integer from start to that string
		HashMap<String,List<String>> ancestorMap = new HashMap<String,List<String>>();
		distance.put(start,0);
		dict.add(start);
		dict.add(end);
		for(String str: dict){
			ancestorMap.put(str,new ArrayList<String>());
		}
		Queue<String> queue = new LinkedList<String>();
		Boolean cont = true;
		queue.add(start);
		while(queue.peek() != null && cont){
			int size = queue.size();
			//System.out.println(queue.toString());
			for(int i = 0; i<size; i++){
				String str = queue.poll();
				ArrayList<String> neighbors = findNeighbors(str,dict);
				for(String s: neighbors){
					ancestorMap.get(s).add(str);
					if(!distance.containsKey(s)){
						distance.put(s,distance.get(str)+1);
						queue.add(s);
					}
					if(s.equals(end))
						cont = false;
				}	
			}
		}
		List<List<String>> res = traceBack(start, end, distance, ancestorMap);
		return res;
	}
	public static ArrayList<String> findNeighbors(String str, Set<String> dict){
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0; i<str.length(); i++){
			for(char c = 'a'; c<='z'; c++){
				if(c != str.charAt(i)){
					String comp = str.substring(0,i)+c+str.substring(i+1);
					if(dict.contains(comp))
						res.add(comp);
				}
			}
		}
		return res;
	}
	public static List<List<String>> traceBack(String start, String end,HashMap<String,Integer> distance, HashMap<String,List<String>> ancestorMap){
		ArrayList<List<String>> res = new ArrayList<List<String>>();
		if(end.equals(start)){
			List<String> list = new ArrayList<String>();
			list.add(start);
			res.add(list);
		}
		for(String str: ancestorMap.get(end)){
			if(distance.get(str)+1 == distance.get(end)){
				List<List<String>> tmp = traceBack(start,str,distance,ancestorMap);
				for(List<String> l: tmp){
					l.add(end);
				}
				res.addAll(tmp);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		List<List<String>> res = findLadders(start,end,set);
		System.out.println(res.toString());
	}
}