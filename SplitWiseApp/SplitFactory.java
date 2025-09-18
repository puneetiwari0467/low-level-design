package com.walmart.practice.webApplication.SplitWiseApp;

public class SplitFactory {
	
	SplitValidator getSplitValidator(SplitType splitType) {
		
		switch(splitType) {
			case EQUAL:
				return new EqualSplitValidator();
			case UNEQUAL:
				return new UnEqualSplitValidator();
			case PERCENTAGE:
				return new PercentageSplitValidator();
			default:
				return new EqualSplitValidator();		
		}
	}
	
}
