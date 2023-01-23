package com.cmrwebstudio.beer.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doThrow;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.cmrwebstudio.beer.Constants;
import com.cmrwebstudio.beer.controller.support.FetchBeerTestSupport;
import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;
import com.cmrwebstudio.beer.service.BeerBuddyService;



class FetchBeerTest extends FetchBeerTestSupport {
	
	@Nested
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@ActiveProfiles("test")
	class TestsThatDoNotPolluteTheApplicationContext extends FetchBeerTestSupport {
		
		@Disabled
		@Test
		void testThatBeersAreReturnedWhenValidDataIsSupplied() {
				
			//Given a valid category, profile and URI
			Category category = Category.LAGER;
			String flavor = "Hoppy";
			
			String uri = String.format("%s?category=%s&flavor=%s", getBaseUri(), category, flavor);	
			
			//When a connection is made to the URI
			ResponseEntity<List<Beer>> response = getRestTemplate().exchange
					(uri, HttpMethod.GET, null,	new ParameterizedTypeReference<>() {});
			
			//Then: a success (OK - 200) status code is returned
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
			
			// And: The actual list is the same as the expected list
			List<Beer> expected = buildExpected();
			assertThat(response.getBody()).isEqualTo(expected);
		}
		
		/**
		 * 
		 */
		@Disabled
		@Test
		void testThatErrorMessageIsReturnedWhenUnknownValueIsSupplied() {
			
			//Given a valid category, profile and URI
			Category category = Category.LAGER;
			String flavor = "Unknown Value";
			
			String uri = String.format("%s?category=%s&flavor=%s", getBaseUri(), category, flavor);	
			
			//When a connection is made to the URI
			ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<>() {});
			
			//Then: a not found (404) status code is returned
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
			
			// And: an error message is returned
			Map<String, Object> error = response.getBody();
			
			assertErrorMessageValid(error,HttpStatus.NOT_FOUND);
		}
		
		@Disabled
		@ParameterizedTest
		@MethodSource("com.cmrwebstudio.beer.controller.FetchBeerTest#parametersForInvalidInput")
		void testThatErrorMessageIsReturnedWhenInvalidValueIsSupplied(
			String category, String flavor, String reason) {
			
			//Given a valid category, profile and URI
			String uri = String.format("%s?category=%s&flavor=%s", getBaseUri(), category, flavor);	
			
			//When a connection is made to the URI
			ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<>() {});
			
			//Then: a not found (400) status code is returned
			//assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
			
			// And: an error message is returned
			Map<String, Object> error = response.getBody();
			
			//assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);
		}
	}

	static Stream<Arguments> parametersForInvalidInput() {
	// @formatter:off
	return Stream.of(
			arguments("PILSNER", "@#$%^&&%", "Flavor contains non-alpha-numeric-chars."),
			arguments("PILSNER", "P".repeat(Constants.TRIM_MAX_LENGTH + 1), "Flavor length too long."),
			arguments("BAD CATEGORY", "Hoppy", "Category is not ENUM value.")
			);
	// @formatter:on
	}
	
	@Nested
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@ActiveProfiles("test")
	class TestsThatPolluteTheApplicationContext extends FetchBeerTestSupport {
		@MockBean
		private BeerBuddyService beerBuddyService;
		
		@Test
		void testThatAnUnplannedErorResultsInA500Status() {
			
			//Given a valid category, profile and URI
			Category category = Category.LAGER;
			String flavor = "Invalid";			
			String uri = String.format("%s?category=%s&flavor=%s", getBaseUri(), category, flavor);	
			
			doThrow(new RuntimeException("Uh-oh!")).when(beerBuddyService).fetchBeers(category, flavor);
			
			//When a connection is made to the URI
			ResponseEntity<Map<String, Object>> response = getRestTemplate().exchange(uri, HttpMethod.GET, null,
					new ParameterizedTypeReference<>() {});
			
			//Then: an internal server error (500) is returned
			assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
			
			// And: an error message is returned
			Map<String, Object> error = response.getBody();
			
			assertErrorMessageValid(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
