package com.cmrwebstudio.beer.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Reviews {
	private int reviewPK;
	private int beerId;
	private String reviewerName;
	
	@Positive
	@Min(1)
	@Max(5)
	private int rating;
	
	@NotNull
	private String review;
	
	@JsonIgnore
	public int getReviewPk() {
		return reviewPK;
	}
}
