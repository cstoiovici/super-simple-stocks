package com.jpmorgan.exception;

/**
 * Class used to throw exceptions
 */
public class StockCalculatorException extends Exception {

	static final long serialVersionUID = 436435743L;

	public StockCalculatorException(String message) {
		super(message);
	}

}
