package investment;

import statistics.WebDataSource;

public class Stock extends Investment {
	
	public Stock(WebDataSource newDataSource) {
		super(newDataSource);
	}

	public void printStats(){
		System.out.println("This is the stocks printout");
	}
}
