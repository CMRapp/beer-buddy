package com.cmrwebstudio.beer.controller.support;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.entity.Flavor;

public class FetchBeerTestSupport extends BaseTest {

	protected List<Beer> buildExpected() {
		List<Beer> list = new LinkedList<>();
		
		// @formatter:off
			list.add(Beer.builder()
					.beerId(1)
					.breweryId(812)
					.name("Hocus Pocus")
					.categoryId(Category.OTHER_CATEGORY)
					.styleId(116)
					.abv(4.5)
					.ibu(0.0)
					.flavorProfile(Flavor.CRISP)
					.build());
			
//			list.add(Beer.builder()
//					.beer_id(213)
//					.brewery_id(779)
//					.name("Black Jack Porter")
//					.category_id(2)
//					.style_id(25)
//					.abv(0.0)
//					.ibu(0.0)
//					.flavor_profile(0)
//					.build());
		// @formatter:on
		
	Collections.sort(list);		
	return list;
	}
}
