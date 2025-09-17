package com.walmart.practice.webApplication.ElevatorDesign;

import java.util.List;

public class InternalButtonDispatcher {
	List<ElevatorController> elevatorControllers;
	
	public InternalButtonDispatcher(List<ElevatorController> elevatorControllers) {
		this.elevatorControllers=elevatorControllers;
	}

	public void submitInternalRequest(Integer liftId, Integer floor) {
		
		for(ElevatorController ec:elevatorControllers) {
			if(ec.getElevator().getLiftId().equals(liftId)) {
				Direction direction;
				if (ec.getElevator().currentFloor>floor) {
					direction=Direction.DOWN;
				}else {
					direction=Direction.UP;
				}
				ec.submitInternalRequest(floor, direction);
				break;
			}
		}
	}
}
