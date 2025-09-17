package com.walmart.practice.webApplication.ElevatorDesign;

public class InternalButton {
	
	InternalButtonDispatcher internalButtonDispatcher;
	
	public InternalButton(InternalButtonDispatcher internalButtonDispatcher) {
		this.internalButtonDispatcher=internalButtonDispatcher;
	}
	
	public void pressButton(Integer liftId,Integer floor){
		internalButtonDispatcher.submitInternalRequest(liftId, floor);
	}
}
