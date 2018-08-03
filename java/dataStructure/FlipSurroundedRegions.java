/**
* given a 2D board containing 'X' and 'O', flip all 'O' 
* regoins to 'X'.
* public static void surroundedRegions(char[][] board)
* (failed to complete on time for the first time due to stupid bugs)
*/
import java.util.*;

public class FlipSurroundedRegions{
	public static void surroundedRegions(char[][] board){
		if(board != null && board.length != 0 && board[0].length != 0){
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			//HashMap<Integer,Integer> cap = new HashMap<Integer,Integer>();
			for(int i = 0; i<board.length; i++){
				for(int j = 0; j<board[0].length; j++){
					map.put(i*board[0].length+j,i*board[0].length+j);
					//cap.put(i*board[0].length+j,1);
				}
			}
			HashSet<Integer> boarderRoots = new HashSet<Integer>();
			for(int i = 0; i<board.length; i++){
				if(board[i][0] == 'O')
					boarderRoots.add(i*board[0].length);
				if(board[i][board[0].length-1] == 'O')
					boarderRoots.add(i*board[0].length+board[0].length-1);
			}
			for(int i = 0; i<board[0].length; i++){
				if(board[0][i] == 'O')
					boarderRoots.add(i);
				if(board[board.length-1][i] == 'O')
					boarderRoots.add((board.length-1)*board[0].length+i);
			}
			for(int i = 0; i<board.length; i++){
				for(int j = 0; j<board[0].length; j++){
					if(board[i][j] == 'O'){
						int here = i*board[0].length+j;
						if(i>0){
							int neighbor = (i-1)*board[0].length+j;
							int root1 = findRoot(map,here);
							int root2 = findRoot(map,neighbor);
							if(board[i-1][j]=='O' && root1 != root2){
								if(boarderRoots.contains(root1))
									map.put(root2,root1);
								else
									map.put(root1,root2);
							}
						}
						if(i<board.length-1){
							int neighbor = (i+1)*board[0].length+j;
							int root1 = findRoot(map,here);
							int root2 = findRoot(map,neighbor);
							if(board[i+1][j]=='O' && root1 != root2){
								if(boarderRoots.contains(root1))
									map.put(root2,root1);
								else
									map.put(root1,root2);
							}
						}
						if(j>0){
							int neighbor = i*board[0].length+j-1;
							int root1 = findRoot(map,here);
							int root2 = findRoot(map,neighbor);
							if(board[i][j-1]=='O' && root1 != root2){
								if(boarderRoots.contains(root1))
									map.put(root2,root1);
								else
									map.put(root1,root2);
							}
						}
						if(j<board[0].length-1){
							int neighbor = i*board[0].length+j+1;
							int root1 = findRoot(map,here);
							int root2 = findRoot(map,neighbor);
							if(board[i][j+1]=='O' && root1 != root2){
								if(boarderRoots.contains(root1))
									map.put(root2,root1);
								else
									map.put(root1,root2);
							}
						}
					}
				}
			}
			for(int i = 1; i<board.length-1; i++){
				for(int j = 1; j<board[0].length-1; j++){
					int tmp = findRoot(map,i*board[0].length+j);
					if(!boarderRoots.contains(tmp))
						board[i][j] = 'X';
				}
			}
		}
	}
	public static int findRoot(HashMap<Integer,Integer> map, int cur){
		int tmp = cur;
		while(map.get(tmp) != tmp){
			tmp = map.get(tmp);
		}
		map.put(cur,tmp);
		return tmp;
	}
	public static void main(String[] args) {
		String str = "XOOXXXOXOOXOXXXXXXXXXXXXOXXXXXXOXXXOXXXOOXXXOXOXOXXXOXXOOXXXOXXOOXOXXOOXXXXXOXXXXOOXXOXXOOXXXOOXOXXO";
		char[][] board = new char[10][10];
		for(int i = 0; i<10; i++){
			for(int j = 0; j<10; j++){
				board[i][j] = str.charAt(i*10+j);
			}
		}
		System.out.println("Current board is:");
		for(int i = 0; i<board.length; i++)
			System.out.format("%s\n",Arrays.toString(board[i]));
		surroundedRegions(board);
		System.out.println("Flipped board is:");
		for(int i = 0; i<board.length; i++)
			System.out.format("%s\n",Arrays.toString(board[i]));
	}
}