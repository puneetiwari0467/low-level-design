package com.walmart.practice.webApplication.SplitWiseApp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Balance {
	Double owes;
	Double getBack;
	public Balance() {
		this.owes=0.0;
		this.getBack=0.0;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Owes="+owes+" getBack="+getBack;
	}
}
