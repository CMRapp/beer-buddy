package com.cmrwebstudio.beer.service;

import org.springframework.stereotype.Service;

import com.cmrwebstudio.beer.entity.ReviewRequest;
import com.cmrwebstudio.beer.entity.Reviews;

@Service
public interface ReviewRequestService {

	Reviews createReview(ReviewRequest reviewRequest);

}
