/** Design a Tic-tac-toe game that is played between two players on a n x n grid.
*
* You may assume the following rules:
*
* A move is guaranteed to be valid and is placed on an empty block.
* Once a winning condition is reached, no more moves is allowed.
* A player who succeeds in placing n of their marks in a horizontal, 
* vertical, or diagonal row wins the game.
* Example:
* Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.
*
* TicTacToe toe = new TicTacToe(3);
*
* toe.move(0, 0, 1); -> Returns 0 (no one wins)
* |X| | |
* | | | |    // Player 1 makes a move at (0, 0).
* | | | |
* 
* toe.move(0, 2, 2); -> Returns 0 (no one wins)
* |X| |O|
* | | | |    // Player 2 makes a move at (0, 2).
* | | | |
*
* toe.move(2, 2, 1); -> Returns 0 (no one wins)
* |X| |O|
* | | | |    // Player 1 makes a move at (2, 2).
* | | |X|
* 
* toe.move(1, 1, 2); -> Returns 0 (no one wins)
* |X| |O|
* | |O| |    // Player 2 makes a move at (1, 1).
* | | |X|
* 
* toe.move(2, 0, 1); -> Returns 0 (no one wins)
* |X| |O|
* | |O| |    // Player 1 makes a move at (2, 0).
* |X| |X|
* 
* toe.move(1, 0, 2); -> Returns 0 (no one wins)
* |X| |O|
* |O|O| |    // Player 2 makes a move at (1, 0).
* |X| |X|
* 
* toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
* |X| |O|
* |O|O| |    // Player 1 makes a move at (2, 1).
* |X|X|X|
* Follow up:
* Could you do better than O(n^2) per move() operation?
* public class TicTacToe {
*    	
*    	public TicTacToe(int n) {}
*   	public int move(int row, int col, int player) {}
* 	}
* (there is an O(1) algorithm)
*/

public class TicTacToe {

    /** Initialize your data structure here. */
    char[][] table;
    int scale;
    public TicTacToe(int n) {
        table = new char[n][n];
        scale = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int r = 0, c = 0, d1 = 0, d2 = 0;
        if(player == 1){
        	table[row][col] = 'O';
        	for(int i = 0; i<scale; i++){
        		if(table[row][i] == 'O')
        			r++;
        		if(table[i][col] == 'O')
        			c++;
        		if(table[i][i] == 'O')
        			d1++;
        		if(table[i][scale-1-i] == 'O')
        			d2++;
        	}
        	if(r == scale || c == scale || d1 == scale || d2 == scale)
        		return 1;
        	else
        		return 0;
        }else{
        	table[row][col] = 'X';
        	for(int i = 0; i<scale; i++){
        		if(table[row][i] == 'X')
        			r++;
        		if(table[i][col] == 'X')
        			c++;
        		if(table[i][i] == 'X')
        			d1++;
        		if(table[i][scale-1-i] == 'X')
        			d2++;
        	}
        	if(r == scale || c == scale || d1 == scale || d2 == scale)
        		return 2;
        	else
        		return 0;
        }
    }
    public static void main(String[] args) {
    	TicTacToe toe = new TicTacToe(3);
    	toe.move(0, 0, 1);
		toe.move(0, 2, 2);
		toe.move(2, 2, 1);
		toe.move(1, 1, 2);
		toe.move(2, 0, 1);
		toe.move(1, 0, 2);
		if(toe.move(2, 1, 1) == 1) System.out.println("Test passed!");

    }
}