package com.jpmorgan.helper;

import com.jpmorgan.exception.StockCalculatorException;

/**
 * Interface of stock calculation helpers
 *
 * @author Catalin Stoiovici
 */
public interface StockCalculator {

	/**
	 * Calculate de dividend yield of a given Common stock - tickerPrice and
	 * dividend
	 *
	 * @param tickerPrice
	 * @param lastDividend
	 * @return stock dividend yield
	 */
	double calculateDividendYieldCommon(double tickerPrice, double lastDividend);

	/**
	 * Calculate de dividend yield of a given Preferred stock - ticker price,
	 * par value and fixed dividend
	 *
	 * @param tickerPrice
	 * @param parValue
	 * @param fixedDividend
	 * @return stock dividend yield
	 */
	double calculateDividendYieldPreferred(double tickerPrice, double parValue, double fixedDividend);

	/**
	 * Calculates the P/E Ratio for a given stock ticker price and dividend
	 *
	 * @param lastDividend
	 * @param tickerPrice
	 * @return stock P/E ratio
	 */
	double calculatePERatio(double tickerPrice, double lastDividend);

	/**
	 * Calculates the Geometric Mean for a given list of trade prices
	 *
	 * @param tradePrices
	 * @return the Geometric Mean
	 */
	double calculateGeometricMean(double... tradePrices);

	/**
	 * Calculates the stock price for a given list of trade prices and
	 * quantities
	 *
	 * @param tradePrice
	 * @param tradeQuantity
	 * @return the stock price
	 * @throws StockCalculatorException
	 */
	double calculateStockPrice(double[] tradePrice, double[] tradeQuantity) throws StockCalculatorException;
}