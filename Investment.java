package investment;

import statistics.WebDataSource;

public abstract class Investment {
	
	//Instance variables:
	private WebDataSource datasource;
	private String symbol;
	
	public Investment(WebDataSource newDataSource) {
		datasource = newDataSource;
	}

	public void printStats(WebDataSource datasource){
		System.out.println(datasource);
	}
}
