package com.walmart.practice.webApplication.ElevatorDesign;

public class ExternalButton {
	
	ExternalButtonDispatcher externalButtonDispatcher;
	
	public ExternalButton(ExternalButtonDispatcher externalButtonDispatcher) {
		this.externalButtonDispatcher=externalButtonDispatcher;
	}
	
	public void pressButton(Integer Floor,Direction direction){
		
		externalButtonDispatcher.submitExternalRequest(Floor, direction);
	}

}
