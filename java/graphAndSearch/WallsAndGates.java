/**
* You are given a m x n 2D grid initialized with these three possible values.
* -1 - A wall or an obstacle.
* 0 - A gate.
* INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 
* to represent INF as you may assume that the distance to a gate is less than 2147483647.
* Fill each empty room with the distance to its nearest gate. If it is impossible to reach 
* a gate, it should be filled with -1.
* For example, given the 2D grid:
*	INF  -1  0  INF
* 	INF INF INF  -1
*	INF  -1 INF  -1
*	0  -1 INF INF
* After running your function, the 2D grid should be:
*	  3  -1   0   1
*	  2   2   1  -1
*	  1  -1   2  -1
*	  0  -1   3   4
* public void wallsAndGates(int[][] rooms)
* (one bright way is using queue to implement bellman-ford algorithm, which i didn't realize
* in my first try)
*/
import java.util.*;

public class WallsAndGates{
	public static void wallsAndGates(int[][] rooms){
		// why not try bellman-ford algorithm?
		if(rooms == null || rooms.length == 0 || rooms[0].length == 0)
            return;
		int inf = 2147483647;
		for(int k = 0; k<rooms.length*rooms[0].length; k++){
			boolean cont = false;
			for(int i = 0; i<rooms.length; i++){
				for(int j = 0; j<rooms[0].length; j++){
					if(rooms[i][j] >= 0 && rooms[i][j]<inf){
						if(i > 0 && rooms[i][j]+1 < rooms[i-1][j]){
							rooms[i-1][j] = rooms[i][j]+1;
							cont = true;
						}
						if(i < rooms.length-1 && rooms[i][j]+1 < rooms[i+1][j]){
							rooms[i+1][j] = rooms[i][j]+1;
							cont = true;
						}
						if(j > 0 && rooms[i][j]+1 < rooms[i][j-1]){
							rooms[i][j-1] = rooms[i][j]+1;
							cont = true;
						}
						if(j < rooms[0].length-1 && rooms[i][j]+1 < rooms[i][j+1]){
							rooms[i][j+1] = rooms[i][j]+1;
						}
					}
				}
			}
			if(!cont)
				break;
		}
	}
	public static void main(String[] args) {
		int[][] rooms = {{2147483647, -1, 0, 2147483647},
 						{2147483647, 2147483647, 2147483647, -1},
						{2147483647, -1, 2147483647, -1},
						{0, -1, 2147483647, 2147483647}};
		wallsAndGates(rooms);
		for(int[] i: rooms)
			System.out.println(Arrays.toString(i));
	}
}