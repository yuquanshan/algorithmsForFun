/**
given an array of prices in a time series, find the maximum profit 
if mutiple buy-sell pairs are allowed.
public static int maxProfit(int[] prices)
*/
import java.util.*;
public class MultiPairBuyNSellMaxProfit{
	public static int maxProfit(int[] prices){
		if(prices == null || prices.length <= 1)
			return 0;
		int startP = -1;
		int accProfit = 0;
		int i = 0;
		while(i < prices.length-1){
			if(startP == -1){
				if(prices[i+1]>prices[i]){
					startP = prices[i];
				}
			}else{
				if(prices[i+1]<prices[i]){
					accProfit = accProfit + prices[i]-startP;
					startP = -1;
				}
			}
			i += 1;
		}
		if(startP != -1){
			accProfit = accProfit + prices[prices.length-1]-startP;
		}
		return accProfit;
	}
	public static void main(String[] args) {
		int[] prices = {2,1,2,0,1};
		System.out.format("The max profit of price trace %s is %d.\n",Arrays.toString(prices),maxProfit(prices));
	}
}