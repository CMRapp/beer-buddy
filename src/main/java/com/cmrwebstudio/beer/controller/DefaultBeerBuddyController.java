package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.service.BeerBuddyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultBeerBuddyController implements BeerBuddyController {

	@Autowired
	private BeerBuddyService beerBuddyService;
	
	@Override
	public List<Beer> fetchBeers(int beer_id) {		
		log.debug("beer_id = {}", beer_id);
		return beerBuddyService.fetchBeers(beer_id);
	}

}
