package com.training.movie;

import java.util.ArrayList;
import java.util.List;

public class MovieMockedData {

	private List<Movie> movies;

//    for singleton design pattern
	private static MovieMockedData instance = null;

	public static MovieMockedData getInstance() {
		if (instance == null) {
			instance = new MovieMockedData();
		}
		return instance;
	}

	public MovieMockedData() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "Cloud Atlas", "An exploration of how the actions of individual lives impact one "
				+ "another in the past, present and future"));
		movies.add(new Movie(2, "Equilibrium", "In an oppressive future where all forms of feeling are illegal, a man "
				+ "in charge of enforcing the law rises to overthrow the system and state."));
		movies.add(
				new Movie(3, "Mr. Nobody", "A boy stands on a station platform as a train is about to leave. Should he "
						+ "go with his mother or stay with his father? Infinite possibilities arise from this decision."));
		movies.add(
				new Movie(4, " The Lobster", "In a dystopian near future, single people, according to the laws of The "
						+ "City, are taken to The Hotel,"));
		movies.add(new Movie(5, " The Fountain",
				"As a modern-day scientist, Tommy is struggling with mortality, desperately "
						+ "searching for the medical breakthrough that will save the life of his cancer-stricken wife,"));
		movies.add(new Movie(6, " Donnie Darko",
				"A troubled teenager is plagued by visions of a man in a large rabbit suit who "
						+ "manipulates him to commit a series of crimes, after he narrowly escapes a bizarre accident."));

	}

	// return all movies
	public List<Movie> fetchMovies() {
		return movies;
	}

	// return blog by id
	public Movie getMovieById(int id) {
		for (Movie m : movies) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	// search movie by text
	public List<Movie> searchMovies(String movieName){

        List<Movie> searchedMovies = new ArrayList<Movie>();
        for(Movie m: movies) {
            if(m.getTitle().toLowerCase().contains(movieName.toLowerCase())){
                searchedMovies.add(m);
            }	
	}
        return searchedMovies;
}
	
    // create movie
    public Movie createMovie(int id, String title, String content) {
        Movie newMovie = new Movie(id, title, content);
        movies.add(newMovie);
        return newMovie;
    }
    
// update the movie
    public Movie updateMovie(int id, String title, String content) {
		for(Movie m: movies) {
			if(m.getId()==id) {
				int index=movies.indexOf(m);
				m.setTitle(title);
				m.setContent(content);
				movies.set(index, m);
				return m;
				
			}
		}
    	
    	return null;
    	
    }
	
    // delete movie by id
    public boolean delete(int id){
        int movieIndex = -1;
        for(Movie m: movies) {
            if(m.getId() == id) {
                movieIndex = movies.indexOf(m);
                continue;
            }
        }
        if(movieIndex > -1){
            movies.remove(movieIndex);
        }
        return true;
    }
	
}
