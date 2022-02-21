package ctci;

import java.util.HashMap;

/**
 *  
 * 
 * @author m.ali
 *
 */
public class CoinChange {
	
	/**
	 * 
	 * @param coins A list of all the denominations
	 * @param money A certain amount of money
	 * @return How many different ways can we do that.
	 */
	public static long makeChange(int[] coins, int money) {
		return makeChange(coins, money, 0, new HashMap<String, Long>());
	}
	
	private static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
		if(money == 0) {
			return 1;
		}
		if(index >= coins.length) {
			return 0;
		}
		
		String key = money + "-" + index;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		
		int amountWithCoin = 0;
		long ways = 0;
		
		while(amountWithCoin <= money) {
			int remaining = money - amountWithCoin;
			ways += makeChange(coins, remaining, index+1, memo);
			amountWithCoin += coins[index];
		}
		
		memo.put(key, ways);
		
		return ways;
	}
}
