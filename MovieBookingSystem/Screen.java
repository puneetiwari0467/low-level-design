package com.walmart.practice.webApplication.MovieBookingSystem;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Screen {
	Integer screenId;
	List<Seat>seats;
}
