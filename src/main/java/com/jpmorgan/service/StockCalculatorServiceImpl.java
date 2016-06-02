package com.jpmorgan.service;

import java.util.List;

import com.jpmorgan.beans.Stock;
import com.jpmorgan.beans.Trade;
import com.jpmorgan.exception.StockCalculatorException;
import com.jpmorgan.helper.StockCalculator;
import com.jpmorgan.helper.StockCalculatorImpl;

/**
 * Stock calculation service
 *
 * @author Catalin Stoiovici
 */
public class StockCalculatorServiceImpl implements StockCalculatorService {

	private StockCalculator stockCalculatorHelper = new StockCalculatorImpl();

	public double calculateStockPrice(List<Trade> trades) throws StockCalculatorException {
		if (trades == null) {

			return 0d;
		}

		double[] tradesPrices = new double[trades.size()];
		double[] tradesQuantities = new double[trades.size()];

		int index = 0;
		for (Trade trade : trades) {
			tradesPrices[index] = trade.getPrice();
			tradesQuantities[index] = trade.getShareQuantity();
			index++;
		}

		return stockCalculatorHelper.calculateStockPrice(tradesPrices, tradesQuantities);
	}

	public double calculateShareIndexes(List<Stock> stocks) {
		double[] tradesPrices = new double[stocks.size()];
		double totalParValues = 0d;

		int index = 0;
		for (Stock stock : stocks) {
			totalParValues += stock.getParValue();
			tradesPrices[index] = stock.getPrice();
			index++;
		}

		double geometricMean = stockCalculatorHelper.calculateGeometricMean(tradesPrices);

		return geometricMean / totalParValues;
	}

	public double calculateGeometricMean(List<Stock> stocks) {

		double[] tradesPrices = new double[stocks.size()];

		double totalParValues = 0d;

		int index = 0;
		for (Stock stock : stocks) {
			totalParValues += stock.getParValue();
			tradesPrices[index] = stock.getPrice();
			index++;
		}

		double geometricMean = stockCalculatorHelper.calculateGeometricMean(tradesPrices);

		return geometricMean / totalParValues;
	}
}