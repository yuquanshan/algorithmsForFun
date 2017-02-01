/** Check whether the original sequence org can be uniquely reconstructed from 
* the sequences in seqs. The org sequence is a permutation of the integers 
* from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest 
* common supersequence of the sequences in seqs (i.e., a shortest sequence so 
* that all sequences in seqs are subsequences of it). Determine whether there 
* is only one sequence that can be reconstructed from seqs and it is the org sequence.
*
* Example 1:
* Input:
* org: [1,2,3], seqs: [[1,2],[1,3]]
* Output:
* false
* Explanation:
* [1,2,3] is not the only one sequence that can be reconstructed, 
* because [1,3,2] is also a valid sequence that can be reconstructed.
* Example 2:
* Input:
* org: [1,2,3], seqs: [[1,2]]
* Output:
* false
* Explanation:
* The reconstructed sequence can only be [1,2].
* Example 3:
* Input:
* org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
* Output:
* true
* Explanation:
* The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
* Example 4:
* Input:
* org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
* Output:
* true
*
* UPDATE (2017/1/8):
* The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings). 
* Please reload the code definition to get the latest changes.
*
* public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs)
* (there is another solution online, yet need to be proved)
*/
import java.util.*;

public class SequenceReconstruction{
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs){
		int[][] graph = new int[org.length+1][org.length+1];
		for(List<Integer> seq: seqs){
			for(int i = 0; i<seq.size()-1; i++){
				graph[seq.get(i)][seq.get(i+1)] = 1;
				graph[0][seq.get(i+1)] += 1;
			}
		}
		// pick first element
		int tmp = 0;
		for(int i = 1; i<=org.length; i++){
			if(graph[0][i] == 0){
				if(tmp != 0)
					return false;
				tmp = i;
			}
		}
		for(int i: org){
			if(i != tmp)
				return false;
			tmp = 0;
			for(int j = 1; j<=org.length; j++){
				if(graph[i][j] == 1){
					graph[0][j] -= 1;
					if(graph[0][j] == 0){
						if(tmp != 0)
							return false;
						tmp = j;
					}
				}
			}
		}
		for(int i = 1; i<=org.length; i++){
			if(graph[0][i] != 0)
				return false;
		}
		return true;
	}
}