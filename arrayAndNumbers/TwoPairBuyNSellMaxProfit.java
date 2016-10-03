/**
given an array of prices in a time series, find the maximum profit 
if only two buy-sell pairs are allowed.
public static int maxProfit(int[] prices)
(failed to give a correct algorithm in the first time)
*/
import java.util.*;

public class TwoPairBuyNSellMaxProfit{
	public static int maxProfit(int[] prices){
		if(prices == null || prices.length <= 1)
			return 0;
		int[] pre = new int[prices.length];	// the max profit achieved ending at index i
		int[] post = new int[prices.length]; // the max profit achieved starting at index j
		int min = prices[0];
		pre[0] = 0;
		for(int i = 1; i<prices.length; i++){
			min = prices[i]<min?prices[i]:min;
			pre[i] = Math.max(prices[i]-min,pre[i-1]);
		}
		post[prices.length-1] = 0;
		int max = prices[prices.length-1];
		for(int i = prices.length-2; i>=0; i--){
			max = prices[i]>max?prices[i]:max;
			post[i] = Math.max(max-prices[i],post[i+1]);
		}
		int maxSoFar = pre[prices.length - 1];
		for(int i = 0; i < prices.length-1; i++){
			maxSoFar = Math.max(maxSoFar,pre[i]+post[i+1]);
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] prices = {1,2};	//{4,4,6,1,1,4,2,5};
		System.out.format("The max profit of price trace %s is %d.\n",Arrays.toString(prices),maxProfit(prices));
	}
}