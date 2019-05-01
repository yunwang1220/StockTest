import java.util.Arrays;

/**
 * Stock Check
 */

/**
 * @author yun
 *
 */
public class StockTest {

	
	// these variables are for further use
	static int buyPrice = 0;
	static int index_buy = 0;
	static int sellPrice = 0;
	static int index_sell = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// yesterday's stock prices
		int[] stock_prices = {2,3,5,1,9,2,16,2,5,7,8,23,67,1,78,34,2};
		int max_profit = 0;
		
		// get the best profit for yesterday
		max_profit = getMaxProfit(stock_prices);
		// print the best profit
		System.out.println(max_profit);
	}

	/**
	 * get the best profit
	 * @param stockPrice
	 * @return best Profit
	 */
	static int getMaxProfit(int[] stockPrice){
		int profit = 0;
		int[] tempArray;
		int max = 0;
		int min = 0;
		boolean boFlg = false;
		
		for(int i=0; i<stockPrice.length; i++) {
			int buy = stockPrice[i];
			// if the current value bigger than the buyPrice, no need to compare
			if(boFlg == true && buy >= buyPrice) 
				continue;
			if(i+1 < stockPrice.length) {
				//compare the stock price with the max price of the left array with bigger indexes
				tempArray = (int[])Arrays.copyOfRange(stockPrice,i+1,stockPrice.length);
				max = Arrays.stream(tempArray).max().getAsInt();
				min = Arrays.stream(tempArray).min().getAsInt();
				int tempProfit = max - buy;
				if(tempProfit >= profit) {
					boFlg = true;
					profit = tempProfit;
					buyPrice = buy;
					// for further use
					index_buy = i;

					// if the chosen buy value is the smallest, end loop
					if(buy == min) 
						break;
				}
			}
		}		
		return profit;
	}
	

	/**
	 * get the index of particular price in Array
	 * for further use.
	 * 
	 * @param arr search array
	 * @param start start searching position
	 * @param value particular price
	 * @return position in array
	 */
    public static int getIndex(int[] arr, int start, int value) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;// not found
    }

}
