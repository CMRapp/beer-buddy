package com.cmrwebstudio.beer.controller.support;

public class CreateReviewTestSupport extends BaseTest {

	/**
	 * 
	 * @return
	 */
protected String createReviewBody() {
	// @formatter:off
	return "{\n"
			+ "    \"beerId\": 3,\n"
			+ "    \"reviewerName\": \"Raistlin\",\n"
			+ "    \"rating\": 4,\n"
			+ "    \"review\": \"Pours black with tan head that stays and leaves bit of lacing behind. Aroma of fermented fruit. Taste of dark fruit with dark chocolate finish. Hides alcohol well. Soft carbonation with medium to heavy body.\""
			+ "}\n"
			+ "";
	// @formatter:on
	}
}
