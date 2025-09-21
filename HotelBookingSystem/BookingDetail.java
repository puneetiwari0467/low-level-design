package com.walmart.practice.webApplication.HotelBookingSystem;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookingDetail {
	String bookingId;
	Integer userId;
	Integer hotelId;
	List<Room> roomId;
	LocalDate dateFrom;
	LocalDate dateTill;
	BookingStatus bookingStatus;
	
}
