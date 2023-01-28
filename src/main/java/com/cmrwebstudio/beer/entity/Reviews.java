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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Reviews {
	@NotNull
	int reviewPK;
	
	@NotNull
	int beerId;
	
	@NotNull
	@Length(max=30)
	@Pattern(regexp = "[\\w\\s]*")
	String reviewerName;
	
	@Positive
	@Min(1)
	@Max(5)
	int rating;
	
	@NotNull
	String review;
}
