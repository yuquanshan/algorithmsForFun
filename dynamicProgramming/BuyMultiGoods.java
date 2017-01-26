/**
* given a certain amount of money and multiple goods with 
* prices. how can you spend your money as much as possible.
* public static ArrayList<Integer> buyMultiGoods(int[] prices, int money)
*/
import java.util.*;

public class BuyMultiGoods{
	public static ArrayList<Integer> buyMultiGoods(int[] prices, int money){
		if(money == 0 || prices == null || prices.length == 0)
			return null;
		int[][] matrix = new int[money+1][prices.length+1];
		int[][] add = new int[money+1][prices.length+1];
		for(int i = 1; i<=money; i++){
			for(int j = 1; j<=prices.length; j++){
				if(prices[j-1] > i){
					add[i][j] = 0;
					matrix[i][j] = matrix[i][j-1];
				}else{
					int tmp = matrix[i][j-1];
					int tmp2 = matrix[i-prices[j-1]][j-1]+prices[j-1];
					if(tmp2 >= tmp){
						matrix[i][j] = tmp2;
						add[i][j] = 1;
					}else{
						matrix[i][j] = tmp;
						add[i][j] = 0;
					}
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		int left = money;
		int pos = prices.length-1;
		while(left >= 0 && pos>=0){
			if(add[left][pos+1] == 1){
				res.add(prices[pos]);
				left = left - prices[pos];
				pos--;
			}else{
				pos--;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] prices = {2,7,7,11};
		int money  =15;
		ArrayList<Integer> res = buyMultiGoods(prices,money);
		System.out.println(res.toString());
	}
}