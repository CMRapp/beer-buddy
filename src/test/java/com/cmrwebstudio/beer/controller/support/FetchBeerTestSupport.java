package com.cmrwebstudio.beer.controller.support;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;

public class FetchBeerTestSupport extends BaseTest {

	protected List<Beer> buildExpected() {
		List<Beer> list = new LinkedList<>();
		
		// @formatter:off
			list.add(Beer.builder()
					.beerId(4)
					.breweryId(3)
					.name("Samuel Adams Boston Lager")
					.categoryId(Category.LAGER)
					.abv(5.0)
					.ibu(30)
					.flavorProfile("Hoppy")
					.build());
		// @formatter:on
		
	Collections.sort(list);		
	return list;
	}
	
	protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
		// @formatter: on
		assertThat(error)
			.containsKey("message")
			.containsEntry("status code", status.value())
			.containsEntry("uri", "/beers")
			.containsKey("timestamp")
			.containsEntry("reason", status.getReasonPhrase());
		// @formatter:off
	}
}
