package com.cmrwebstudio.beer.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import lombok.Getter;

public class BaseTest {
	@LocalServerPort
	private int serverPort;
	
	@Autowired
	@Getter
	private TestRestTemplate restTemplate;
	
	/**
	 * 
	 * @return
	 */
	protected String getBaseUriForBeers() {
		return String.format("http://localhost:%d/beers", serverPort);
	}
	
	/**
	 * 
	 * @return
	 */
	protected String getBaseUriForReviews() {
		return String.format("http://localhost:%d/reviews", serverPort);
	}
	
	/**
	 * 
	 * @return
	 */
	protected String getBaseUriForDistributors() {
		return String.format("http://localhost:%d/distributors", serverPort);
	}
}
