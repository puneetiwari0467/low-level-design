package com.walmart.practice.webApplication.HotelBookingSystem;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class HotelBookingSystem {
	UserController userController;
	HotelController hotelController;
	BookingController bookingController;
	
	public HotelBookingSystem() {
		this.userController=new UserController();
		this.hotelController=new HotelController();
		initialize();
		this.bookingController=new BookingController();
		bookingController.setHotelController(hotelController);
	}
	
	public static void main(String[]args) throws Exception {
			
		HotelBookingSystem hotelBookingSystem=new HotelBookingSystem();
			
		//user1
		hotelBookingSystem.createBooking(City.BANGALORE, LocalDate.now());
        //user2
		hotelBookingSystem.createBooking(City.BANGALORE, LocalDate.now());
		
	}
	
	void createBooking(City city,LocalDate date){
		
		//1. search a hotel based on date and location 
		List<Hotel>hotels=hotelController.getAllHotels(city, date);
		
		//2.Select a paticular hotel from list of interest
		String interestedHotel="novotel";
		Hotel hotel=null;
		for(Hotel x:hotels) {
			if(x.getName().equals(interestedHotel)) {
				hotel=x;break;
			}
		}
		List<Room>rooms=hotelController.getAllRooms(hotel, city);
		
		//3.user selects particular room
		List<Room> interestedRooms=Arrays.asList( rooms.get(0),rooms.get(1));
		
		//4.create booking for this room and make payment
		try {
			bookingController.createBooking(userController.getUsers().get(0).getId(), hotel,interestedRooms);
		}catch(Exception ex) {
			System.out.println("Error: "+ex.getMessage());
		}
		
		//5.notification to user 
	}
	
	void initialize(){
		createUsers();
		
		createHotels();
	}
	
	public void createUsers() {
		User user1=new User("puneet","gmail.com");
		User user2=new User("tricker","gmail.com");
		User user3=new User("tommy","gmail.com");
		User user4=new User("vrishi","gmail.com");
		
		userController.addUser(user1);
		userController.addUser(user2);
		userController.addUser(user3);
		userController.addUser(user4);

	}
	
	public void createHotels() {
		Room room1=new Room(RoomType.AC,500d,Status.AVAILABLE);
		Room room2=new Room(RoomType.DELUX,5000d,Status.AVAILABLE);
		
		Hotel hotel1=new Hotel("raddison blue",new Address("Karnataka"),Arrays.asList(room1,room2));
		Hotel hotel2=new Hotel("kfc",new Address("Rajasthan"),Arrays.asList(room1,room2));
		Hotel hotel3=new Hotel("oyo rooms",new Address("Tamil Nadu"),Arrays.asList(room1,room2));
		Hotel hotel4=new Hotel("novotel",new Address("Uttar Pradesh"),Arrays.asList(room1,room2));
		
		hotelController.addHotel(City.BANGALORE, hotel1);
		hotelController.addHotel(City.DELHI, hotel2);
		hotelController.addHotel(City.DELHI, hotel3);
		hotelController.addHotel(City.BANGALORE, hotel4);
		
	}
}
