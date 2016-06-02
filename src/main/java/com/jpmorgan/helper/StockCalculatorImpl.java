package com.jpmorgan.helper;

import com.jpmorgan.exception.StockCalculatorException;

/**
 * Stocks calculator
 *
 * @author Catalin Stoiovici
 */
public class StockCalculatorImpl implements StockCalculator {

	public double calculateDividendYieldCommon(double tickerPrice, double lastDividend) {

		return lastDividend / tickerPrice;
	}

	public double calculateDividendYieldPreferred(double tickerPrice, double parValue, double fixedDividend) {

		return (fixedDividend * parValue) / tickerPrice;
	}

	public double calculatePERatio(double tickerPrice, double lastDividend) {

		return tickerPrice / lastDividend;
	}

	public double calculateGeometricMean(double... tradePrices) {

		if (tradePrices == null || (tradePrices != null && tradePrices.length == 0)) {
			return 0d;
		}

		double geometricMean = tradePrices[0];

		for (int index = 1; index < tradePrices.length; index++) {
			geometricMean *= tradePrices[index];
		}

		Integer n = new Integer(tradePrices.length);

		return Math.pow(geometricMean, 1.0d / n.doubleValue());
	}

	public double calculateStockPrice(double[] tradePrice, double[] tradeQuantity) throws StockCalculatorException {

		if (tradePrice == null || (tradePrice != null && tradePrice.length == 0)) {
			return 0d;
		}

		if (tradeQuantity == null) {
			throw new StockCalculatorException("tradeQuantity is null!");
		}

		if (tradePrice.length != tradeQuantity.length) {
			throw new StockCalculatorException("tradePrice and tradeQuantity don't have the same length!");
		}

		double pricesPerQuantities = 0d;
		double quantities = 0d;

		for (int index = 1; index < tradePrice.length; index++) {
			pricesPerQuantities += tradePrice[index] * tradeQuantity[index];
			quantities += tradeQuantity[index];
		}

		return pricesPerQuantities / quantities;
	}
}
