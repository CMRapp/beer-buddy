package com.cmrwebstudio.beer.dao;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;

public interface BeerBuddyDao {

	/**
	 * 
	 * @param category
	 * @param flavor
	 * @return
	 */
	
	List<Beer> fetchBeers(Category category, String flavor);

}
