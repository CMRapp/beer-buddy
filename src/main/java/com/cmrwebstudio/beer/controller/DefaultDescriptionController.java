package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cmrwebstudio.beer.entity.CatDescription;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.service.BeerBuddyService;

import lombok.extern.slf4j.Slf4j;

/** The DefaultDescriptionController class implements the corresponding controller
 *  It calls the controller and passes data to it for processing.
 *  
 *  The RestController annotation is used to indicate that this controller is used for REST requests
 *  Lombok logging is enabled using the Slf4j annotation.
 *  
 *  @author cmrap *
 */
@RestController
@Slf4j

public class DefaultDescriptionController implements DescriptionController {

	@Autowired
	private BeerBuddyService beerBuddyService;
	
	@Override
	public List<CatDescription> fetchDescription(Category category) {
		log.debug("Retreiving category with name = {} ", category);
		return beerBuddyService.fetchDescription(category);
	}

}
