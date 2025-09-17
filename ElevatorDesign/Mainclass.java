package com.walmart.practice.webApplication.ElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class Mainclass {
	
	public static void main(String [] args) {
//		List<Floor> floorList = new ArrayList<>();
//        Floor floor1 = new Floor(1);
//        Floor floor2 = new Floor(2);
//        Floor floor3 = new Floor(3);
//        Floor floor4 = new Floor(4);
//        Floor floor5 = new Floor(5);
//        Floor floor6 = new Floor(6);
//        Floor floor7 = new Floor(7);
//        Floor floor8 = new Floor(8);
//        Floor floor9 = new Floor(9);
//        Floor floor10 = new Floor(10);
//        Floor floor11 = new Floor(11);
//        Floor floor12= new Floor(12);
//        Floor floor13 = new Floor(13);
//        Floor floor14 = new Floor(14);
//        Floor floor15 = new Floor(15);
//        floorList.add(floor1);
//        floorList.add(floor2);
//        floorList.add(floor3);
//        floorList.add(floor4);
//        floorList.add(floor5);floorList.add(floor6);
//        floorList.add(floor7);floorList.add(floor8);
//        floorList.add(floor9);floorList.add(floor10);
//        floorList.add(floor11);floorList.add(floor12);
//        floorList.add(floor13);floorList.add(floor14);
        //floorList.add(floor15);

        
        
        Elevator elevator1=new Elevator(1,0,null);

//        Elevator elevator2=new Elevator(2);
//        Elevator elevator3=new Elevator(3);
//        Elevator elevator4=new Elevator(4);
//        Elevator elevator5=new Elevator(5);
        
        
        ElevatorController elevatorController1 = new ElevatorController(elevator1);
        Thread elevatorThread = new Thread(elevatorController1);
        elevatorThread.start();
//        ElevatorController elevatorController2 = new ElevatorController(elevator2);
//        ElevatorController elevatorController3 = new ElevatorController(elevator3);
//        ElevatorController elevatorController4 = new ElevatorController(elevator4);
//        ElevatorController elevatorController5 = new ElevatorController(elevator5);
        
        List<ElevatorController>elevatorControllers=new ArrayList<>();
        elevatorControllers.add(elevatorController1);
//        elevatorControllers.add(elevatorController2);
//        elevatorControllers.add(elevatorController3);
//        elevatorControllers.add(elevatorController4);
//        elevatorControllers.add(elevatorController5);
        
        InternalButtonDispatcher internalButtonDispatcher = new InternalButtonDispatcher(elevatorControllers);
        ExternalButtonDispatcher externalButtonDispatcher = new ExternalButtonDispatcher(elevatorControllers);
        
        ExternalButton externalButton = new ExternalButton(externalButtonDispatcher);
        InternalButton internalButton=new InternalButton(internalButtonDispatcher);        
        
        new Thread(()->{
        	try {
        		Thread.sleep(500);
        		externalButton.pressButton(2, Direction.UP);
        		
        		Thread.sleep(500);
        		internalButton.pressButton(1,5);
                
        		Thread.sleep(500);
        		externalButton.pressButton(10, Direction.DOWN);
        		
        		Thread.sleep(500);
        		externalButton.pressButton(3, Direction.DOWN);
        		
        		 Thread.sleep(500);
        		 internalButton.pressButton(1,6);
        		 
        		 Thread.sleep(500);
        		 internalButton.pressButton(1,8);
        		 
        		 Thread.sleep(500);
        		 internalButton.pressButton(1,2);
        		 
        		 Thread.sleep(500);
        		 internalButton.pressButton(1,3);
        		 
        		 Thread.sleep(500);
        		 internalButton.pressButton(1,4);
        		
        	}catch(InterruptedException ex) {
        		ex.printStackTrace();
        	}
        }).start();
        
        
        
	}

}
