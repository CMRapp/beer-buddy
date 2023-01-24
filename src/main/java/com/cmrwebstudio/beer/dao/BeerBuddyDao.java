package com.cmrwebstudio.beer.dao;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Breweries;
import com.cmrwebstudio.beer.entity.CatDescription;
import com.cmrwebstudio.beer.entity.Category;

public interface BeerBuddyDao {

	/**
	 * 
	 * @param category
	 * @return
	 */
	
	List<Beer> fetchBeers(Category category);

	List<Breweries> fetchBrewery(int breweryPk);
	
	List<CatDescription> fetchDescription(Category category);
	

}
