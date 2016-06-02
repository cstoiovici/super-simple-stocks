package com.jpmorgan.beans;

import java.util.Date;

import com.jpmorgan.util.TradeOperationEnum;

/**
 * Class representing a trade
 *
 * @author Catalin Stoiovici
 */
public class Trade {

	private Stock stock;

	private Date timestamp;

	private Double shareQuantity;

	private TradeOperationEnum buyOrSellIndicator;

	private Double price;

	public Trade(Stock stock, Date timestamp, Double sharesQuantity, TradeOperationEnum buyOrSellIndicator,
			Double price) {

		this.stock = stock;
		this.timestamp = timestamp;
		this.shareQuantity = sharesQuantity;
		this.buyOrSellIndicator = buyOrSellIndicator;
		this.price = price;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Double getShareQuantity() {
		return shareQuantity;
	}

	public void setShareQuantity(Double shareQuantity) {
		this.shareQuantity = shareQuantity;
	}

	public TradeOperationEnum getBuyOrSellIndicator() {
		return buyOrSellIndicator;
	}

	public void setBuyOrSellIndicator(TradeOperationEnum buyOrSellIndicator) {
		this.buyOrSellIndicator = buyOrSellIndicator;
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
		result = prime * result + ((buyOrSellIndicator == null) ? 0 : buyOrSellIndicator.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((shareQuantity == null) ? 0 : shareQuantity.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
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
		Trade other = (Trade) obj;
		if (buyOrSellIndicator != other.buyOrSellIndicator)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shareQuantity == null) {
			if (other.shareQuantity != null)
				return false;
		} else if (!shareQuantity.equals(other.shareQuantity))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Trade [stock=" + stock + ", timestamp=" + timestamp + ", shareQuantity=" + shareQuantity
				+ ", buyOrSellIndicator=" + buyOrSellIndicator + ", price=" + price + "]";
	}

}
