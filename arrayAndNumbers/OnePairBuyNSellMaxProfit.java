/**
given an array of prices in a time series, 
find a buy-sell pair which maximize the profit.
public static int maxProfit(int[] prices)
*/
import java.util.*;

public class OnePairBuyNSellMaxProfit{
	public static int maxProfit(int[] prices){
		if(prices == null || prices.length <= 1)
			return 0;
		int startP = -1;
		int maxSoFar = 0;
		int i = 0;
		while(i < prices.length - 1){
			if(startP == -1){
				if(prices[i]<prices[i+1])
					startP = prices[i];
				i += 1;
			}else{
				if(prices[i] >= startP){
					if(prices[i] - startP > maxSoFar)
						maxSoFar = prices[i] - startP;
					i += 1;
				}else{
					startP = -1;
				}
			}
		}
		if(startP != -1 && prices[prices.length-1] - startP > maxSoFar){
			maxSoFar = prices[prices.length-1] - startP;
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] prices = {3,2,3,1,2};
		System.out.format("The max profit in the prices trace %s, is %d.\n",Arrays.toString(prices),maxProfit(prices));
	}
}