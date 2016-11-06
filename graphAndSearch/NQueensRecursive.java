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
* (try to solve is recursively)
*/

import java.util.*;

public class NQueensRecursive{
	public static ArrayList<ArrayList<String>> solveNQueens(int n){
		if(n == 0)
			return new ArrayList<ArrayList<String>>();
		ArrayList<Integer> board = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		placeQueen(n, board, 0, res);
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
	public static void placeQueen(int n, ArrayList<Integer> board, int row, ArrayList<ArrayList<Integer>> res){
		for(int i = 0; i<n; i++){
			if(goodPos(board, row, i)){
				board.add(i);
				if(row == n-1){
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					for(int j: board)
						tmp.add(j);
					res.add(tmp);
				}else{
					placeQueen(n,board,row+1,res);
				}
				board.remove(board.size()-1);
			}
		}
	}
	public static boolean goodPos(ArrayList<Integer> board, int row, int col){
		for(int i = 0; i<board.size(); i++){
			if(board.get(i) == col)
				return false;
			if(Math.abs(board.get(i)-col) == Math.abs(i-row))
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