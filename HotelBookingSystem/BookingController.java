package com.walmart.practice.webApplication.HotelBookingSystem;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingController {
	
	HotelController hotelController;
	PaymentService paymentService;
	BookingDetail bookingDetail;
	
	BookingController(){
		this.hotelController=new HotelController();
		this.paymentService=new PaymentService();
	}
	
	public BookingDetail createBooking(Integer userId,Hotel interestedHotel, List<Room> interestedRooms) throws Exception {
		bookingDetail=new BookingDetail();
		bookingDetail.setBookingId(UUID.randomUUID().toString());
		bookingDetail.setHotelId(interestedHotel.getId());
		bookingDetail.setRoomId(interestedRooms);
		bookingDetail.setUserId(userId);
		boolean available=hotelController.reserveRooms(interestedHotel,interestedRooms);
		if(!available) {
			bookingDetail.setBookingStatus(BookingStatus.FAILED);
			throw new Exception("Already booked");
		}
		boolean paid=paymentService.processPayment();
		if(paid) {
			hotelController.confirmRooms(interestedHotel,interestedRooms);	
			bookingDetail.setBookingStatus(BookingStatus.CONFIRMED);
		}else {
			hotelController.releaseRooms(interestedHotel,interestedRooms);
			bookingDetail.setBookingStatus(BookingStatus.FAILED);
			throw new Exception("Already booked");
		}
		return bookingDetail;
	}
}
