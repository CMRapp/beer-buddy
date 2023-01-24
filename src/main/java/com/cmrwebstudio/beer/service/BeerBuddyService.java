package com.cmrwebstudio.beer.service;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Breweries;
import com.cmrwebstudio.beer.entity.CatDescription;
import com.cmrwebstudio.beer.entity.Category;

public interface BeerBuddyService {

	/**
	 * 
	 * @param category
	 * @param flavor
	 * @return
	 */
	
	List<Breweries> fetchBrewery(int brewery);

	List<Beer> fetchBeers(Category category);

	List<CatDescription> fetchDescription(Category category);

	List<Beer> fetchBeerDetails(int beerId);

}
