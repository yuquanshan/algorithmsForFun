/**
* given a 2-D grid, 1 indicates house, 2 indicate wall, 0 indicate 
* empty land, build a post office over an empty land, such that the 
* sum of the distances from the houses is minimized.
*  public static int shortestDistance(int[][] grid)
*/
import java.util.*;

public class BuildPostOffice{
	public static int shortestDistance(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return -1;
		int m = grid.length;
		int n = grid[0].length;
		int[][] count = new int[m][n];
		int[][] distance = new int[m][n];
		int bestSoFar = Integer.MAX_VALUE;
		int tot = 0;
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(grid[i][j] == 1)
					tot++;
			}
		}
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(grid[i][j] == 1){
					LinkedList<Integer> queue = new LinkedList<Integer>();
					HashSet<Integer> visited = new HashSet<Integer>();
					queue.add(i*n+j);
					int level = 1;
					while(queue.peek() != null){
						int size = queue.size();
						for(int k = 0; k<size; k++){
							int tmp = queue.poll();
							int x = tmp/n;
							int y = tmp%n;
							if(x>0 && grid[x-1][y] == 0 && !visited.contains(n*(x-1)+y)){
								count[x-1][y]++;
								visited.add(n*(x-1)+y);
								distance[x-1][y] += level;
								queue.add(n*(x-1)+y);
								if(count[x-1][y]==tot && bestSoFar > distance[x-1][y])
									bestSoFar = distance[x-1][y];
							}
							if(x<m-1 && grid[x+1][y] == 0 && !visited.contains(n*(x+1)+y)){
								count[x+1][y]++;
								visited.add(n*(x+1)+y);
								distance[x+1][y] += level;
								queue.add(n*(x+1)+y);
								if(count[x+1][y]==tot && bestSoFar > distance[x+1][y])
									bestSoFar = distance[x+1][y];
							}
							if(y>0 && grid[x][y-1] == 0 && !visited.contains(n*x+y-1)){
								count[x][y-1]++;
								visited.add(n*x+y-1);
								distance[x][y-1] += level;
								queue.add(n*x+y-1);
								if(count[x][y-1]==tot && bestSoFar > distance[x][y-1])
									bestSoFar = distance[x][y-1];
							}
							if(y<n-1 && grid[x][y+1] == 0 && !visited.contains(n*x+y+1)){
								count[x][y+1]++;
								visited.add(n*x+y+1);
								distance[x][y+1] += level;
								queue.add(n*x+y+1);
								if(count[x][y+1]==tot && bestSoFar > distance[x][y+1])
									bestSoFar = distance[x][y+1];
							}
						}
						level++;
					}
				}
			}
		}
		if(bestSoFar < Integer.MAX_VALUE)
			return bestSoFar;
		return -1;
	}
	public static void main(String[] args) {
		int[][] grid = {{0,1,0,0,0},{1,0,0,2,1},{0,1,0,0,0}};
		System.out.println(shortestDistance(grid));
	}
}