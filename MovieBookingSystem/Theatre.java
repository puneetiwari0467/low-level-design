package com.walmart.practice.webApplication.MovieBookingSystem;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Theatre {
	
	Integer theatreId;
	String address;
	List<Screen>screens;
	List<Show>shows;
	City city;
	
	
	
}
