/**
* given a set of triples (start, end, height) representing the start position, 
* end position, and height of a building. return the skyline of the city.
* for example, given 
*	[
*	  [1, 3, 3],
*	  [2, 4, 4],
*	  [5, 6, 1]
*	]
* return 
*	[
*	  [1, 2, 3],
*	  [2, 4, 4],
*	  [5, 6, 1]
*	]
* public static ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings)
* (vitnessed in Google interview, super hard, impossible for me to finish on time 
* for the first time)
*/
import java.util.*;

public class BuildingOutline{
	static class BuildingEdge{
		int type;	// 0 for end edge 1 for start edge
		int position;
		int height;
		BuildingEdge(int type, int position, int height){
			this.type = type;
			this.position = position;
			this.height = height;
		}
	}
	public static ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings){
		if(buildings == null || buildings.length == 0)
			return new ArrayList<ArrayList<Integer>>();
		ArrayList<BuildingEdge> edgeArray = new ArrayList<BuildingEdge>();
		for(int[] building: buildings){
			edgeArray.add(new BuildingEdge(1,building[0],building[2]));
			edgeArray.add(new BuildingEdge(0,building[1],building[2]));
		}
		Collections.sort(edgeArray,new Comparator<BuildingEdge>(){
			public int compare(BuildingEdge a, BuildingEdge b){
				if(a.position != b.position)
					return a.position-b.position;
				else if(a.type != b.type)
					return b.type-a.type;	// start edge before end edge, to avoid same position different edge height
				else{
					if(a.type == 1)
						return b.height-a.height;
					else
						return a.height-b.height;
				}
			}
		});
		PriorityQueue<Integer> heights = new PriorityQueue<Integer>(100, Collections.reverseOrder());
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(BuildingEdge edge: edgeArray){
			if(edge.type == 1){
				if(heights.isEmpty() || edge.height > heights.peek()){
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(edge.position);
					tmp.add(edge.height);
					res.add(tmp);
				}
				heights.add(edge.height);
			}else{
				//System.out.format("%d %d\n",edge.position,edge.height);
				heights.remove(edge.height);
				if(heights.isEmpty() || edge.height > heights.peek()){
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(edge.position);
					if(heights.isEmpty())
						tmp.add(0);
					else
						tmp.add(heights.peek());
					res.add(tmp);
				}
			}
		}
		return parseRes(res);
	}
	public static ArrayList<ArrayList<Integer>> parseRes(ArrayList<ArrayList<Integer>> res){
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		while(res.size()!=1){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			ArrayList<Integer> cur = res.remove(0);
			if(cur.get(1) != 0){
				tmp.add(cur.get(0));
				tmp.add(res.get(0).get(0));
				tmp.add(cur.get(1));
				output.add(tmp);
			}
		}
		return output;
	}
	public static void main(String[] args) {
        //int[][] buildings = {{0,50,5},{5,15,10},{10,20,30},{16,18,1},{19,40,8},{30,35,20}};
        int[][] buildings = {{1,3,3},{2,4,4},{5,6,1}};
        ArrayList<ArrayList<Integer>> res = buildingOutline(buildings);
        System.out.println(res.toString());
    }
}