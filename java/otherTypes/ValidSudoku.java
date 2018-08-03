/**
 * Given a partially filled Sudoku board,
 * check whether it is valid.
 *
 * public boolean isValidSudoku(char[][] board) {}
 */
import java.util.*;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		int[] n2p = {0, 2, 3, 5, 7, 11, 13, 17, 19, 23};
		int[] rowmap = new int[9];
		int[] colmap = new int[9];
		int[] blkmap = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int n = board[i][j] - '0';
					if (n <= 0 || n > 9) return false;
					int num = n2p[n];
					if (rowmap[i] == 0) rowmap[i] = num;
					else {
						if (rowmap[i]%num == 0) return false;
						else rowmap[i] *= num;
					}
					if (colmap[j] == 0) colmap[j] = num;
					else {
						if (colmap[j]%num == 0) return false;
						else colmap[j] *= num;
					}
					int blkn = 3*(j/3) + i/3;	// calc block number
					if (blkmap[blkn] == 0) blkmap[blkn] = num;
					else {
						if (blkmap[blkn]%num == 0) return false;
						else blkmap[blkn] *= num;
					}
				}
			}
		}
		return true;
	}
}