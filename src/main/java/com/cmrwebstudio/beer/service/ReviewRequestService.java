package com.cmrwebstudio.beer.service;

import org.springframework.stereotype.Service;

import com.cmrwebstudio.beer.entity.ReviewRequest;
import com.cmrwebstudio.beer.entity.Review;

@Service
public interface ReviewRequestService {

	Review createReview(ReviewRequest reviewRequest);

}
