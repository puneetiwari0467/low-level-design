package com.walmart.practice.webApplication.MovieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
	Map<City,List<Theatre>>cityVsTheatre;
	List<Theatre>allTheatre;
	
	TheatreController(){
		this.cityVsTheatre=new HashMap<>();
		this.allTheatre=new ArrayList<>();
	}
	
	public void addTheatres(Theatre theatre,City city) {
		List<Theatre>theatres=cityVsTheatre.getOrDefault(city,new ArrayList<>());
		theatres.add(theatre);
		cityVsTheatre.put(city,theatres);
		allTheatre.add(theatre);
	}
	
	public Map<Theatre, List<Show>> getAllShows(Movie movie,City city){
		 List<Theatre> theatres=cityVsTheatre.get(city);
		 //get theatres which run this movie
		 Map<Theatre,List<Show>> selectedTheatresVsShow=new HashMap<>();
		 
		 for(Theatre theatre:theatres ) {
			 List<Show>showsOfMovie=new ArrayList<>();
			 for(Show show:theatre.getShows()) {
				 if(show.getMovie().equals(movie)) {
					 //which means this theatre must be present in result
					 showsOfMovie.add(show);
				 }
			 }
			 if(showsOfMovie.size()>0)
			 selectedTheatresVsShow.put(theatre,showsOfMovie);
		 }
		 return selectedTheatresVsShow;
	}
}
