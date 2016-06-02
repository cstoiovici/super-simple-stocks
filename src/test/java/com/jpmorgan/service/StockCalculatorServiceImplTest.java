package com.jpmorgan.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.jpmorgan.beans.Stock;
import com.jpmorgan.beans.Trade;
import com.jpmorgan.exception.StockCalculatorException;
import com.jpmorgan.util.StockTypeEnum;
import com.jpmorgan.util.TradeOperationEnum;

/**
 * Test class for StockCalculatorServiceImpl
 *
 * @author Catalin Stoiovici
 */
public class StockCalculatorServiceImplTest {

	private StockCalculatorService stockCalculatorService = new StockCalculatorServiceImpl();

	@Test
	public void testCalculateStockPrice() throws StockCalculatorException {

		Stock tea = new Stock("TEA", StockTypeEnum.COMMON, 0d, null, 100d, 110d);

		Trade trade1 = new Trade(tea, new Date(), 1436d, TradeOperationEnum.BUY, 2353d);
		Trade trade2 = new Trade(tea, new Date(), 3355d, TradeOperationEnum.SELL, 346d);

		List<Trade> trades = Arrays.asList(trade1, trade2);

		assertEquals(346.0, stockCalculatorService.calculateStockPrice(trades), 0d);
	}

	@Test
	public void testCalculateShareIndex() {

		Stock tea = new Stock("TEA", StockTypeEnum.COMMON, 0d, null, 100d, 346d);
		Stock pop = new Stock("POP", StockTypeEnum.COMMON, 8d, null, 100d, 634d);
		Stock ale = new Stock("ALE", StockTypeEnum.COMMON, 23d, null, 60d, 436d);
		Stock gin = new Stock("GIN", StockTypeEnum.PREFERRED, 8d, 2d, 100d, 4363d);
		Stock joe = new Stock("JOE", StockTypeEnum.COMMON, 13d, null, 250d, 3463d);

		List<Stock> stocks = Arrays.asList(tea, pop, ale, gin, joe);

		assertEquals(1.7646073144599947d, stockCalculatorService.calculateShareIndexes(stocks), 0d);
	}
}
