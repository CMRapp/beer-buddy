package com.cmrwebstudio.beer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cmrwebstudio.beer.entity.Distributor;
import com.cmrwebstudio.beer.entity.DistributorPostRequest;
import com.cmrwebstudio.beer.service.PostDistributorService;

import lombok.extern.slf4j.Slf4j;

/** The DefaultDisplayReviewsController class implements the corresponding controller
 *  It calls the controller and passes data to it for processing.
 *  
 *  The RestController annotation is used to indicate that this controller is used for REST requests
 *  Lombok logging is enabled using the Slf4j annotation.
 *  
 *  @author cmrap *
 */

@RestController
@Slf4j

public class DefaultDistributorPostController implements DistributorPostController {

	@Autowired
	private PostDistributorService postDistributorService;
	
	@Override
	public Distributor createDistributor(DistributorPostRequest distributorPostRequest) {
		log.debug("Retreiving distributor with ID = {} ", distributorPostRequest);
		return postDistributorService.createDistributor(distributorPostRequest);
	}
}
