import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for Stock Check
 */

/**
 * @author yun
 *
 */
class JUnitStockTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//no code, but generally we do some setup for the test
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		//no code, but generally we do some teardown for the test
	}

	
	@Test
	void test1() {
		int[] stockPrices = {10, 7, 5, 8, 11, 9};

		Assert.assertEquals (6, StockTest.getMaxProfit(stockPrices)); // returns 6 (buy at $5 sell at $11)
	}
	
	void test2() {
		int[] stockPrices = {3, 3, 3, 3, 3, 3};

		Assert.assertEquals (0, StockTest.getMaxProfit(stockPrices)); // returns 0
	}
	
	void test3() {
		int[] stockPrices = {9, 8, 7, 6, 5, 4};

		Assert.assertEquals (0, StockTest.getMaxProfit(stockPrices)); // returns 0
	}

	@Test
	void test4() {
		int[] stockPrices = {18, 7, 1, 2, 11, 17, 19};

		Assert.assertEquals (18, StockTest.getMaxProfit(stockPrices)); // returns 18 (buy at $1 sell at $19)
	}

	@Test
	void test5() {
		int[] stockPrices = {18, 7, 1, 2, 20, 1, 21};

		Assert.assertEquals (20, StockTest.getMaxProfit(stockPrices)); // returns 20 (buy at $1 sell at $21)
	}
	
	@Test
	void test6() {
		int[] stockPrices = {28, 7, 1, 2, 20, 1, 21};

		Assert.assertEquals (20, StockTest.getMaxProfit(stockPrices)); // returns 20 (buy at $1 sell at $21)
	}


}
