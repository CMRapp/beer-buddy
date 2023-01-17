package com.cmrwebstudio.beer.dao;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;

public interface BeerBuddyDao {

	/**
	 * 
	 * @param beer_id
	 * @return
	 */
	List<Beer> fetchBeers(int beer_id);

}
