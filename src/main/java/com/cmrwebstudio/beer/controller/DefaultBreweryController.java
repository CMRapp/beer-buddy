package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cmrwebstudio.beer.entity.Breweries;
import com.cmrwebstudio.beer.service.BeerBuddyService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultBreweryController implements BreweryController {

	@Autowired
	private BeerBuddyService beerBuddyService;
	
	@Override
	public List<Breweries> fetchBrewery(int brewery) {
		log.debug("Retreiving brewery with id = {} ", brewery);
		return beerBuddyService.fetchBrewery(brewery);
	}
}
