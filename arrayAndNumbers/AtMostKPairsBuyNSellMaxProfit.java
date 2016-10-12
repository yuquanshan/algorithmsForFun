/*
given an array of prices, find the max profit if can buy and sell at most k times
static public int maxProfit(int k, int[] prices)
(failed to figure out O(nk) algorithm in the first time, need to pay extra attention to this hard problem 10/12/2016)
*/
import java.util.*;

public class AtMostKPairsBuyNSellMaxProfit{
	static public int maxProfit(int k, int[] prices){
		if(prices == null || prices.length <= 1)
			return 0;
		int[][] local = new int[prices.length][k+1];	// local[i][.]: the max profit if must sell at i
		int[][] global = new int[prices.length][k+1];	// global[i][.]: the max profit before(including) i
		for(int i = 0; i<prices.length; i++){
			local[i][0] = 0;
			global[i][0] = 0;
		}
		for(int i = 0; i<=k; i++){
			local[0][i] = 0;
			global[0][i] = 0;
		}
		for(int i = 1; i <= k; i++){
			for(int j = 1; j < prices.length; j++){
				local[j][i] = Math.max(local[j-1][i]+prices[j]-prices[j-1],global[j-1][i-1]+prices[j]-prices[j-1]);
				global[j][i] = Math.max(local[j][i],global[j-1][i]);
			}
		}
		return global[prices.length-1][k];
	}
	public static void main(String[] args) {
		int[] prices = {4,4,6,1,1,4,2,5};
		int k = 2;
		System.out.format("The array is %s.\n",Arrays.toString(prices));
		System.out.format("The max profit within %d buy and sell pair(s) is %d.\n",k,maxProfit(k,prices));
	}
}