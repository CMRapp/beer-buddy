package com.cmrwebstudio.beer.dao;

import java.util.Optional;


import com.cmrwebstudio.beer.entity.Review;

public interface ReviewRequestDao {

	Optional<Review> fetchReview(int beerId, String beerName);

	Review saveReview(int beerId, String beerName, String reviewerName, int rating, String review);

		
}
