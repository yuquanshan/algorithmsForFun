/**
* given m and n to represent an initially all zero (sea) matrix,
* and a set of Points which indicates a sequence of island constructing 
* on those Points. return the number of islands after each constructing.
* 	class Point {
*     	int x;	// index of row
*     	int y;	// index of col
*     	Point() { x = 0; y = 0; }
*     	Point(int a, int b) { x = a; y = b; }
* 	}
* public static List<Integer> numIslands2(int m, int n, Point[] operators)
*/
import java.util.*;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}

public class BuildNumberIslandOnSea{
	public static List<Integer> numIslands2(int m, int n, Point[] operators){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> cap = new HashMap<Integer,Integer>();
		HashMap<Integer,Boolean> fill = new HashMap<Integer, Boolean>();	// whether filled island on it
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				map.put(i*n+j,-1);
				cap.put(i*n+j,1);
				fill.put(i*n+j,false);
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		if(operators == null)
		    return res;
		int count = 0;
		for(int i = 0; i<operators.length; i++){
			Point cur = operators[i];
			//System.out.format("(%d,%d)\n",cur.x,cur.y);
			count++;
			int tag = cur.x*n+cur.y;
			fill.put(tag,true);
			if(cur.x > 0){
				int neighbor = (cur.x-1)*n+cur.y;
				if(fill.get(neighbor)){
					int root1 = findRoot(map,tag);
					int root2 = findRoot(map,neighbor);
					if(root1 != root2){
						count--;
						if(cap.get(root1)>=cap.get(root2)){
							map.put(root2,root1);
							cap.put(root1,cap.get(root1)+cap.get(root2));
						}else{
							map.put(root2,root1);
							cap.put(root2,cap.get(root1)+cap.get(root2));
						}
					}
				}
			}
			if(cur.x < m-1){
				int neighbor = (cur.x+1)*n+cur.y;
				if(fill.get(neighbor)){
					int root1 = findRoot(map,tag);
					int root2 = findRoot(map,neighbor);
					if(root1 != root2){
						count--;
						if(cap.get(root1)>=cap.get(root2)){
							map.put(root2,root1);
							cap.put(root1,cap.get(root1)+cap.get(root2));
						}else{
							map.put(root2,root1);
							cap.put(root2,cap.get(root1)+cap.get(root2));
						}
					}
				}
			}
			if(cur.y > 0){
				int neighbor = cur.x*n+cur.y-1;
				if(fill.get(neighbor)){
					int root1 = findRoot(map,tag);
					int root2 = findRoot(map,neighbor);
					if(root1 != root2){
						count--;
						if(cap.get(root1)>=cap.get(root2)){
							map.put(root2,root1);
							cap.put(root1,cap.get(root1)+cap.get(root2));
						}else{
							map.put(root2,root1);
							cap.put(root2,cap.get(root1)+cap.get(root2));
						}
					}
				}
			}
			if(cur.y < n-1){
				int neighbor = cur.x*n+cur.y+1;
				if(fill.get(neighbor)){
					int root1 = findRoot(map,tag);
					int root2 = findRoot(map,neighbor);
					if(root1 != root2){
						count--;
						if(cap.get(root1)>=cap.get(root2)){
							map.put(root2,root1);
							cap.put(root1,cap.get(root1)+cap.get(root2));
						}else{
							map.put(root2,root1);
							cap.put(root2,cap.get(root1)+cap.get(root2));
						}
					}
				}
			}
			res.add(count);
		}
		return res;
	}
	public static int findRoot(HashMap<Integer,Integer> map, int pt){
		int root = pt;
		while(map.get(root)!=-1){
			root = map.get(root);
		}
		return root;
	}
	public static void main(String[] args) {
		int n = 5;
		int m = 4;
		Point[] operators = new Point[4];
		operators[0] = new Point(1,1);
		operators[1] = new Point(0,1);
		operators[2] = new Point(3,3);
		operators[3] = new Point(3,4);
		List<Integer> res = numIslands2(m,n,operators);
		System.out.format("The numbers of islands after each operation are %s\n",res.toString());
	}
}