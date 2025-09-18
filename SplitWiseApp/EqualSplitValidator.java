package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.List;

public class EqualSplitValidator implements SplitValidator{

	@Override
	public boolean validateRequest(List<Split> splits, double amount) {
		Double sum=0d;
		for(Split split:splits) {
			sum+=split.getAmount();
		}
		return sum==amount;
	}

}
