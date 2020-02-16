package com.toumb.movielibrary.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toumb.movielibrary.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
