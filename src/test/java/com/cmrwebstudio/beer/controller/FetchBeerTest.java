package com.cmrwebstudio.beer.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cmrwebstudio.beer.controller.support.FetchBeerTestSupport;
import com.cmrwebstudio.beer.entity.Beer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FetchBeerTest extends FetchBeerTestSupport {

	@Test
	void testThatBeersAreReturnedWhenValidDataIsSupplied() {
		
		//Given a valid beer id and URI
		int beer_id = 1;
		String uri = String.format("%s?beer_id=%s", getBaseUri(), beer_id);
		
		//When a connection is made to the URI
		ResponseEntity<Beer> response = getRestTemplate().getForEntity(uri, Beer.class);
		
		//Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
