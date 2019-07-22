package com.training.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.movie.Movie;
import com.training.movie.MovieMockedData;

@RestController
public class MovieController {

	MovieMockedData movieMockedData = MovieMockedData.getInstance();

	@GetMapping("/movie")
	public List<Movie> index() {
		return movieMockedData.fetchMovies();
	}

	@GetMapping("/movie/{id}")
	public Movie show(@PathVariable String id) {
		int movieId = Integer.parseInt(id);
		return movieMockedData.getMovieById(movieId);
	}

	@PostMapping("movie/title={movieName}")
	public List<Movie> searchResults(@PathVariable String movieName) {
		return movieMockedData.searchMovies(movieName);

	}

	@PostMapping("/movie/create")
	public Movie create(@RequestBody Map<String, String> body) {
		int id = Integer.parseInt(body.get("id"));
		String title = body.get("title");
		String content = body.get("content");
		return movieMockedData.createMovie(id, title, content);
	}

	@PutMapping("/movie/update/{id}")
	public Movie update(@PathVariable String id, @RequestBody Map<String, String> body) {
		int blogId = Integer.parseInt(id);
		String title = body.get("title");
		String content = body.get("content");
		return movieMockedData.updateMovie(blogId, title, content);
	}

@DeleteMapping("movie/delete/{id}")
public boolean delete(@PathVariable String id){
    int movieId = Integer.parseInt(id);
    return movieMockedData.delete(movieId);

}

}