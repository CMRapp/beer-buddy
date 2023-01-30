package com.cmrwebstudio.beer.dao;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.cmrwebstudio.beer.entity.Reviews;

public interface ReviewRequestDao {

	Optional<Reviews> fetchReview(int beerId);

	Reviews saveReview(int beerId, String reviewerName, int rating, String review);
	
}
