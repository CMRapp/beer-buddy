package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.cmrwebstudio.beer.entity.Beer;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class DefaultBeerBuddyController implements BeerBuddyController {

	@Override
	public List<Beer> fetchBeers(int beer_id) {
		
		log.debug("beer_id = {}", beer_id);
		return null;
	}

}
