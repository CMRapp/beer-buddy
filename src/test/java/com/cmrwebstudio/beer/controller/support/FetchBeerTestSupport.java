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
					.beerId(3)
					.breweryId(4)
					.beerName("St-Ambroise Baltic Porter")
					.category(Category.PORTER)
					.abv(8.2)
					.ibu(38)
					.beerDesc("St-Ambroise Baltic Porter combines what is best of the British-style"
							+ " porters and the sweeter Russian Imperial Stouts brewed in countries on the Baltic Sea."
							+ " This smooth, full-bodied tribute to those beers has a rich malt flavour with "
							+ "concentrated caramel highlights along with notes of chocolate, liquorce and dark fruit.")
					.build());
		// @formatter:on
			
	Collections.sort(list);		
	return list;
	}
	
	/**
	 * 
	 * @param error
	 * @param status
	 */
	protected void assertErrorMessageValid(Map<String, Object> error, HttpStatus status) {
		// @formatter:off
			assertThat(error)
				.containsKey("message")
				.containsEntry("status code", status.value())
				.containsEntry("uri", "/beers")
				.containsKey("timestamp")
				.containsEntry("reason", status.getReasonPhrase());
			// @formatter:on
	}
}
