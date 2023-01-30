package com.cmrwebstudio.beer.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.jdbc.JdbcTestUtils;

import com.cmrwebstudio.beer.controller.support.CreateReviewTestSupport;
import com.cmrwebstudio.beer.entity.Reviews;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

class CreateReviewTest extends CreateReviewTestSupport {

	@Autowired 
	private JdbcTemplate jdbcTemplate;
	int numRowsReviews = JdbcTestUtils.countRowsInTable(jdbcTemplate, "reviews");
	
	/**
	 * 
	 */
	@Test
	void testCreateReviewReturnSuccess201(){
		 System.out.println("Num Rows = " + numRowsReviews);
		
		// Given: a review as JSON
		String body = createReviewBody();
		String uri = getBaseUriForReviews();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
		
		//When: the review is sent
		ResponseEntity<Reviews> response = getRestTemplate().exchange(uri, HttpMethod.POST, 
				bodyEntity, Reviews.class);
		
		//Then: a 201 status is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		//AND: the returned review is correct
		assertThat(response.getBody()).isNotNull();
		
		Reviews reviews = response.getBody();
		assertThat(reviews.getBeerId()).isEqualTo(3);
		assertThat(reviews.getReviewerName()).isEqualTo("Strangebrewer");
		assertThat(reviews.getRating()).isEqualTo(3);
		assertThat(reviews.getReview()).isEqualTo("Poured deep brown with a creamy tan head. Roasty malt aroma with a licorice note. Full bodied, tight carbonation with a slick mouthfeel. Flavours of heavily roasted malt, slightly burnt but sweet, notes of molasses, raisin, coffee, cocoa, a bit tart.");
		
		//test to make sure row has been added to reviews table
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "reviews")).isEqualTo(numRowsReviews + 1);
	}
	
}
