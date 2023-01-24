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

public class Beer implements Comparable<Beer> {
	private int beerId;		// primary key
	private int breweryId;	// foreign key
	private String name;
	private Category category;
	private double abv;
	private int ibu;
	private String beerDesc;
	private String flavorProfile;
	

	@Override
	public int compareTo(Beer that) {
		return Comparator
				.comparing(Beer::getBeerId)
				.compare(this,  that);
	}
	
}
