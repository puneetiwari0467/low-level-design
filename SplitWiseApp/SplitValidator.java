package com.walmart.practice.webApplication.SplitWiseApp;

import java.util.List;

public interface SplitValidator {
	
	boolean  validateRequest(List<Split>splits,double amount);
}
