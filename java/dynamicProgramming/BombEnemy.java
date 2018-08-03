/**
* given a 2-D character grid with '0' indicating an empty land,
* 'W' indicating a wall, 'E' indicating enemy. a bomb can kill 
* a whole row and column of enemy, place a bomb to kill as many 
* enemies as you can, return that max number.
* public static int maxKilledEnemies(char[][] grid){}
*/

public class BombEnemy{
	public static int maxKilledEnemies(char[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[] col = new int[m];
		int[] row = new int[n];
		int[][] killMatrix = new int[m][n];
		// -> kill
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(j == 0){
					if(grid[i][j] == 'E'){
						row[j] = 1;
					}else{
						row[j] = 0;
					}
				}else{
					 if(grid[i][j] == 'E'){
					 	row[j] = row[j-1]+1;
					 }else if(grid[i][j] == 'W'){
					 	row[j] = 0;
					 }else{
					 	row[j] = row[j-1];
					 }
				}
				killMatrix[i][j]+=row[j];
			}
		}
		// <- kill
		for(int i = 0; i<m; i++){
			for(int j = n-1; j>=0; j--){
				if(j == n-1){
					if(grid[i][j] == 'E'){
						row[j] = 1;
					}else{
						row[j] = 0;
					}
				}else{
					if(grid[i][j] == 'E'){
						row[j] = row[j+1]+1;
					}else if(grid[i][j] == 'W'){
						row[j] = 0;
					}else{
						row[j] = row[j+1];
					}
				}
				killMatrix[i][j]+=row[j];
			}
		}
		// down kill
		for(int j = 0; j<n; j++){
			for(int i = 0; i<m; i++){
				if(i == 0){
					if(grid[i][j] == 'E'){
						col[i] = 1;
					}else{
						col[i] = 0;
					}
				}else{
					if(grid[i][j] == 'E'){
						col[i] = col[i-1]+1;
					}else if(grid[i][j] == 'W'){
						col[i] = 0;
					}else{
						col[i] = col[i-1];
					}
				}
				killMatrix[i][j]+=col[i];
			}
		}
		// up kill
		int maxSoFar = 0;
		for(int j = 0; j<n; j++){
			for(int i = m-1; i>=0; i--){
				if(i == m-1){
					if(grid[i][j] == 'E'){
						col[i] = 1;
					}else{
						col[i] = 0;
					}
				}else{
					if(grid[i][j] == 'E'){
						col[i] = col[i+1]+1;
					}else if(grid[i][j] == 'W'){
						col[i] = 0;
					}else{
						col[i] = col[i+1];
					}
				}
				if(grid[i][j] == '0')
					maxSoFar = (maxSoFar<killMatrix[i][j]+col[i])?killMatrix[i][j]+col[i]:maxSoFar;
			}
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		char[][] grid = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
		System.out.format("Max number of enemy you can kill is %d\n",maxKilledEnemies(grid));
	}
}