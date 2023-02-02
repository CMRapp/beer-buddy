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

import com.cmrwebstudio.beer.controller.support.DistributorPostTestSupport;
import com.cmrwebstudio.beer.entity.Distributor;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")

class DistributorPostTest extends DistributorPostTestSupport {

	@Autowired
	  private JdbcTemplate jdbcTemplate;

	  @LocalServerPort
	  private int serverPort;

	  @Autowired
	  private TestRestTemplate restTemplate;

	  @Test
	  void test() {
	    // Given: a review as JSON
	    int numDists = JdbcTestUtils.countRowsInTable(jdbcTemplate, "distributors");
	    String body = createDistributorBody();
	    String uri = getBaseUriForDistributors();

	    HttpHeaders httpHeaders = new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<String> bodyEntity = new HttpEntity<String>(body, httpHeaders);

	    // When: the review is sent
	    ResponseEntity<Distributor> response =
	        restTemplate.exchange(uri, HttpMethod.POST, bodyEntity, Distributor.class);
	    
	    //Then: a 201 status is returned
  		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
  		
  		//AND: the returned review is correct
  		assertThat(response.getBody()).isNotNull();
  		
  		Distributor distributor = response.getBody();
  		assertThat(distributor.getDist_name()).isEqualTo("Drizly");
  		assertThat(distributor.getWebsite()).isEqualTo("https://drizly.com");
  		
  		//test row added to distributor table
  		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "distributors")).isEqualTo(numDists + 1);
  		
	  }

	 }

