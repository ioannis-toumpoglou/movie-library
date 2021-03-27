package com.toumb.movielibrary.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toumb.movielibrary.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	// Add a method to sort records by title
	public List<Movie> findAllByOrderByTitleAsc();

}
