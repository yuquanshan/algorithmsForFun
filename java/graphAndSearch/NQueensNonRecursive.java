/**
* typical n-queen problem, given n*n board, print all possible 
* arrangement of n-queens without threatening each other.
* recursion is straightforward, try to solve non-recursively.
* returned solution should in form like this:
* [".Q..",
*  "...Q",
*  "Q...",
*  "..Q."
* ],
* ["..Q.",
*  "Q...",
*  "...Q",
*  ".Q.."
* ]
* public static ArrayList<ArrayList<String>> solveNQueens(int n)
* (try to solve it non-recursively)
*/
import java.util.*;

class NQueensNode{
	int pt;
	int row;
	int col;
	public NQueensNode(int row, int col){
		this.row = row;
		this.col = col;
		this.pt = -1;
	}
}

public class NQueensNonRecursive{
	public static ArrayList<ArrayList<String>> solveNQueens(int n){
		if(n == 0)
			return new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int k = 0; k<n; k++){
			ArrayList<NQueensNode> stack = new ArrayList<NQueensNode>();
			stack.add(new NQueensNode(0,k));
			while(!stack.isEmpty()){
				if(stack.size() == n){
					ArrayList<Integer> sol = new ArrayList<Integer>();
					for(int i = 0; i<n; i++)
						sol.add(stack.get(i).col);
					res.add(sol);
					stack.remove(n-1);
				}else{
					if(stack.get(stack.size()-1).pt == n-1){
						stack.remove(stack.size()-1);
					}else{
						stack.get(stack.size()-1).pt++;
						if(goodPos(stack.size(), stack.get(stack.size()-1).pt, stack))
							stack.add(new NQueensNode(stack.size(),stack.get(stack.size()-1).pt));
					}
				}
			}
		}
		ArrayList<ArrayList<String>> sols = new ArrayList<ArrayList<String>>();
		for(ArrayList<Integer> sol: res){
			ArrayList<String> tmp = new ArrayList<String>();
			for(int i = 0; i<n; i++){
				String s = "";
				for(int j = 0; j<n; j++){
					if(j == sol.get(i))
						s = s+"Q";
					else
						s = s+".";
				}
				tmp.add(s);
			}
			sols.add(tmp);
		}
		return sols;
	}
	public static boolean goodPos(int r, int c,ArrayList<NQueensNode> stack){
		for(int i = 0; i < stack.size(); i++){
			if(Math.abs(r-i) == Math.abs(c-stack.get(i).col))
				return false;
			if(c == stack.get(i).col)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int n = 4;
		System.out.format("Solutions of %d-queens problem are:\n",n);
		System.out.println(solveNQueens(n).toString());
	}
}