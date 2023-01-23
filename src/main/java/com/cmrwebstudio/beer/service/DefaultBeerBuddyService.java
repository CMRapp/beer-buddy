package com.cmrwebstudio.beer.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmrwebstudio.beer.dao.BeerBuddyDao;
import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBeerBuddyService implements BeerBuddyService {

	
	@Autowired
	private BeerBuddyDao beerBuddyDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Beer> fetchBeers(Category category, String flavor) {
		log.info("The fetchBeers method was called with category = {} and flavor = {}", category, flavor);
		
		List<Beer> beers = beerBuddyDao.fetchBeers(category, flavor);
		
		if(beers.isEmpty() ) {
			String msg = String.format("No beers found with category = %s and flavor = %s", category, flavor);
			throw new NoSuchElementException(msg);
		}
		Collections.sort(beers);
		return beers;
	}

}
