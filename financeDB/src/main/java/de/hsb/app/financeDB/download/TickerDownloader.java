package de.hsb.app.financeDB.download;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import db.hsb.financeDB.controller.DownloadController;
import de.hsb.financeDB.model.Ticker;

public class TickerDownloader extends DownloadController {
	
	private ArrayList<Ticker> tickerList = new ArrayList<Ticker>();
	private ArrayList<String> exchanges = new ArrayList<String>();
	private String URL = "https://www.nasdaq.com/screening/companies-by-industry.aspx?exchange=";
	private String URLEnd = "&render=download";
	
	public TickerDownloader() {
		exchanges.add("NASDAQ");
		exchanges.add("NYSE");
		exchanges.add("AMEX");
		downloadAll();
	}

	public void downloadAll() {
		for (String string : exchanges) {
			try {
				downloadURL(URL + string + URLEnd, string, "csv");
				csvFormatter(new File(string + ".csv"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void csvFormatter(File f) throws IOException{
		LineIterator it = FileUtils.lineIterator(f, "UTF-8");
		 try {
			   Reader in = new FileReader(f);
			   Iterable<CSVRecord> records = CSVFormat.EXCEL.withHeader("Symbol", "Name").parse(in);
			   for(CSVRecord record : records) {
				   String symbol = record.get("Symbol");
				   String description = record.get("Name");
				   tickerList.add(createTicker(symbol, description));
			   }
		 } finally {
			 ListToCSV(tickerList);
			 it.close();
		 }
	}
	public Ticker createTicker(String s, String d) {
		Ticker t = new Ticker(s,d);
		return t;
	}
	public void ListToCSV(ArrayList<Ticker> toDo) {
		PrintWriter printWriter = null;
		File f = new File("Ticker.txt");
		try {
			printWriter = new PrintWriter(new FileWriter(f));
			for (Ticker tick : toDo) {
				printWriter.print(tick.getSymbol());
				printWriter.print(", ");
				printWriter.print(tick.getDescription());
				printWriter.println();
				
			}
			printWriter.close();
		} catch (IOException e) {
			System.out.println("Fehler bei: " + toDo.toString());
			e.printStackTrace();
		}

	}
}
