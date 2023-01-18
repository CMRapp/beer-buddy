package com.cmrwebstudio.beer.dao;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Flavor;

public interface BeerBuddyDao {

	/**
	 * 
	 * @param beer_id
	 * @return
	 */
	
	List<Beer> fetchBeers(Category category, Flavor flavor);

}
