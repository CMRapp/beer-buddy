package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beer.entity.Beer;
import com.cmrwebstudio.beer.entity.Category;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;


@RequestMapping("/beers")

// configure swagger OpenAPI for testing 
@OpenAPIDefinition(info = @Info(title = "Beer Buddy World Beer Guide"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})


// This interface configures the swagger OpenAPI documentation
public interface BeerBuddyController {
	// @formatter: off
	@Operation(
		summary = "Returns a list of beers given a beer category",
		description = "Returns a list of beers given a beer category",
		responses = {
				@ApiResponse(
						responseCode = "200", 
						description = "A list of beers is returned.", 
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
							name = "category", 
							allowEmptyValue = false, 
							required = true, 
							description = "Select Beer Category")
		}
	)
		
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<Beer> fetchBeers(
			@RequestParam(required = false)	Category category);
	
	// @formatter:on
	
}
