package com.cmrwebstudio.beer.controller.support;

public class DistributorPostTestSupport extends BaseTest {

	/**
	 * 
	 * @return
	 */
protected String createDistributorBody() {
	// @formatter:off
	return "{\n"
			+ "  \"dist_name\": \"Drizly\",\n"
			+ "  \"website\": \"https://drizly.com\"\n"
			+ "}\n"
			+ "";
	// @formatter:on
	}
}
