package com.walmart.practice.webApplication.HotelBookingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelController {
	Map<City,List<Hotel>>cityVsHotels;
	List<Hotel>allHotels;
	
	HotelController(){
		allHotels = new ArrayList<>();
		cityVsHotels = new HashMap<>();
	}
	public void addHotel(City city,Hotel hotel) {
		List<Hotel>hotels=cityVsHotels.getOrDefault(city,new ArrayList<>());
		hotels.add(hotel);
		cityVsHotels.put(city,hotels);
		allHotels.add(hotel);
		
	}
	
	public List<Hotel> getAllHotels(City city,LocalDate startFrom) {
		return cityVsHotels.get(city);
	}
	
	public List<Room> getAllRooms(Hotel hotel,City city){
		for(Hotel hotela:cityVsHotels.get(city)) {
			if(hotela.equals(hotel)) {
				return hotela.getRooms();
			}
		}
		return null;
	}
	
	public boolean  reserveRooms(Hotel interestedHotel, List<Room> interestedRooms) {
		interestedRooms.sort(Comparator.comparing(Room::getId));
		 // Step 1: Lock all rooms and check availability
	    for (Room room : interestedRooms) {
	        synchronized (room) {
	            if (!room.getStatus().equals(Status.AVAILABLE)) {
	                return false; // exit without changing any status
	            }
	        }
	    }

	    // Step 2: Reserve all rooms
	    for (Room room : interestedRooms) {
	        synchronized (room) {
	            room.setStatus(Status.RESERVED);
	        }
	    }

	    return true;
	}
	
	public synchronized void confirmRooms(Hotel interestedHotel,List<Room>interestedRooms) {
		for(Room room:interestedRooms) {
			synchronized (room) {
                room.setStatus(Status.BOOKED);
            }
		}
	}
	
	public synchronized void releaseRooms(Hotel interestedHotel, List<Room> interestedRooms ) {
		for(Room room:interestedRooms) {
			synchronized (room) {
                room.setStatus(Status.AVAILABLE);
            }
		}
	}
}
