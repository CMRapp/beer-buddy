package com.cmrwebstudio.beer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cmrwebstudio.beer.entity.ReviewRequest;
import com.cmrwebstudio.beer.entity.Review;
import com.cmrwebstudio.beer.service.ReviewRequestService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultReviewRequestController implements ReviewRequestController {

	@Autowired
	private ReviewRequestService reviewRequestService;
	
	@Override
	public Review createReview(ReviewRequest reviewRequest) {
		log.debug("Review = {}",reviewRequest);
		return reviewRequestService.createReview(reviewRequest);
	}

}
