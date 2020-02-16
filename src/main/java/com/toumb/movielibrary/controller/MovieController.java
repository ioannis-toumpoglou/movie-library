package com.toumb.movielibrary.controller;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toumb.movielibrary.entity.Movie;
import com.toumb.movielibrary.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

	private MovieService movieService;
	
	public MovieController(MovieService theMovieService) {
		movieService = theMovieService;
	}
	
	@GetMapping("/list")
	public String listMovies(Model model) {
		// Get the movie list from the Service
		List<Movie> movies = movieService.findAll();
		
		// Add the movie list to the model
		model.addAttribute("movies", movies);
		
		return "movies/list-movies";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model model) {
		// Create model attribute to bind form data
		Movie movie = new Movie();
		
		model.addAttribute("movie", movie);
		
		return "movies/movie-form";
	}
	
	@PostMapping("/save")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		// Save the movie using the service
		movieService.save(movie);
		
		return "redirect:/movies/list";
	}
	
	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("movieId") int id, Model model) {
		// Get movie from the service
		Movie movie = movieService.findById(id);
		// Set movie as a model attribute to pre-populate the form
		model.addAttribute("movie", movie);
		// Send to the form		
		return "movies/movie-form";
	}
	
	@GetMapping("/delete")
	public String deleteMovie(@RequestParam("movieId") int id) {
		Movie movie = movieService.findById(id);
		String path = movie.getImageLocation();
		File file = new File(path);
		file.delete();
		// Delete the code record
		movieService.deleteById(id);
		
		return "redirect:/movies/list";
	}
	
}
