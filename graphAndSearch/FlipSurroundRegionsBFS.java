/**
* given a 2D board containing 'X' and 'O', flip all 'O' 
* regoins to 'X'.
* public static void surroundedRegions(char[][] board)
* (now try to do it in BFS)
*/
import java.util.*;

public class FlipSurroundRegionsBFS{
	public static void surroundedRegions(char[][] board){
		if(board == null || board.length == 0 || board[0].length == 0)
			return;
		for(int i = 0; i<board.length; i++){
			if(board[i][0] == 'O'){
				BFScontamination(board,i,0);
			}	
			if(board[i][board[0].length-1] == 'O'){
				BFScontamination(board,i,board[0].length-1);
			}
		}	
		for(int i = 0; i<board[0].length; i++){
			if(board[0][i] == 'O'){
				BFScontamination(board,0,i);
			}
			if(board[board.length-1][i] == 'O'){
				BFScontamination(board,board.length-1,i);
			}
		}

		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
				if(board[i][j] == '#')
					board[i][j] = 'O';
				else if(board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}
	private static void BFScontamination(char[][] board, int x, int y){
		LinkedList<Integer> xqueue = new LinkedList<Integer>();
		LinkedList<Integer> yqueue = new LinkedList<Integer>();
		xqueue.add(x);
		yqueue.add(y);
		board[x][y] = '#';
		while(xqueue.size() != 0){
			int size = xqueue.size();
			for(int i = 0; i<size; i++){
				int xx = xqueue.poll();
				int yy = yqueue.poll();
				if(xx>0 && board[xx-1][yy] == 'O'){
					board[xx-1][yy] = '#';
					xqueue.add(xx-1);
					yqueue.add(yy);
				}
				if(xx<board.length-1 && board[xx+1][yy] == 'O'){
					board[xx+1][yy] = '#';
					xqueue.add(xx+1);
					yqueue.add(yy);
				}
				if(yy>0 && board[xx][yy-1] == 'O'){
					board[xx][yy-1] = '#';
					xqueue.add(xx);
					yqueue.add(yy-1);
				}
				if(yy<board[0].length-1 && board[xx][yy+1] == 'O'){
					board[xx][yy+1] = '#';
					xqueue.add(xx);
					yqueue.add(yy+1);
				}
			}
		}
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