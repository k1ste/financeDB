package de.hsb.financeDB.model;

import java.util.ArrayList;

public class Ticker {
	private String symbol;
	private String description;
	private ArrayList<Stockvalue> values;

	public Ticker() {

	}

	public Ticker(String symbol, String description, ArrayList<Stockvalue> values) {
		super();
		this.symbol = symbol;
		this.description = description;
		this.values = new ArrayList<Stockvalue>();
	}

	public String getDescription() {
		return description;
	}

	public String getSymbol() {
		return symbol;
	}

	public ArrayList<Stockvalue> getValues() {
		return values;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setValues(ArrayList<Stockvalue> values) {
		this.values = values;
	}
}
