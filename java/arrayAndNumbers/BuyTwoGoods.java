/**
* you have a set of goods with prices sorted in ascending order, 
* and have k dollars, find a way to buy two goods while spending 
* as much as you can.
* public static int[] buyTwo(int[] prices){}
* (a Google interview problem)
*/
import java.util.*;

public class BuyTwoGoods{
	public static int[] buyTwo(int[] prices, int money){
		if(prices == null || prices.length < 2){
			return null;
		}
		int[] res = new int[2];
		boolean canBuy = false;
		int left = 0;
		int right = prices.length-1;
		int closestSoFar = -1;
		while(left < right){
			if(prices[left]+prices[right] == money){
				res[0] = left;
				res[1] = right;
				return res;
			}else if(prices[left]+prices[right] > money){
				right--;
			}else{
				canBuy = true;
				if(closestSoFar < prices[left]+prices[right]){
					closestSoFar = prices[left]+prices[right];
					res[0] = left;
					res[1] = right;
				}
				left++;
			}
		}
		if(canBuy)
			return res;
		else
			return null;
	}
	public static void main(String[] args) {
		int[] prices = {3,7,7,10,13};
		int money = 15;
		int[] res = buyTwo(prices,money);
		System.out.println(Arrays.toString(res));
	}
}