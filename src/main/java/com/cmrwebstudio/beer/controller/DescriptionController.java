package com.cmrwebstudio.beer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beer.entity.CatDescription;
import com.cmrwebstudio.beer.entity.Category;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/cat_desc")

public interface DescriptionController {

	// @formatter: off
			@Operation(
				summary = "Returns category descriptions",
				description = "Returns a category description based category name",
				responses = {
						@ApiResponse(
								responseCode = "200", 
								description = "A category Description is returned.", 
								content = @Content(mediaType = "application/json", 
								schema = @Schema(implementation = CatDescription.class))),
							@ApiResponse(
								responseCode = "400", 
								description = "The request parameters are invalid.", 
								content = @Content(mediaType = "application/json")),
							@ApiResponse(
								responseCode = "404", 
								description = "No descriptions were found with the input criteria.", 
								content = @Content(mediaType = "application/json")),
							@ApiResponse(
								responseCode = "500", 
								description = "An unplanned error occurred.", 
								content = @Content(mediaType = "application/json"))
						},
						parameters = {
								@Parameter(
									name = "Category Name", 
									allowEmptyValue = false, 
									required = false, 
									description = "Select Category")
				}
			)
				
			@GetMapping
			@ResponseStatus(code = HttpStatus.OK)
			List<CatDescription> fetchDescription(
					@RequestParam(required = false)	Category category);
			
			// @formatter:on
}

