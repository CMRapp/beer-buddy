package com.cmrwebstudio.beer.service;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;

public interface BeerBuddyService {

	/**
	 * 
	 * @param beer_id
	 * @return
	 */
	List<Beer> fetchBeers(int beer_id);

}
