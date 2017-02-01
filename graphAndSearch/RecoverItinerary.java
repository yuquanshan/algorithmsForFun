/** Given a list of airline tickets represented by pairs of departure 
* and arrival airports [from, to], reconstruct the itinerary in order. 
* All of the tickets belong to a man who departs from JFK. Thus, the 
* itinerary must begin with JFK.
*
* Note:
* If there are multiple valid itineraries, you should return the 
* itinerary that has the smallest lexical order when read as a single 
* string. For example, the itinerary ["JFK", "LGA"] has a smaller 
* lexical order than ["JFK", "LGB"].
*
* All airports are represented by three capital letters (IATA code).
* You may assume all tickets form at least one valid itinerary.
* Example 1:
* tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
* Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
* Example 2:
* tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
* Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
* Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it 
* is larger in lexical order.
* public List<String> findItinerary(String[][] tickets)
* (this question is a little twisted, i had problem solving it for the first time)
*/
import java.util.*;

public class RecoverItinerary{
	public static List<String> findItinerary(String[][] tickets){
		List<String> res = new ArrayList<String>();
		HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
		for(String[] ticket: tickets){
			if(!map.containsKey(ticket[0]))
				map.put(ticket[0],new PriorityQueue<String>());
			map.get(ticket[0]).add(ticket[1]);
		}
		visit("JFK",map,res);
		return res;
	}
	public static void visit(String airport, HashMap<String, PriorityQueue<String>> map, List<String> res){
		while(map.containsKey(airport) && !map.get(airport).isEmpty())
			visit(map.get(airport).poll(), map, res);
		res.add(0,airport);
	} 
	public static void main(String[] args) {
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		System.out.println(findItinerary(tickets).toString());
	}
}