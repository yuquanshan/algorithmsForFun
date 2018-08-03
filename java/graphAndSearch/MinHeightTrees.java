/** For a undirected graph with tree characteristics, we can choose any node as the root. 
* The result graph is then a rooted tree. Among all possible rooted trees, those with 
* minimum height are called minimum height trees (MHTs). Given such a graph, write a 
* function to find all the MHTs and return a list of their root labels.
*
* Format
* The graph contains n nodes which are labeled from 0 to n - 1. You will be given 
* the number n and a list of undirected edges (each edge is a pair of labels).
*
* You can assume that no duplicate edges will appear in edges. Since all edges 
* are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*
* Example 1:
* Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
    0
    |
    1
   / \
  2   3
* return [1]
*
* Example 2:
* Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
  0 1 2
  \ | /
    3
    |
    4
    |
    5
* return [3, 4]
*
* public List<Integer> findMinHeightTrees(int n, int[][] edges)
* (the recursive dfs would result in stackover flow problem in OJ, better modify them to 
* iterative form)
*/
import java.util.*;

public class MinHeightTrees{
    public static List<Integer> findMinHeightTrees(int n, int[][] edges){
        if(n == 0)
            return null;
        ArrayList<HashSet<Integer>> array = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++)
            array.add(new HashSet<Integer>());
        for(int[] e: edges){
            array.get(e[0]).add(e[1]);
            array.get(e[1]).add(e[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(array.get(i).size() <= 1){
                queue.add(i);
            }
        }
        int count = 0;
        while(count < n - 2){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int tmp = queue.poll();
                count++;
                for(int j: array.get(tmp)){
                    array.get(j).remove(tmp);
                    if(array.get(j).size() == 1){
                        queue.add(j);
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        while(!queue.isEmpty())
            res.add(queue.poll());
        return res;
    }

    static class Pair{
        public int len;
        public int dest;
        Pair(int len, int dest){
            this.len = len;
            this.dest = dest;
        }
    }
    public static List<Integer> findMinHeightTrees2(int n, int[][] edges){  // find the longest path
        if(n == 0)
            return null;
        List<Integer> res = new ArrayList<Integer>();
        if(n == 1){
            res.add(0);
            return res;
        }
        ArrayList<HashSet<Integer>> array = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++)
            array.add(new HashSet<Integer>());
        for(int[] e: edges){
            array.get(e[0]).add(e[1]);
            array.get(e[1]).add(e[0]);
        }
        Set<Integer> visited = new HashSet<Integer>();
        int pinch = dfsfindleaf(0, 0, visited, array).dest;
        int[] des = new int[n];
        visited = new HashSet<Integer>();
        int len = dfsbacktracking(pinch, 0, des, visited, array); 
        int pt = pinch;
        for(int i = 0; i < (len+1)/2-1; i++)
            pt = des[pt];
        if((len+1) % 2 == 1)
            res.add(des[pt]);
        else{
            res.add(pt); res.add(des[pt]);
        }
        return res;
    }
    private static Pair dfsfindleaf(int root, int plen, Set<Integer> visited, List<HashSet<Integer>> array){
        visited.add(root);
        Pair res = new Pair(root,plen);
        for(int ch: array.get(root)){
            if(!visited.contains(ch)){
                Pair tmp = dfsfindleaf(ch, plen+1, visited, array);
                if(tmp.len > res.len)
                    res = tmp;
            }
        }
        return res;
    }

    private static int dfsbacktracking(int root, int plen, int[] des, Set<Integer> visited, List<HashSet<Integer>> array){
        visited.add(root);
        int longest = plen;
        for(int ch: array.get(root)){
            if(!visited.contains(ch)){
                int tmp = dfsbacktracking(ch, plen+1, des, visited, array);
                if(tmp > longest)
                    des[root] = ch;
            }
        }
        return longest;
    }

    public static List<Integer> findMinHeightTrees3(int n, int[][] edges){  // DP on tree
        if(n == 0)
            return null;
        ArrayList<HashSet<Integer>> array = new ArrayList<HashSet<Integer>>();
        for(int i = 0; i < n; i++)
            array.add(new HashSet<Integer>());
        for(int[] e: edges){
            array.get(e[0]).add(e[1]);
            array.get(e[1]).add(e[0]);
        }
        int[] height1 = new int[n];
        int[] height2 = new int[n];
        dfsheight(0, height1, height2, array, new HashSet<Integer>());
        int[] heights = new int[n];
        dfsrootheight(0, height1, height2, array, heights, 0, new HashSet<Integer>());
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(heights[i] < min)
                min = heights[i];
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(heights[i] == min)
                res.add(i);
        }
        return res;
    }
    private static int dfsheight(int root, int[] height1, int[] height2, ArrayList<HashSet<Integer>> array, Set<Integer> visited){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(2);
        visited.add(root);
        for(int i: array.get(root)){
            if(!visited.contains(i)){
                int tmp = dfsheight(i, height1, height2, array, visited);
                if(heap.size() <= 1)
                    heap.add(tmp);
                else if(heap.peek() < tmp){
                    heap.poll();
                    heap.add(tmp);
                }
            }
        }
        if(!heap.isEmpty())
            height1[root] = heap.poll()+1;
        if(!heap.isEmpty())
            height2[root] = heap.poll()+1;
        return height1[root];
    }
    private static void dfsrootheight(int root, int[] height1, int[] height2, ArrayList<HashSet<Integer>> array, int[] heights, int fromparent, Set<Integer> visited){
        heights[root] = height1[root]>=height2[root]?Math.max(height1[root]+1,fromparent+1):Math.max(height2[root]+1,fromparent+1);
        visited.add(root);
        for(int i: array.get(root)){
            if(!visited.contains(i)){
                if(height1[root] == height1[i]+1)
                    dfsrootheight(i, height1, height2, array, heights, Math.max(fromparent+1, height2[root]), visited);
                else
                    dfsrootheight(i, height1, height2, array, heights, Math.max(fromparent+1, height1[root]), visited);
            }
        }
    }

    public static void main(String[] args) {
       int n = 4;
       int[][] edges = {{1,0},{1,2},{1,3}};
       System.out.println(findMinHeightTrees(n, edges).toString());
       System.out.println(findMinHeightTrees2(n, edges).toString());
       System.out.println(findMinHeightTrees3(n, edges).toString());
    }  
}