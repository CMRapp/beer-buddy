package com.cmrwebstudio.beer.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beer.entity.Distributor;
import com.cmrwebstudio.beer.entity.DistributorPostRequest;
import com.cmrwebstudio.beer.entity.Review;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/distributors")

//configure swagger OpenAPI for testing 
@OpenAPIDefinition(info = @Info(title = "Beer Buddy World Beer Guide"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface DistributorPostController {

	// @formatter: off
	@Operation(
		summary = "Create a distributor for a beer",
		description = "Returns the created distributor",
		responses = {
				@ApiResponse(
						responseCode = "201", 
						description = "The created distributor is returned.", 
						content = @Content(mediaType = "application/json", 
						schema = @Schema(implementation = Review.class))),
					@ApiResponse(
						responseCode = "400", 
						description = "The request parameters are invalid.", 
						content = @Content(mediaType = "application/json")),
					@ApiResponse(
						responseCode = "404", 
						description = "NA review was not found with the input criteria.", 
						content = @Content(mediaType = "application/json")),
					@ApiResponse(
						responseCode = "500", 
						description = "An unplanned error occurred.", 
						content = @Content(mediaType = "application/json"))
				},
				parameters = {
						@Parameter(
							name = "New Distributor",  
							required = true, 
							description = "The distributor as JSON")
		}
	)
		
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	Distributor createDistributor(@Valid @RequestBody DistributorPostRequest distributorPostRequest);
	
	// @formatter:on


}
