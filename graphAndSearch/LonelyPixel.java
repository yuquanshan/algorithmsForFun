/** Given a picture consisting of black and white pixels, 
* find the number of black lonely pixels.
*
* The picture is represented by a 2D char array consisting 
* of 'B' and 'W', which means black and white pixels respectively.
*
* A black lonely pixel is character 'B' that located at a 
* specific position where the same row and same column don't 
* have any other black pixels.
*
* Example:
* Input: 
* [['W', 'W', 'B'],
*  ['W', 'B', 'W'],
*  ['B', 'W', 'W']]
*
* Output: 3
* Explanation: All the three 'B's are black lonely pixels.
*
* Note:
* The range of width and height of the input 2D array is [1,500].
*
* public int findLonelyPixel(char[][] picture)
*/
import java.util.*;

public class LonelyPixel {
	public int findLonelyPixel(char[][] picture) {	// O(mn) space algorithm, in my first try
		if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;
		int count = 0;
		int[][] matrix = new int[picture.length][picture[0].length];
		for(int i = 0; i < picture.length; i++) {
			int left = 0; int right = 0;
			for(int j = 0; j < picture[0].length; j++) {
				if(picture[i][j] == 'B') matrix[i][j] += ++left;
				if(picture[i][picture[0].length -1 - j] == 'B') matrix[i][picture[0].length -1 - j] += right++; 
			}
		}
		for(int i = 0; i < picture[0].length; i++) {
			int up = 0; int down = 0;
			for(int j = 0; j < picture.length; j++) {
				if(picture[j][i] == 'B') matrix[j][i] += up++;
				if(picture[picture.length - 1 - j][i] == 'B') matrix[picture.length - 1 - j][i] += down++;
			}
		}
		for(int i = 0; i < picture.length; i++) {
			for(int j = 0; j < picture[0].length; j++) {
				if(matrix[i][j] == 1) count++;
			}
		}
		return count;
	}
	public int findLonelyPixel2(char[][] picture) { 	// O(m) space algorithm, after seeing solution online 
		if(picture == null || picture.length == 0 || picture[0].length == 0) return 0;
		int m = picture.length;
		int n = picture[0].length;
		int count = 0;
		int[] rowCount = new int[m];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(picture[i][j] == 'B') rowCount[i]++;
			}
		}
		for(int i = 0; i < n; i++) {
			int pos = 0;
			int colCount = 0;
			for(int j = 0; j < m; j++) {
				if(picture[i][j] == 'B') {
					pos = j; 
					colCount++;
				}
			}
			if(colCount == 1 && rowCount[pos] == 1) count++;
		}
		return count;
	}
	// of course, there is a O(1) space algorithm which uses the space of existing matrix picture
	public static void main(String[] args) {
		//char[][] picture = {{'W', 'W', 'B'},{'W', 'B', 'W'},{'B', 'W', 'W'}};
		String[] str = {"BWWWWBWBBW","BBBWWWBWBW","BBBBWWWBWW","BWWBWBBWWW","WWBWBBBWBB","WBBWWWBWWW","BWWBBBWWWW","WWWBBBBWWW","WWBBWWWWBW","WWWBBBWWWB"};
		char[][] picture = new char[str.length][];
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
			picture[i] = str[i].toCharArray();
		}
		LonelyPixel test = new LonelyPixel();
		System.out.println(test.findLonelyPixel2(picture));
	}
}