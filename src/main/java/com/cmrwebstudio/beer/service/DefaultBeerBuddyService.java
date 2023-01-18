package com.cmrwebstudio.beer.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmrwebstudio.beer.dao.BeerBuddyDao;
import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Flavor;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBeerBuddyService implements BeerBuddyService {

	
	@Autowired
	private BeerBuddyDao beerBuddyDao;
	
	@Override
	public List<Beer> fetchBeers(Category category, Flavor flavor) {
		log.info("The fetchBeers method was called with category = {} and flavor = {}", category, flavor);
		
		List<Beer> beers = beerBuddyDao.fetchBeers(category, flavor);
		
		Collections.sort(beers);
		return beers;
	}

}
