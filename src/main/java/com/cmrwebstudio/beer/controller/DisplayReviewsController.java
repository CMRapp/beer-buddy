package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Reviews;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/reiews")
public interface DisplayReviewsController {

	// @formatter: off
	@Operation(
		summary = "Returns beer reviews",
		description = "Returns beer reviews based on beer id#",
		responses = {
				@ApiResponse(
						responseCode = "200", 
						description = "A beer review is returned.", 
						content = @Content(mediaType = "application/json", 
						schema = @Schema(implementation = Beer.class))),
					@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid.", 
						content = @Content(mediaType = "application/json")),
					@ApiResponse(
						responseCode = "404", 
						description = "No beers were found with the input criteria.", 
						content = @Content(mediaType = "application/json")),
					@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))
				},
				parameters = {
						@Parameter(
							name = "Beer Reviews", 
							allowEmptyValue = false, 
							required = false, 
							description = "Beer Id 1 thru 14")
		}
	)
		
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Reviews> fetchReviews(
			@RequestParam(required = false)	int beerId);
	
	// @formatter:on


}
