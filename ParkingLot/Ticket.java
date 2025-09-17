package com.walmart.practice.webApplication.ParkingLot;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	Vehicle vehicle;
	ParkingFloor parkingFloor;
	LocalDateTime entryTime;
	
}
