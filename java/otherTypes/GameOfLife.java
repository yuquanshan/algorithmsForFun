/* According to the Wikipedia's article: "The Game of Life, 
* also known simply as Life, is a cellular automaton devised 
* by the British mathematician John Horton Conway in 1970."

* Given a board with m by n cells, each cell has an initial 
* state live (1) or dead (0). Each cell interacts with its 
* eight neighbors (horizontal, vertical, diagonal) using the 
* following four rules (taken from the above Wikipedia article):

* Any live cell with fewer than two live neighbors dies, as if caused by under-population.
* Any live cell with two or three live neighbors lives on to the next generation.
* Any live cell with more than three live neighbors dies, as if by over-population..
* Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
* Write a function to compute the next state (after one update) of the board given its current state.

* Follow up: 
* Could you solve it in-place? Remember that the board needs to be updated at the same time: 
* You cannot update some cells first and then use their updated values to update other cells.
* In this question, we represent the board using a 2D array. In principle, the board is infinite, 
* which would cause problems when the active area encroaches the border of the array. How would 
* you address these problems?

* public void gameOfLife(int[][] board){}
*/
import java.util.*;

public class GameOfLife{
	// why not define states for cells, 'cause we don't want to our neighbors to affect whether i'm 
	// currently dead or not, so if oen cell's next fate is determined, don't change dead or live immediately,
	// just try to introduce some other states so that its neighbors know it's currently dead or not
	// dead -> dead: 100
	// dead -> live: 101
	// live -> dead: 110
	// live -> live: 111
	public static void gameOfLife(int[][] board){
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++){
				int count = 0;
				if(i>0 && (board[i-1][j] >= 110 || board[i-1][j] == 1))
					count++;
				if(j>0 && ((board[i][j-1] >= 110 || board[i][j-1] == 1)))
					count++;
				if(i<board.length-1 && (board[i+1][j] >= 110 || board[i+1][j] == 1))
					count++;
				if(j<board[0].length-1 && (board[i][j+1] >= 110 || board[i][j+1] == 1))
					count++;
				if(i>0 && j>0 && (board[i-1][j-1] >= 110 || board[i-1][j-1] == 1))
					count++;
				if(i>0 && j<board[0].length-1 && (board[i-1][j+1] >= 110 || board[i-1][j+1] == 1))
					count++;
				if(i<board.length-1 && j>0 && (board[i+1][j-1] >= 110 || board[i+1][j-1] == 1))
					count++;
				if(i<board.length-1 && j<board[0].length-1 && (board[i+1][j+1] >= 110 || board[i+1][j+1] == 1))
					count++;
				if(board[i][j] == 0){
					if(count == 3)
						board[i][j] = 101;
					else
						board[i][j] = 100;
				}else{
					if(count < 2 || count > 3)
						board[i][j] = 110;
					else
						board[i][j] = 111;
				}
			}
		}
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[0].length; j++)
				board[i][j] = board[i][j]%2;
		}
	}
	public static void main(String[] args) {
		int[][] board = new int[4][4];
		board[1][1] = 1; board[1][2] = 1; board[2][1] = 1; board[2][2] = 1;
		System.out.println();
		System.out.println("Original board is ");
		for(int[] a: board)
			System.out.println(Arrays.toString(a));
		gameOfLife(board);
		System.out.println("Updated board is ");
		for(int[] a: board)
			System.out.println(Arrays.toString(a));
	}
}