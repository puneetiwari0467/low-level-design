package com.walmart.practice.webApplication.MovieBookingSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BookMyShow {
	
	MovieController movieController;
	static TheatreController theatreController;
	
	public BookMyShow() {
		this.movieController=new MovieController();
		this.theatreController=new TheatreController();
		initialize();
	
	}
	public static void main(String[]args) throws Exception {
		
		BookMyShow bookMyShow=new BookMyShow();
		
		//user1
        bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
        //user2
        //bookMyShow.createBooking(City.BANGALORE, "BAAHUBALI");
		
	}
	
	void createBooking(City city,String movieName) throws Exception{
		
		//1.show user movies based on his city
		List<Movie> movies=movieController.getMoviesByCity(city);
		
		//2.user selects movie interested in 
		Movie interestedMovie=null;
		for(Movie movie:movies) {
			if(movie.getName().equals(movieName)) {
				interestedMovie=movie;
				break;
			}
		}
		
		//3. get all show of this movie in Bangalore location
		Map<Theatre, List<Show>>theatres=theatreController.getAllShows(interestedMovie,city);
		
		//4.user selects show of a particular theatre
        Map.Entry<Theatre,List<Show>> entry = theatres.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

		
		//5.user selects seats for that show and create Booking 
		List<Integer> interestedSeatIds = Arrays.asList(23, 24);
		
		
		synchronized (interestedShow) {
			// check availability
			boolean alreadyBooked=false;
			for(Integer seatId:interestedSeatIds) {
				if(interestedShow.getBookedSeatIds().contains(seatId)) {
					alreadyBooked=true;
					break;
				}
			}
			if(!alreadyBooked) {
				// mark seats as booked
				interestedShow.getMutableBookedSeatIds().addAll(interestedSeatIds);
				List<Seat> interestedSeats = new ArrayList<>();

				for (Seat seat : interestedShow.getScreen().getSeats()) {
				    if (interestedSeatIds.contains(seat.getSeatId())) {
				        interestedSeats.add(seat);
				    }
				}
				// create Booking object
				Booking booking =new Booking();
				booking.setSeats(interestedSeats);
				booking.setShow(interestedShow);
				PaymentService paymentService=new PaymentService();
				paymentService.makePayment(23);
			}else {
				throw new Exception("Booking failed Try again");
			}
		}
	}
	
	
   private void initialize() {

        //create movies
        createMovies();

        //create theater with screens, seats and shows
        createTheatre();
    }

    //creating 2 theatre
    private void createTheatre() {

        Movie avengerMovie = movieController.getMovieByName("AVENGERS");
        Movie baahubali = movieController.getMovieByName("BAAHUBALI");

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(1);
        inoxTheatre.setScreens(createScreen());
        inoxTheatre.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inoxTheatre.getScreens().get(0), avengerMovie, 8);
        Show inoxEveningShow = createShows(2, inoxTheatre.getScreens().get(0), baahubali, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inoxTheatre.setShows(inoxShows);


        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(2);
        pvrTheatre.setScreens(createScreen());
        pvrTheatre.setCity(City.DELHI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvrTheatre.getScreens().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvrTheatre.getScreens().get(0), baahubali, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatres(inoxTheatre, City.BANGALORE);
        theatreController.addTheatres(pvrTheatre, City.DELHI);

    }

    private List<Screen> createScreen() {

        List<Screen> screens = new ArrayList<>();
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    private Show createShows(int showId, Screen screen, Movie movie, int showStartTime) {

        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(showStartTime); //24 hrs time ex: 14 means 2pm and 8 means 8AM
        return show;
    }

    //creating 100 seats
    private List<Seat> createSeats() {

        //creating 100 seats for testing purpose, this can be generalised
        List<Seat> seats = new ArrayList<>();

        //1 to 40 : SILVER
        for (int i = 0; i < 40; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seats.add(seat);
        }

        //41 to 70 : SILVER
        for (int i = 40; i < 70; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        //1 to 40 : SILVER
        for (int i = 70; i < 100; i++) {
            Seat seat = new Seat();
            seat.setSeatId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seats.add(seat);
        }

        return seats;
    }

    private void createMovies() {

        //create Movies1
        Movie avengers = new Movie();
        avengers.setId(1);
        avengers.setName("AVENGERS");
        avengers.setDuration(128);

        //create Movies2
        Movie baahubali = new Movie();
        baahubali.setId(2);
        baahubali.setName("BAAHUBALI");
        baahubali.setDuration(180);


        //add movies against the cities
        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(avengers, City.DELHI);
        movieController.addMovie(baahubali, City.BANGALORE);
        movieController.addMovie(baahubali, City.DELHI);
    }

}
