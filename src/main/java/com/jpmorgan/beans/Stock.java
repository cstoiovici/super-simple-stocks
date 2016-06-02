package com.jpmorgan.beans;

import com.jpmorgan.util.StockTypeEnum;

/**
 * Class representing a stock
 *
 * @author Catalin Stoiovici
 */
public class Stock {

	private String stockSymbol;

	private StockTypeEnum stockType;

	private Double lastDividend;

	private Double fixedDividend;

	private Double parValue;

	private Double price;
	
	public Stock(String stockSymbol, StockTypeEnum stockType, Double lastDividend, Double fixedDividend,
			Double parValue, Double price) {

		this.stockSymbol = stockSymbol;
		this.stockType = stockType;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.price = price;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public StockTypeEnum getStockType() {
		return stockType;
	}

	public void setStockType(StockTypeEnum stockType) {
		this.stockType = stockType;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fixedDividend == null) ? 0 : fixedDividend.hashCode());
		result = prime * result + ((lastDividend == null) ? 0 : lastDividend.hashCode());
		result = prime * result + ((parValue == null) ? 0 : parValue.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((stockSymbol == null) ? 0 : stockSymbol.hashCode());
		result = prime * result + ((stockType == null) ? 0 : stockType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (fixedDividend == null) {
			if (other.fixedDividend != null)
				return false;
		} else if (!fixedDividend.equals(other.fixedDividend))
			return false;
		if (lastDividend == null) {
			if (other.lastDividend != null)
				return false;
		} else if (!lastDividend.equals(other.lastDividend))
			return false;
		if (parValue == null) {
			if (other.parValue != null)
				return false;
		} else if (!parValue.equals(other.parValue))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (stockSymbol == null) {
			if (other.stockSymbol != null)
				return false;
		} else if (!stockSymbol.equals(other.stockSymbol))
			return false;
		if (stockType != other.stockType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stock [stockSymbol=" + stockSymbol + ", stockType=" + stockType + ", lastDividend=" + lastDividend
				+ ", fixedDividend=" + fixedDividend + ", parValue=" + parValue + ", price=" + price + "]";
	}

}
