package com.jpmorgan.service;

import java.util.List;

import com.jpmorgan.beans.Stock;
import com.jpmorgan.beans.Trade;
import com.jpmorgan.exception.StockCalculatorException;

/**
 * Interface of stock calculation services
 *
 * @author Catalin Stoiovici
 */
public interface StockCalculatorService {

	/**
	 * Calculate stock price for a given list of trades
	 *
	 * @param trades
	 *            the list of trades
	 * @throws StockCalculatorException
	 */
	double calculateStockPrice(List<Trade> trades) throws StockCalculatorException;

	/**
	 * Calculate all shares indexes for a given list of stocks.
	 *
	 * @param stocks
	 *            the list of stocks
	 */
	double calculateShareIndexes(List<Stock> stocks);
}
