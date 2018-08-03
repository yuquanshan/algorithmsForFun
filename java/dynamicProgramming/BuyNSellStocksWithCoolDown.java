/** Say you have an array for which the ith element is 
* the price of a given stock on day i.
*
* Design an algorithm to find the maximum profit. You may 
* complete as many transactions as you like (ie, buy one 
* and sell one share of the stock multiple times) with the 
* following restrictions:
*
* You may not engage in multiple transactions at the same 
* time (ie, you must sell the stock before you buy again).
* After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
* Example:
* prices = [1, 2, 3, 0, 2]
* maxProfit = 3
* transactions = [buy, sell, cooldown, buy, sell]
*
* public int maxProfit(int[] prices)
* (DP can do in constant space)
*/

import java.util.*;

public class BuyNSellStocksWithCoolDown{
	public static int maxProfit(int[] prices){
		if(prices == null || prices.length <= 1)
			return 0;
		int[] barray = new int[prices.length];
		int[] sarray = new int[prices.length];
		int[] carray = new int[prices.length];
		for(int i = 1; i<prices.length; i++){
			barray[i] = Math.max(barray[i-1]+prices[i]-prices[i-1],carray[i-1]);
			carray[i] = Math.max(sarray[i-1],carray[i-1]);
			sarray[i] = barray[i-1]+prices[i]-prices[i-1];
		}
		return Math.max(carray[prices.length-1], sarray[prices.length-1]);
	}
	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
}