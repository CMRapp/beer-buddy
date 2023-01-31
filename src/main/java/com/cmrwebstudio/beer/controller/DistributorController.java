package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beer.entity.Distributor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@RequestMapping("/distributors")

//configure swagger OpenAPI for testing 
@OpenAPIDefinition(info = @Info(title = "Beer Buddy World Beer Guide"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface DistributorController {

	// @formatter: off
	@Operation(
		summary = "Returns beer distributors",
		description = "Returns beer distributors based on beer id#",
		responses = {
				@ApiResponse(
						responseCode = "200", 
						description = "A beer review is returned.", 
						content = @Content(mediaType = "application/json", 
						schema = @Schema(implementation = Distributor.class))),
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
	List<Distributor> fetchDistributor(String dist_name);
	
	// @formatter:on


}
