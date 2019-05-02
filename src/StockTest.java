import java.util.Arrays;

/**
 * Stock Check
 */

/**
 * @author yun
 *
 */
public class StockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// yesterday's stock prices
		int[] stock_prices = { 2, 3, 5, 1, 9, 2, 16, 2, 5, 7, 8, 23, 67, 1, 78, 34, 2 };
		int max_profit = 0;

		// get the best profit for yesterday
		max_profit = getMaxProfit(stock_prices);
		// print the best profit
		System.out.println(max_profit);
	}

	/**
	 * get the best profit
	 * 
	 * @param stockPrice
	 * @return best Profit
	 */
	protected static int getMaxProfit(int[] stockPrice) {
		int profit = 0;
		int buyPrice = 0;
		int[] tempArray;
		int max = 0;
		int min = 0;
		boolean boFlg = false;

		for (int i = 0; i < stockPrice.length; i++) {
			int buy = stockPrice[i];
			// if the current value bigger than the buyPrice, no need to compare
			if (boFlg == true && buy >= buyPrice)
				continue;
			if (i + 1 < stockPrice.length) {
				// compare the stock price with the max price of the left array with bigger indexes
				tempArray = (int[]) Arrays.copyOfRange(stockPrice, i + 1, stockPrice.length);
				// get min and max value from the left array
				max = Arrays.stream(tempArray).max().getAsInt();
				min = Arrays.stream(tempArray).min().getAsInt();
				// calculate the profit
				int tempProfit = max - buy;
				// compare the profits
				if (tempProfit >= profit) {
					boFlg = true;
					profit = tempProfit;
					buyPrice = buy;
					// if the buy value is the smallest, then end loop
					if (buy == min)
						break;
				}
			}
		}
		return profit;
	}

}
