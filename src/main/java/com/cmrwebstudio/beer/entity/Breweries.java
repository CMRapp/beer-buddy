package com.cmrwebstudio.beer.entity;

import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Breweries {
	
	private int breweryId;
	private String breweryName;
	private String country;
	private String website;
	
	public int compareTo(Breweries that) {
		return Comparator
				.comparing(Breweries::getBreweryId)
				.compare(this,  that);
	}
}
