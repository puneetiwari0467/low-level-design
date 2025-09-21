package com.walmart.practice.webApplication.HotelBookingSystem;

public enum BookingStatus {
	PENDING,    // seats reserved, payment not yet confirmed
    CONFIRMED,  // payment success, seats booked
    FAILED,     // payment failed or seats unavailable
    CANCELLED ;  // user cancelled
}
