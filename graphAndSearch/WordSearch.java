/**
* given a 2-D character board(matrix) and word, return whether 
* the word can be constructed from characters of adjacent cell.
* public static boolean exist(char[][] board, String word)  
*/
import java.util.*;

public class WordSearch{
	public static boolean exist(char[][] board, String word){
		int w = board[0].length;
		for(int i = 0; i<board.length; i++){
			for(int j = 0; j<board[i].length; j++){
				if(board[i][j]==word.charAt(0)){
					HashSet<Integer> visited = new HashSet<Integer>();
					visited.add(i*w+j);
					if(DFSsearch(board,word,i,j,0,visited)){
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean DFSsearch(char[][] board, String word, int x, int y, int offset, HashSet<Integer> visited){
		int w = board[0].length;
		if(offset == word.length()-1){
			if(board[x][y] == word.charAt(word.length()-1))
				return true;
		}
		if(x>0){
			if(board[x-1][y]==word.charAt(offset+1) && !visited.contains(w*(x-1)+y)){
				visited.add(w*(x-1)+y);
				if(DFSsearch(board,word,x-1,y,offset+1,visited))
					return true;
				visited.remove(w*(x-1)+y);
			}
		}
		if(x<board.length-1){
			if(board[x+1][y]==word.charAt(offset+1) && !visited.contains(w*(x+1)+y)){
				visited.add(w*(x+1)+y);
				if(DFSsearch(board,word,x+1,y,offset+1,visited))
					return true;
				visited.remove(w*(x+1)+y);
			}
		}
		if(y>0){
			if(board[x][y-1]==word.charAt(offset+1) && !visited.contains(w*x+y-1)){
				visited.add(w*x+y-1);
				if(DFSsearch(board,word,x,y-1,offset+1,visited))
					return true;
				visited.remove(w*x+y-1);
			}
		}
		if(y<w-1){
			if(board[x][y+1]==word.charAt(offset+1) && !visited.contains(w*x+y+1)){
				visited.add(w*x+y+1);
				if(DFSsearch(board,word,x,y+1,offset+1,visited))
					return true;
				visited.remove(w*x+y+1);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		if(exist(board,word))
			System.out.format("%s exists on board\n",word);
		else
			System.out.format("%s doesn't exisit on board\n",word);
	}
}