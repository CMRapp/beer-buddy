package com.cmrwebstudio.beer.service;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;

public interface BeerBuddyService {

	/**
	 * 
	 * @param category
	 * @param flavor
	 * @return
	 */
	
	List<Beer> fetchBeers(Category category, String flavor);

}
