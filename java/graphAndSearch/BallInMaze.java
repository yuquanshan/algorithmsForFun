/** There is a ball in a maze with empty spaces and walls. 
* The ball can go through empty spaces by rolling up, down, 
* left or right, but it won't stop rolling until hitting a 
* wall. When the ball stops, it could choose the next direction.
*
* Given the ball's start position, the destination and the 
* maze, determine whether the ball could stop at the destination.
*
* The maze is represented by a binary 2D array. 1 means the 
* wall and 0 means the empty space. You may assume that the 
* borders of the maze are all walls. The start and destination 
* coordinates are represented by row and column indexes.
*
* Example 1
* Input 1: a maze represented by a 2D array
*
* 0 0 1 0 0
* 0 0 0 0 0
* 0 0 0 1 0
* 1 1 0 1 1
* 0 0 0 0 0
*
* Input 2: start coordinate (rowStart, colStart) = (0, 4)
* Input 3: destination coordinate (rowDest, colDest) = (4, 4)
* 
* Output: true
* Explanation: One possible way is : left -> down -> left -> down 
* -> right -> down -> right.
*
* public boolean hasPath(int[][] maze, int[] start, int[] destination)
*/
import java.util.*;

public class BallInMaze {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if(maze == null || maze.length == 0 || maze[0].length == 0) return false;
		int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		int[] starts = {-1, 9};
		int m = maze.length;
		int n = maze[0].length;
		Stack<Integer> dirStack = new Stack<Integer>();	// 0 up, 1 down, 10 left, 11 right
		Stack<Integer> stack = new Stack<Integer>();	// starting point of bouncing
		for(int s: starts) {
			Set<Integer> bounced = new HashSet<Integer>();
			int target = destination[0]*n + destination[1];
			bounced.add(n*start[0] + start[1]);
			stack.push(n*start[0] + start[1]);
			dirStack.push(s);
			while(!stack.isEmpty()) {
				if(dirStack.peek() == 1 || dirStack.peek() == 11) {
					while(!dirStack.isEmpty() && (dirStack.peek() == 1 || dirStack.peek() == 11)) {
						stack.pop();
						dirStack.pop();
					}
				}else {
					int tmp = dirStack.pop() + 1;
					dirStack.push(tmp);
					//System.out.format("(%d, %d), %d\n", stack.peek()/n, stack.peek()%n, dirStack.peek());
					int[] dir = dirs[(tmp/10)*2 + (tmp%10)];
					int x = stack.peek()/n; 
					int y = stack.peek()%n;
					while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y+dir[1]]!=1){
						x += dir[0];
						y += dir[1];
					} 
					if(x*n + y == target) return true;
					if(!bounced.contains(x*n + y)) {
						stack.push(x*n + y);
						bounced.add(x*n + y);
						if(dirStack.peek() < 9) dirStack.push(9);
						else dirStack.push(-1);
						//System.out.format("(%d, %d), %d\n", stack.peek()/n, stack.peek()%n, dirStack.peek());
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
		int[] start = {0, 4};
		int[] destination = {4, 4};
		BallInMaze test = new BallInMaze();
		System.out.println(test.hasPath(maze, start, destination));
	}
}