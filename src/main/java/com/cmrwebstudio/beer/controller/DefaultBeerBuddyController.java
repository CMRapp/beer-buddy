package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.service.BeerBuddyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultBeerBuddyController implements BeerBuddyController {

	@Autowired
	private BeerBuddyService beerBuddyService;
	
	
	@Override
	public List<Beer> fetchBeers(Category category) {
		log.debug("Retreiving beers with category = {} ", category);
		return beerBuddyService.fetchBeers(category);
		
	}

}
