package com.cmrwebstudio.beer.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmrwebstudio.beer.dao.BeerBuddyDao;
import com.cmrwebstudio.beer.entity.Beer;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBeerBuddyService implements BeerBuddyService {

	
	@Autowired
	private BeerBuddyDao beerBuddyDao;
	
	@Override
	public List<Beer> fetchBeers(int beer_id) {
		log.info("The fetchBeers method was called with id = {}", beer_id);
		
		List<Beer> beers = beerBuddyDao.fetchBeers(beer_id);
		
		Collections.sort(beers);
		return beers;
	}

}
