package com.walmart.practice.webApplication.MovieBookingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
	Map<City,List<Movie>>cityVsMovies;
	List<Movie>allMovies;
	
	MovieController(){
		cityVsMovies=new HashMap<>();
		allMovies=new ArrayList<>();
	}
	
	public void addMovie(Movie avengers, City bangalore) {
		List<Movie>movies=cityVsMovies.getOrDefault(bangalore,new ArrayList<>());
		movies.add(avengers);
		cityVsMovies.put(bangalore,movies);
		allMovies.add(avengers);
	}
	
	public Movie getMovieByName(String name) {
		for(Movie movie:allMovies) {
			if(movie.getName().equals(name)) {
				return movie;
			}
		}
		return null;

	}
	
	public List<Movie> getMoviesByCity(City city) {
		
		return cityVsMovies.get(city);
	}
}
