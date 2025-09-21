package com.walmart.practice.webApplication.MovieBookingSystem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat {
	Integer seatId;
	Integer price;
	Integer row;
	SeatCategory seatCategory;
}
