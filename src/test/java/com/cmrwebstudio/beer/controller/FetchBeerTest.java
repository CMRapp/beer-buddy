package com.cmrwebstudio.beer.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.cmrwebstudio.beer.controller.support.FetchBeerTestSupport;
import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Flavor;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

class FetchBeerTest extends FetchBeerTestSupport {

	@Test
	void testThatBeersAreReturnedWhenValidDataIsSupplied() {
		
		//Given a valid category, profile and URI
		Category category = Category.NORTH_AMERICAN_ALE;
		Flavor flavor = Flavor.MALTY;
		
		String uri = String.format("%s?category=%s&flavor=%s", getBaseUri(), category, flavor);
				
		//When a connection is made to the URI
		ResponseEntity<List<Beer>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
				new ParameterizedTypeReference<>() {});
		
		//Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		// And: The actual list is the same as the expected list
		List<Beer> expected = buildExpected();
		
		assertThat(response.getBody()).isEqualTo(expected);
	}

	
}
