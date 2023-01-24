package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beer.entity.Breweries;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/** The BreweryController interface formats the swagger/OpenAPI Documentation
 *  The BreweryController returns a list of breweries from the database.
 *  The option is available to view one brewery by ID or view ALL
 *  
 *  The RequestMapping annotation is used to inform Spring the following data will be mapped
 *  to the URI listed
 *  @author cmrap *
 */
@RequestMapping("/breweries")

public interface BreweryController {

	// @formatter: off
			@Operation(
				summary = "Returns a list of breweries",
				description = "Returns a list of breweries given a brewery ID",
				responses = {
						@ApiResponse(
								responseCode = "200", 
								description = "A list of breweries is returned.", 
								content = @Content(mediaType = "application/json", 
								schema = @Schema(implementation = Breweries.class))),
							@ApiResponse(
								responseCode = "400", 
								description = "The request parameters are invalid.", 
								content = @Content(mediaType = "application/json")),
							@ApiResponse(
								responseCode = "404", 
								description = "No breweries were found with the input criteria.", 
								content = @Content(mediaType = "application/json")),
							@ApiResponse(
								responseCode = "500", 
								description = "An unplanned error occurred.", 
								content = @Content(mediaType = "application/json"))
						},
						parameters = {
								@Parameter(
									name = "Brewery ID", 
									allowEmptyValue = false, 
									required = false, 
									description = "Enter ID 1 thru 4 | 0 For ALL")
				}
			)
				
			@GetMapping
			@ResponseStatus(code = HttpStatus.OK)
			List<Breweries> fetchBrewery(
					@RequestParam(required = false)	int brewery);
			
			// @formatter:on

}
