package com.cmrwebstudio.beer.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
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
import com.cmrwebstudio.beer.entity.Review;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

class CreateReviewTest extends CreateReviewTestSupport {

	@Autowired
	  private JdbcTemplate jdbcTemplate;

	  @LocalServerPort
	  private int serverPort;

	  @Autowired
	  private TestRestTemplate restTemplate;

	  @Test
	  void test() {
	    // Given: a review as JSON
	    int numReviews = JdbcTestUtils.countRowsInTable(jdbcTemplate, "reviews");
	    System.out.println("Num Rows = " + numReviews);
	    String body = createReviewBody();
	    String uri = getBaseUriForReviews();

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<String> bodyEntity = new HttpEntity<String>(body, httpHeaders);

	    // When: the review is sent
	    ResponseEntity<Review> response =
	        restTemplate.exchange(uri, HttpMethod.POST, bodyEntity, Review.class);
	    
	  //Then: a 201 status is returned
	  		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	  		
	  		//AND: the returned review is correct
	  		assertThat(response.getBody()).isNotNull();
	  		
	  		Review review = response.getBody();
	  		assertThat(review.getBeerId()).isEqualTo(3);
	  		assertThat(review.getBeerName()).isEqualTo("St-Ambroise Baltic Porter");
	  		assertThat(review.getReviewerName()).isEqualTo("Strangebrewer");
	  		assertThat(review.getRating()).isEqualTo(3);
	  		assertThat(review.getReview()).isEqualTo("Poured deep brown with a creamy tan head. Roasty malt aroma with a licorice note. Full bodied, tight carbonation with a slick mouthfeel. Flavours of heavily roasted malt, slightly burnt but sweet, notes of molasses, raisin, coffee, cocoa, a bit tart.");
	  		
	  		//test to make sure row has been added to reviews table
	  		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "reviews")).isEqualTo(numReviews + 1);
	  }
	
}
