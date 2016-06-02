package com.jpmorgan.helper;

import com.jpmorgan.exception.StockCalculatorException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for StockCalculatorHelperImpl
 *
 * @author Catalin Stoiovici
 */
public class StockCalculatorImplTest {

	private StockCalculatorImpl stockCalculatorHelper = new StockCalculatorImpl();

	@Test
	public void testCalculateDividendYieldCommon() {
		assertEquals(0d, stockCalculatorHelper.calculateDividendYieldCommon(100d, 0d), 0d);

		double result = stockCalculatorHelper.calculateDividendYieldCommon(0d, 1.5d);
		assertTrue(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY);

		assertEquals(0.06969696969696969d, stockCalculatorHelper.calculateDividendYieldCommon(33d, 2.3d), 0d);
	}

	@Test
	public void testCalculateDividendYieldPreferred() {
		assertEquals(0d, stockCalculatorHelper.calculateDividendYieldPreferred(100d, 0d, 0.2d), 0d);

		double result = stockCalculatorHelper.calculateDividendYieldPreferred(0d, 21d, 0.7d);
		assertTrue(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY);

		assertEquals(0d, stockCalculatorHelper.calculateDividendYieldPreferred(100d, 20d, 0d), 0d);

		assertEquals(0.060000000000000005d, stockCalculatorHelper.calculateDividendYieldPreferred(55d, 33d, 0.1d), 0d);
	}

	@Test
	public void testCalculatePeRatio() {
		assertEquals(0d, stockCalculatorHelper.calculatePERatio(0d, 2.31d), 0d);

		double result = stockCalculatorHelper.calculatePERatio(250d, 0d);
		assertTrue(result == Double.POSITIVE_INFINITY || result == Double.NEGATIVE_INFINITY);

		assertEquals(12.274368231046932d, stockCalculatorHelper.calculatePERatio(34d, 2.77d), 0d);
	}

	@Test
	public void testCalculateGeometricMean() {
		assertEquals(0d, stockCalculatorHelper.calculateGeometricMean(), 0d);

		assertEquals(0d, stockCalculatorHelper.calculateGeometricMean(0d), 0d);

		assertEquals(25.501924946552673, stockCalculatorHelper.calculateGeometricMean(75d, 7.43d, 23d, 33d), 0d);

		assertEquals(0d, stockCalculatorHelper.calculateGeometricMean(0d, 7.43d), 0d);
	}

	@Test
	public void testCalculateStockPrice() throws StockCalculatorException {
		assertEquals(0d, stockCalculatorHelper.calculateStockPrice(null, null), 0d);
		try {
			stockCalculatorHelper.calculateStockPrice(new double[] { 65d, 94d, 5.2 }, null);
			fail("A StockCalculatorException was thrown");
		} catch (StockCalculatorException e) {
		}
		try {
			stockCalculatorHelper.calculateStockPrice(new double[] { 55d, 44d, 4.7 },
					new double[] { 67d, 22d, 11d, 65d });
			fail("A StockCalculatorException was thrown");
		} catch (StockCalculatorException e) {
		}
		assertEquals(23.033333333333335d, stockCalculatorHelper.calculateStockPrice(new double[] { 12d, 33d, 3.1d },
				new double[] { 67d, 22d, 11d }), 0d);
	}
}
