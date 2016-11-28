/**
* given a 2-D boolean matrix, consider 0 as sea area, find the number of islands.
* public static int numIslands(boolean[][] grid)
*/
import java.util.*;
public class NumberOfIslands{
	public static int numIslands(boolean[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int n = grid.length;
		int m = grid[0].length;
		boolean[][] visited = new boolean[n][m];
		LinkedList<Integer> vq = new LinkedList<Integer>();
		LinkedList<Integer> hq = new LinkedList<Integer>();
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				visited[i][j] = false;
			}
		}
		int count = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(grid[i][j] && !visited[i][j]){
					count++;
					vq.add(i);
					hq.add(j);
					while(vq.peek()!=null){
						int size = vq.size();
						for(int k = 0; k<size; k++){
							int x = vq.poll();
							int y = hq.poll();
							visited[x][y] = true;
							if(x > 0 && grid[x-1][y] && !visited[x-1][y]){
								vq.add(x-1);
								hq.add(y);
							}
							if(y>0 && grid[x][y-1] && !visited[x][y-1]){
								vq.add(x);
								hq.add(y-1);
							}
							if(x < n-1 && grid[x+1][y] && !visited[x+1][y]){
								vq.add(x+1);
								hq.add(y);
							}
							if(y < m-1 && grid[x][y+1] && !visited[x][y+1]){
								vq.add(x);
								hq.add(y+1);
							}
						}
					}
				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		boolean[][] grid = {{true, true, false, false, false},
  							{false, true, false, false, true},
  							{false, false, false, true, true},
  							{false, false, false, false, false},
  							{false, false, false, false, true}};
  		System.out.format("The number of islands is %d.\n",numIslands(grid));
	}
}