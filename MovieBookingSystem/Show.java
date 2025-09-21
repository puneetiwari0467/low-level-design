package com.walmart.practice.webApplication.MovieBookingSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Show {
	private Integer showId;
	private Movie movie;
	private Screen screen;
	private Integer startTime;
    private  List<Integer> bookedSeatIds = new ArrayList();
	
    public List<Integer> getBookedSeatIds() {
        return Collections.unmodifiableList(bookedSeatIds);
    }
    
    List<Integer> getMutableBookedSeatIds() {
        return bookedSeatIds;
    }
}
