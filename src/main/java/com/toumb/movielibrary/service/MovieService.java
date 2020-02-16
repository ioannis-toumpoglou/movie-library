package com.toumb.movielibrary.service;

import java.util.List;

import com.toumb.movielibrary.entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	
	public Movie findById(int id);
	
	public void save(Movie movie);
	
	public void deleteById(int id);

}