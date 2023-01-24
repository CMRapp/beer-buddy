package com.cmrwebstudio.beer.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmrwebstudio.beer.dao.BeerBuddyDao;
import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Breweries;
import com.cmrwebstudio.beer.entity.Category;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBeerBuddyService implements BeerBuddyService {

	
	@Autowired
	private BeerBuddyDao beerBuddyDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Beer> fetchBeers(Category category) {
		log.info("The fetchBeers method was called with category = {} and flavor = {}", category);
		
		List<Beer> beers = beerBuddyDao.fetchBeers(category);
		
		if(beers.isEmpty() ) {
			String msg = String.format("No beers found with category = %s and flavor = %s", category);
			throw new NoSuchElementException(msg);
		}
		Collections.sort(beers);
		return beers;
	}

	@Override
	public List<Breweries> fetchBrewery(int brewery) {
		log.info("The fetchBrewery method was called with id = {}", brewery);
		
		List<Breweries> breweries = beerBuddyDao.fetchBrewery(brewery);
		System.out.println(brewery);
		if(breweries.isEmpty() ) {
			String msg = String.format("No breweries found with ID = %s", brewery);
			throw new NoSuchElementException(msg);
		}
		
		return breweries;
	}

}
