import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Stock Check
 */

/**
 * @author yun
 *
 */
public class StockTest {

	/**
	 * main function
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// yesterday's stock prices
		int[] stock_prices = { 10, 3, 5, 90, 9, 2, 16, 2, 5, 7, 8, 23, 67, 1, 78, 34, 90, 100, 3, 4, 5, 6, 1, 103 };
		int max_profit = 0;
		// calendar
		Calendar cld = Calendar.getInstance();

		// print the start time
		System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(cld.getTime()));

		// get the best profit for yesterday
		max_profit = getMaxProfit(stock_prices);

		// print the end time
		System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS").format(cld.getTime()));

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
				// compare the stock price with the max price of the left array with bigger
				// indexes
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
