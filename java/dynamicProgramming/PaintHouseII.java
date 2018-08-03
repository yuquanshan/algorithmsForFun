/**
 * There are a row of n houses, each house can be painted with one 
 * of the k colors. The cost of painting each house with a certain 
 * color is different. You have to paint all the houses such that no 
 * two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented 
 * by a n x k cost matrix. For example, costs[0][0] is the cost of 
 * painting house 0 with color 0; costs[1][2] is the cost of painting 
 * house 1 with color 2, and so on... Find the minimum cost to paint 
 * all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Follow up:
 * Could you solve it in O(nk) runtime?
 *
 * public int minCostII(int[][] costs)
 */

import java.util.*;

public class PaintHouseII {
	public int minCostII(int[][] costs) {
		if (costs == null || costs.length == 0 || costs[0].length == 0)
			return 0;
		// table[i][j]: the min cost if i paint house i with color j
		int[][] table = new int[costs.length][costs[0].length];
		int smallest = Integer.MAX_VALUE;
		int secondsmallest = Integer.MAX_VALUE;
		int smallestcolor = -1;
        int lastsmallest = 0;
        int lastsecondsmallest = 0;
        int lastsmallestcolor = -1;
		for (int i = 0; i < costs.length; i++) {
			smallest = Integer.MAX_VALUE;
		    secondsmallest = Integer.MAX_VALUE;
			for (int j = 0; j < costs[0].length; j++) {    
                if (j != lastsmallestcolor)
					table[i][j] = lastsmallest + costs[i][j];
				else
					table[i][j] = lastsecondsmallest + costs[i][j];
				if (table[i][j] < smallest) {
					secondsmallest = smallest;
					smallest = table[i][j];
					smallestcolor = j;
				} else if (table[i][j] < secondsmallest) {
					secondsmallest = table[i][j];
				}   
			}
			lastsmallest = smallest; 
			lastsecondsmallest = secondsmallest;
            lastsmallestcolor = smallestcolor;
		}
		return smallest;
	}
	public static void main(String[] args) {
		int[][] input = {{1,5,3},{2,9,4}};
		PaintHouseII test = new PaintHouseII();
		System.out.println(test.minCostII(input));
	}
}