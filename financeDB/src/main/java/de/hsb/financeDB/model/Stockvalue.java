package de.hsb.financeDB.model;

public class Stockvalue {
	String date;
	double open;
	double high;
	double low;
	double close;
	double volume;

	public Stockvalue(String date, double open, double high, double low, double close, double volume) {
		super();
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	public double getClose() {
		return close;
	}

	public String getDate() {
		return date;
	}

	public double getHigh() {
		return high;
	}

	public double getLow() {
		return low;
	}

	public double getOpen() {
		return open;
	}

	public double getVolume() {
		return volume;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public String toString() {
		return date + "," + open + "," + high + "," + low + "," + close + "," + volume;
	}
}
