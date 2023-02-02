package com.cmrwebstudio.beer.dao;

import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Breweries;
import com.cmrwebstudio.beer.entity.CatDescription;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Review;

/** The BeerBuddyDao interface calls the methods of the controllers.
 *  
 *  
 *  @author cmrap *
 */
public interface BeerBuddyDao {

	/**
	 * 
	 * @param category
	 * @return
	 */
	
	List<Beer> fetchBeers(Category category);

	List<Breweries> fetchBrewery(int breweryPk);
	
	List<CatDescription> fetchDescription(Category category);

	List<Beer> fetchBeerDetails(int beerId);

	List<Review> fetchReviews(int beerId);


	

}
