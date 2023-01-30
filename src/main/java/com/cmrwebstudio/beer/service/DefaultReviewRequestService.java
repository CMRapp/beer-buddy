package com.cmrwebstudio.beer.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmrwebstudio.beer.dao.ReviewRequestDao;
import com.cmrwebstudio.beer.entity.ReviewRequest;
import com.cmrwebstudio.beer.entity.Review;

@Service
public class DefaultReviewRequestService implements ReviewRequestService {

	@Autowired
	private ReviewRequestDao reviewRequestDao;

	@Transactional
	@Override
	public Review createReview(ReviewRequest reviewRequest) {
		
		int beerId = getReview(reviewRequest).getBeerId();
		String beerName = getReview(reviewRequest).getBeerName();
		String reviewerName = getReview(reviewRequest).getReviewerName();
		int rating = getReview(reviewRequest).getRating();
		String review = getReview(reviewRequest).getReview();
		System.out.println("DAO: beer name = "+beerName);
		return reviewRequestDao.saveReview(beerId, beerName, reviewerName, rating, review);
	}

	/**
	 * 
	 * @param reviewRequest
	 * @return
	 */
	protected Review getReview(ReviewRequest reviewRequest) {
		return reviewRequestDao.fetchReview(reviewRequest.getBeerId(), reviewRequest.getBeerName())
				.orElseThrow(() -> new NoSuchElementException("Review for beer with ID = "
				+ reviewRequest.getBeerId()+ " was not found."));
	}

}
