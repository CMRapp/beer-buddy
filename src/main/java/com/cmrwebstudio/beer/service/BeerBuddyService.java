package com.cmrwebstudio.beer.service;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Flavor;

public interface BeerBuddyService {

	/**
	 * 
	 * @param beer_id
	 * @return
	 */
	
	List<Beer> fetchBeers(Category category, Flavor flavor);

}
