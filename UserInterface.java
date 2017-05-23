package console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Scanner;
import statistics.GoogleFinance;
import statistics.YahooFinance;

public class UserInterface {

	/**
	 *Create a Scanner object for input:
	 */
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
	
		System.out.println("Enter one or more stock or mutual fund symbols separated by commas: ");
		//Get user's choice:
		try {
			String ticker = input.next();
			String symbol = "\"" + ticker + "\"";
			System.out.println("\n" + "Requested the following: " + symbol + "\n");
			String statistics = "snl1t1rr5";
			YahooFinance yf = new YahooFinance(symbol, statistics);
			System.out.println("URL for Yahoo:   " + yf.getURL(symbol, statistics) + "\n");
			URLConnection urlConn = yf.getURL(symbol, statistics).openConnection();
			InputStreamReader inStream = new InputStreamReader(urlConn.getInputStream());
			BufferedReader buffer = new BufferedReader(inStream);
			String line = buffer.readLine();
			while(line != null){
				System.out.println("Yahoo stats (Symbol, Name, Last Trade Price, Time, P/E, PEG: " + line);
				System.out.println();
				line = buffer.readLine();
			}
			GoogleFinance gf = new GoogleFinance(symbol, statistics);
			System.out.println("URL for Google:     " + gf.getURL(symbol, statistics));
		}
		catch(InputMismatchException e) {
			System.out.println("Not investment symbols. Try again.");
		}
	}
}
