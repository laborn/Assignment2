package investment;

import statistics.WebDataSource;

public class MutualFund extends Investment {
	
	public MutualFund(WebDataSource newDataSource) {
		super(newDataSource);
	}

	public void printStats(){
		System.out.println("This is the mutual funds printout");
	}
}
