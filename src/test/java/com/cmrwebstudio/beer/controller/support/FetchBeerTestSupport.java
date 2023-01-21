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
					.beerId(8)
					.breweryId(1099)
					.name("Oatmeal Stout")
					.categoryId(Category.NORTH_AMERICAN_ALE)
					.styleId(42)
					.abv(5.0)
					.ibu(0)
					.flavorProfile(Flavor.MALTY)
					.build());
			
//			list.add(Beer.builder()
//					.beerId(213)
//					.breweryId(779)
//					.name("Black Jack Porter")
//					.categoryId(Category.IRISH_ALE)
//					.styleId(25)
//					.abv(0.0)
//					.ibu(0)
//					.flavorProfile(Flavor.MALTY)
//					.build());
		// @formatter:on
		
	Collections.sort(list);		
	return list;
	}
}
