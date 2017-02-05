/** 
* Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map, compute the * volume of water it is able to trap after raining.
* Note:
* Both m and n are less than 110. The height of each unit cell is greater than 0 and is less than 20,000.
* 
* Example:
* 
* Given the following 3x6 height map:
* [
*  	[1,4,3,1,3,2],
*  	[3,2,1,3,2,4],
*  	[2,3,3,2,3,1]
* ]
* 
* Return 4.
*
* public int trapRainWater(int[][] heightMap)
*/
import java.util.*;

public class TrapRainWater{
	static class Cylinder{
		int pos;
		int height;
		Cylinder(int pos, int height){
			this.pos = pos;
			this.height = height;
		}
	}
	public static int trapRainWater(int[][] heightMap){
		if(heightMap == null || heightMap.length < 3 || heightMap[0].length < 3)
			return 0;
		int m = heightMap.length;
		int n = heightMap[0].length;
		int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
		int res = 0;
		PriorityQueue<Cylinder> heap = new PriorityQueue<Cylinder>(new Comparator<Cylinder>(){
			public int compare(Cylinder a, Cylinder b){
				return a.height - b.height;
			}
		});
		Set<Integer> visited = new HashSet<Integer>();
		for(int i = 0; i<m; i++){
			if(!visited.contains(i*n)){
				visited.add(i*n);
				heap.add(new Cylinder(i*n,heightMap[i][0]));
			}
			if(!visited.contains(i*n+n-1)){
				visited.add(i*n+n-1);
				heap.add(new Cylinder(i*n+n-1,heightMap[i][n-1]));
			}
		}
		for(int i = 0; i<n; i++){
			if(!visited.contains(i)){
				visited.add(i);
				heap.add(new Cylinder(i,heightMap[0][i]));
			}
			if(!visited.contains((m-1)*n+i)){
				visited.add((m-1)*n+i);
				heap.add(new Cylinder((m-1)*n+i,heightMap[m-1][i]));
			}
		}
		while(!heap.isEmpty()){
			Cylinder tmp = heap.poll();
			int x = tmp.pos/n;
			int y = tmp.pos%n;
			for(int[] dir: directions){
				int xx = x+dir[0];
				int yy = y+dir[1];
				if(xx >= 0 && xx < m && yy >= 0 && yy < n && !visited.contains(xx*n+yy)){
					visited.add(xx*n+yy);
					if(tmp.height>heightMap[xx][yy]){
						res += tmp.height-heightMap[xx][yy];
						heap.add(new Cylinder(xx*n+yy,tmp.height));
						//System.out.format("(%d,%d)-(%d,%d)\n", x,y,xx, yy);
					}else
						heap.add(new Cylinder(xx*n+yy,heightMap[xx][yy]));
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] heightMap = {{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};
		System.out.println(trapRainWater(heightMap));
	}
}