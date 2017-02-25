/** There are a total of n courses you have to take, labeled from 0 to n - 1.
*
* Some courses may have prerequisites, for example to take course 0 you have to 
* first take course 1, which is expressed as a pair: [0,1]
*
* Given the total number of courses and a list of prerequisite pairs, return the 
* ordering of courses you should take to finish all courses.
*
* There may be multiple correct orders, you just need to return one of them. If 
* it is impossible to finish all courses, return an empty array.
*
* For example:
* 2, [[1,0]]
* There are a total of 2 courses to take. To take course 1 you should have 
* finished course 0. So the correct course order is [0,1]
*
* 4, [[1,0],[2,0],[3,1],[3,2]]
* There are a total of 4 courses to take. To take course 3 you should have finished 
* both courses 1 and 2. Both courses 1 and 2 should be taken after you finished 
* course 0. So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
*
* public int[] findOrder(int numCourses, int[][] prerequisites)
*/

import java.util.*;

public class CourseSchedule {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(numCourses == 0 || prerequisites == null) return new int[0];
		Stack<Integer> stack = new Stack<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		ArrayList<Set<Integer>> graph = new ArrayList<Set<Integer>>();
		for(int i = 0; i < numCourses; i++) graph.add(new HashSet<Integer>());
		for(int[] edge: prerequisites) graph.get(edge[1]).add(edge[0]);
		for(int i = 0; i < numCourses; i++) {
			if(!visited.contains(i)) {
				if(!dfs(i, stack, new HashSet<Integer>(), visited, graph)) return new int[0];
			}
		}
		int[] res = new int[numCourses];
		for(int i = 0; i < numCourses; i++) res[i] = stack.pop();
		return res;
	}
	private boolean dfs(int i, Stack<Integer> stack, Set<Integer> v, Set<Integer> visited, ArrayList<Set<Integer>> graph) {
		visited.add(i);
		v.add(i);
		for(int j: graph.get(i)) {
			if(v.contains(j)) return false;
			if(!visited.contains(j)) {
				if(!dfs(j, stack, v, visited, graph)) return false;
			}  
		}
		v.remove(i);
		stack.push(i);
		return true;
	}
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		CourseSchedule test = new CourseSchedule();
		int[] res = test.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(res));
	}
}