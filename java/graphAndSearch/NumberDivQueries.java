/**
* Equations are given in the format A / B = k, where A and B are variables represented as strings,
* and k is a real number (floating point number). Given some queries, return the answers. If the
* answer does not exist, return -1.0.
* 	public class NumberDivQueries{
*		NumberDivQueries(ArrayList<Pair> equations, ArrayList<Double> values){}
*		public double query(Pair q){}
*	}
* 	class Pair{
*		String nomi;	
*		String deno;
* 		Pair(String nomi, String deno){
*			this.nomi = nomi;
*			this.deno = deno;
* 		}
*	}
*/

import java.util.*;

class Pair{
	String nomi;	
	String deno;
	Pair(String nomi, String deno){
		this.nomi = nomi;
		this.deno = deno;
	}
}

public class NumberDivQueries{
	HashMap<String,HashMap<String, Double>> map;
	NumberDivQueries(ArrayList<Pair> equations, ArrayList<Double> values){
		map = new HashMap<String, HashMap<String, Double>>();
		for(int i = 0; i<equations.size(); i++){
			Pair p = equations.get(i);
			if(!map.containsKey(p.nomi))
				map.put(p.nomi, new HashMap<String, Double>());
			map.get(p.nomi).put(p.deno,values.get(i));
			if(!map.containsKey(p.deno))
				map.put(p.deno, new HashMap<String, Double>());
			map.get(p.deno).put(p.nomi,1/values.get(i));
		}
	}
	public double query(Pair q){
		if(!map.containsKey(q.deno) || !map.containsKey(q.nomi))
			return -1;
		if(q.deno.equals(q.nomi))
			return 1;
		double tmp = dfs(1, q.nomi, q.deno, new HashSet<String>());
		if(tmp != 1) map.get(q.nomi).put(q.deno,tmp);
		return tmp;
	}
	private double dfs(double passd, String entry, String target, Set<String> visited){
		visited.add(entry);
		for(String key: map.get(entry).keySet()){
			if(key.equals(target))
				return passd*map.get(entry).get(key);
			if(!visited.contains(key)){
				double tmp = dfs(passd*map.get(entry).get(key),key,target,visited);
				if(tmp != -1)
					return tmp;
			}
		}
		visited.remove(entry);
		return -1;
	}
	public static void main(String[] args) {
		ArrayList<Pair> equations = new ArrayList<Pair>();
		equations.add(new Pair("a","b")); equations.add(new Pair("c","b"));
		ArrayList<Double> values = new ArrayList<Double>();
		values.add(3.0); values.add(4.0);
		NumberDivQueries ndq = new NumberDivQueries(equations, values);
		if(ndq.query(new Pair("a","c")) == (double)3/4)
			System.out.println("Test1 passed!");
		if(ndq.query(new Pair("a","a")) == 1)
			System.out.println("Test2 passed!");
		if(ndq.query(new Pair("a","e")) == -1)
			System.out.println("Test3 passed!");
	}
}