package com.cmrwebstudio.beer.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//This is a Data Transfer Object (DTO)

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {
	
	@NotNull
	private int beerId;
	
	@Length(max = 50)
	@Pattern(regexp = "[\\w\\s]*")
	private String reviewerName;

	@NotNull
	@Positive
	@Min(1)
	@Max(4)
	private int rating;

	@NotNull
	private String review;

	}
