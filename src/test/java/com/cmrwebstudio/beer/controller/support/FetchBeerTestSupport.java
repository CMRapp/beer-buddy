package com.cmrwebstudio.beer.controller.support;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
}
