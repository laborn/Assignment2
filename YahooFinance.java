package statistics;

import java.net.MalformedURLException;
import java.net.URL;

public class YahooFinance implements WebDataSource{
	
	String symbol;
	String statistics;
	URL url;

	public YahooFinance(String symbol, String statistics) {
		this.symbol = symbol;
		this.statistics = statistics;
	}
	
	public URL getURL(String symbol, String statistics){
		
		this.symbol = symbol;
		this.statistics = statistics;
		URL urlYahoo = null;
		try {
			urlYahoo = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=" + statistics);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return urlYahoo;
	}
}
