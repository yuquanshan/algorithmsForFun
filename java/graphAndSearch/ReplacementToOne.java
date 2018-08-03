/** Given a positive integer n and you can do operations as follow:
* If n is even, replace n with n/2.
* If n is odd, you can replace n with either n + 1 or n - 1.
* What is the minimum number of replacements needed for n to become 1?
*
* Example 1:
* Input:
* 8
* Output:
* 3
* Explanation:
* 8 -> 4 -> 2 -> 1
* Example 2:
* Input:
* 7
* Output:
* 4
* Explanation:
* 7 -> 8 -> 4 -> 2 -> 1
* or
* 7 -> 6 -> 3 -> 2 -> 1
* public int integerReplacement(int n)
* (there is an O(logn)) greedy algorithm, which i failed to come up in my first try)
*/
import java.util.*;

public class ReplacementToOne{
	public static int integerReplacement(int n){
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(n);
		visited.add(n);
		int depth = 0;
		while(!queue.isEmpty()){
			depth++;
			int size = queue.size();
			for(int i = 0; i <size; i++){
				int tmp = queue.poll();
				if(tmp%2 == 0){
					tmp = tmp/2;
					if(tmp == 1)
						return depth;
					if(!visited.contains(tmp)){
						visited.add(tmp);
						queue.add(tmp);
					}
				}else{
					int tmp1 = tmp+1;
					int tmp2 = tmp-1;
					if(tmp1 == 1 || tmp2 == 1)
						return depth;
					if(!visited.contains(tmp1)){
						visited.add(tmp1);
						queue.add(tmp1);
					}
					if(tmp2 > 0 && !visited.contains(tmp2)){
						visited.add(tmp2);
						queue.add(tmp2);
					}
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(integerReplacement(7));
	}
}