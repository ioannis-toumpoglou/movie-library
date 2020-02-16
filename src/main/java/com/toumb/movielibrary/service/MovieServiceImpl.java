package com.toumb.movielibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toumb.movielibrary.dao.MovieRepository;
import com.toumb.movielibrary.entity.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepository movieRepository;
	
	@Autowired
	public MovieServiceImpl(MovieRepository theMovieRepository) {
		movieRepository = theMovieRepository;
	}
	
	@Override
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Movie findById(int id) {
		Optional<Movie> result = movieRepository.findById(id);
		
		Movie movie = null;
		// Check if the employee exists
		if (result.isPresent()) {
			movie = result.get();
		} else {
			throw new RuntimeException("Unable to find the movie id - " + id);
		}
		
		return movie;
	}

	@Override
	public void save(Movie employee) {
		movieRepository.save(employee);
	}

	@Override
	public void deleteById(int id) {		
		movieRepository.deleteById(id);
	}

}
